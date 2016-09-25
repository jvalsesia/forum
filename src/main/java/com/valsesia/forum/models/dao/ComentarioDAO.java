/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valsesia.forum.models.dao;

import com.valsesia.forum.models.Comentario;
import java.util.List;

/**
 *
 * @author jvalsesia
 */
public interface ComentarioDAO {

    //insere um novo comentario no banco de dados
    public void inserir(Comentario c) throws Exception;

    // lista os comentarios adicionados
     public List<Comentario> listaComentarios(String id_topico) throws Exception;
}
