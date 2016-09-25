/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valsesia.forum.controllers;

import com.valsesia.forum.models.Topico;
import com.valsesia.forum.models.dao.TopicoDAO;
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
public class TopicoController implements TopicoDAO {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Topico t) throws Exception {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "jvalsesia", "hell0123")) {
            String sql = "INSERT INTO topico (titulo, conteudo, login) VALUES (?, ?, ?);";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, t.getTitulo());
            stm.setString(2, t.getConteudo());
            stm.setString(3, t.getLogin());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.WARNING, ex.getMessage());
            throw new Exception("Nao foi possivel criar topico!");
        }
    }

    @Override
    public List<Topico> listaTopicos() throws Exception {
        List<Topico> topicos = new ArrayList<>();
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "jvalsesia", "hell0123")) {
            String sql = "SELECT * FROM topico";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Topico t = new Topico();
                t.setId_topico(rs.getInt("id_topico"));
                t.setTitulo(rs.getString("titulo"));
                t.setConteudo(rs.getString("conteudo"));
                t.setLogin(rs.getString("login"));
                topicos.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TopicoController.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Nao foi possivel listar topicos!");
        }
        return topicos;
    }

    @Override
    public Topico recuperar(String id_topico) throws Exception {
        Topico t = null;
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "jvalsesia", "hell0123")) {
            String sql = "SELECT * FROM topico WHERE id_topico = ?;";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, Integer.valueOf(id_topico));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                t = new Topico();
                t.setId_topico(rs.getInt("id_topico"));
                t.setTitulo(rs.getString("titulo"));
                t.setConteudo(rs.getString("conteudo"));
                t.setLogin(rs.getString("login"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(TopicoController.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Nao foi possivel recuperar topico!");
        }
        return t;
    }

}
