<%-- 
    Document   : exibetopico
    Created on : Sep 24, 2016, 4:23:03 PM
    Author     : jvalsesia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.3.7-1/css/bootstrap.min.css'>
        <title>JSP - Topico</title>
    </head>
    <body style="background-color: #4f4f4f;">
        <div class="container block-center" style="background-color: #e8e8ed;margin-top: 150px">
            <div class="row">
                <div class="col-md-1">


                </div>
                <div class="col-md-7">
                    <h2>Topico</h2>

                    <div class="row">
                        <div class="col-md-6"> 
                            <h3>${sessionScope.topicoSelecionado.titulo}</h3>                          
                        </div>
                       
                        <div class="col-md-6">
                            <h4> ${sessionScope.topicoSelecionado.login}</h4>                          
                        </div>
                                             
                    </div>
                    <table class="table table-striped">
                        <tr>                
                            <th>Comentario</th>
                            <th>Autor</th>
                        </tr>
                        <c:forEach  var="c" items="${comentarios}">
                            <tr>
                                <td>${c.comentario}</td>
                                <td>${c.login}</td>                 
                            </tr>
                        </c:forEach>
                    </table>

                    <div >

                    <form method="POST" action="inserircomentario">
                        <div>
                            <label>Comentario:</label>
                        </div>
                        <textarea class="form-control" rows="10"  name="comentario"> </textarea>
                        <input type="submit" class="btn btn-primary" id="btNovoComentario" style="margin: 10px" value="Novo Comentario" />
                    </form>                        
                    </div>

                    <div class="alert alert-danger" role="alert">
                        ${erro}
                    </div>



                </div>
                <div class="col-md-4">
                    <div class="jumbotron">
                        <h4>Usuario</h4>
                        <h6>${sessionScope.usuarioAutenticado.nome}</h6>
                        <form method="POST" action="topage">
                            <input type="hidden" name="topage" value="topicos">
                            <input type="submit" id="btVoltaTopicos" class="btn btn-success" value="Topicos" />
                        </form>
                    </div>
                </div>
            </div>

        </div>


        <script type="text/javascript" src="webjars/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    </body>
</html>
