/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valsesia.forum.controllers;

import com.valsesia.forum.models.Comentario;
import com.valsesia.forum.models.dao.ComentarioDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jvalsesia
 */
public class ComentarioController implements ComentarioDAO {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Comentario co) throws Exception {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "jvalsesia", "hell0123")) {
            String sql = "INSERT INTO comentario (comentario, login, id_topico) VALUES (?, ?, ?);";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, co.getComentario());
            stm.setString(2, co.getLogin());
            stm.setInt(3, co.getId_topico());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.WARNING, ex.getMessage());
            throw new Exception("Nao foi possivel criar comentario!");
        }
    }

    @Override
    public List<Comentario> listaComentarios(String id_topico) throws Exception {
        List<Comentario> comentarios = new ArrayList<>();
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "jvalsesia", "hell0123")) {
            String sql = "SELECT * FROM comentario WHERE id_topico = ?;";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, Integer.valueOf(id_topico));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Comentario co = new Comentario();
                co.setId_comentario(rs.getInt("id_comentario"));
                co.setComentario(rs.getString("comentario"));
                co.setLogin(rs.getString("login"));
                co.setId_topico(rs.getInt("id_topico"));
                comentarios.add(co);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TopicoController.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Nao foi possivel listar comentarios!");
        }
        return comentarios;
    }
    

}
