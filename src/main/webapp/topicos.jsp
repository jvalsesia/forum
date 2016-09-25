<%-- 
    Document   : topicos
    Created on : Sep 24, 2016, 2:43:25 PM
    Author     : jvalsesia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.3.7-1/css/bootstrap.min.css'>
        <title>Forum - Topicos</title>
    </head>
    <body style="background-color: #4f4f4f;">
        <div class="container" style="background-color: #e8e8ed;margin-top: 150px">
            <div class="row">
                <div class="col-md-1">


                </div>
                <div class="col-md-7">
                        <h2>Topicos</h2>
                        <table class="table table-striped">
                            <tr>                
                                <th>Titulo</th>
                                <th>Autor</th>
                                <th>Conteudo</th>
                            </tr>
                            <c:forEach  var="topico" items="${topicos}">
                                <tr>
                                    <td>${topico.titulo}</td>
                                    <td>${topico.login}</td>                 
                                    <td> 
                                        <form method="POST" action="exibetopico">
                                            <input type="hidden" name="id_topico" id="btLogin${topico.id_topico}"  value="${topico.id_topico}">
                                            <input type="submit"  id="btExibir" class="btn btn-warning" value="Exibir"/>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>

                        <div class="alert alert-danger" role="alert">
                            ${erro}
                        </div>                        
                    

                </div>
                <div class="col-md-4">
                    <div class="jumbotron">
                        <h4>Usuario</h4>
                        <h6>${sessionScope.usuarioAutenticado.nome}</h6>
                        <div class="row">
                            <div class="btn-group-vertical" role="group" aria-label="...">
                                <div style="margin: 10px">
                                    <form method="POST" action="topage">
                                        <input type="hidden" name="topage" value="inseretopico">
                                        <input type="submit"  id="btInserirTopico" class="btn btn-success" value="Inserir Topico" />
                                    </form>          
                                </div>
                                <div style="margin: 10px">
                                    <form method="POST" action="mostraranking">
                                        <input type="submit" id="btExibirRanking" class="btn btn-success" value="Exibir Ranking" />
                                    </form>          
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>


        </div>

        <script type="text/javascript" src="webjars/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    </body>
</html>
