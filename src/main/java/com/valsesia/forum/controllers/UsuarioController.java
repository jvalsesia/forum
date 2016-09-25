/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valsesia.forum.controllers;

import com.valsesia.forum.models.Usuario;
import com.valsesia.forum.models.dao.UsuarioDAO;
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
public class UsuarioController implements UsuarioDAO {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Usuario u) throws Exception {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "jvalsesia", "hell0123")) {
            String sql = "INSERT INTO usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, u.getLogin());
            stm.setString(2, u.getEmail());
            stm.setString(3, u.getNome());
            stm.setString(4, u.getSenha());
            stm.setInt(5, u.getPontos());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.WARNING, ex.getMessage());
            throw new Exception("Nao foi possivel criar usuario!");
        }
    }

    @Override
    public Usuario recuperar(String login) throws Exception {
        Usuario u = null;
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "jvalsesia", "hell0123")) {
            String sql = "SELECT * FROM usuario WHERE login = ?;";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, login);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                u = new Usuario();
                u.setLogin(rs.getString("login"));
                u.setEmail(rs.getString("email"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                u.setPontos(rs.getInt("pontos"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Nao foi possivel recuperar usuario!");
        }
        return u;
    }

    @Override
    public void adicionarPontos(String login, int pontos) throws Exception {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "jvalsesia", "hell0123")) {
            String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?;";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, pontos);
            stm.setString(2, login);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Nao foi possivel adicionar pontos!");
        }
    }

    @Override
    public List<Usuario> ranking() throws Exception {
        List<Usuario> ranking = new ArrayList<>();
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "jvalsesia", "hell0123")) {
            String sql = "SELECT * FROM usuario ORDER BY pontos DESC;";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setLogin(rs.getString("login"));
                u.setEmail(rs.getString("email"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                u.setPontos(rs.getInt("pontos"));
                ranking.add(u);
                 Logger.getLogger(UsuarioDAO.class.getName()).log(Level.INFO, u.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Nao foi possivel mostrar ranking!");
        }
        return ranking;
    }
}
