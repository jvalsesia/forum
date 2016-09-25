/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valsesia.forum.models.dao;

import com.valsesia.forum.models.Topico;
import java.util.List;

/**
 *
 * @author jvalsesia
 */
public interface TopicoDAO {

    //insere um novo topico no banco de dados
    public void inserir(Topico t) throws Exception;

    // lista topicos
    public List<Topico> listaTopicos() throws Exception;

    // recupera Topico pelo id
    public Topico recuperar(String id_topico) throws Exception;
}
