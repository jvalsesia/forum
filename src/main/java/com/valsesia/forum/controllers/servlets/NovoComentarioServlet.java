/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valsesia.forum.controllers.servlets;

import com.valsesia.forum.controllers.ComentarioController;
import com.valsesia.forum.controllers.UsuarioController;
import com.valsesia.forum.models.Comentario;
import com.valsesia.forum.models.Topico;
import com.valsesia.forum.models.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jvalsesia
 */
@WebServlet(name = "NovoComentarioServlet", urlPatterns = {"/inserircomentario"})
public class NovoComentarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String comentario = request.getParameter("comentario");

        Topico topicoSelecionado = (Topico) request.getSession().getAttribute("topicoSelecionado");
        Usuario usuarioAutenticado = (Usuario) request.getSession().getAttribute("usuarioAutenticado");
        int id_topico = topicoSelecionado.getId_topico();
        String login = usuarioAutenticado.getLogin();
       
        Comentario c = new Comentario();
        c.setComentario(comentario);
        c.setLogin(usuarioAutenticado.getLogin());
        c.setId_topico(id_topico);

        try {
            ComentarioController cc = new ComentarioController();
            cc.inserir(c);
            request.getSession().setAttribute("comentarios", cc.listaComentarios(String.valueOf(id_topico)));
            UsuarioController uc = new UsuarioController();
            uc.adicionarPontos(login, 3);
            request.getRequestDispatcher("exibetopico.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("erro", ex.getMessage());
            request.getRequestDispatcher("exibetopico.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
