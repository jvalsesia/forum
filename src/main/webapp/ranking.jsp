<%-- 
    Document   : ranking
    Created on : Sep 24, 2016, 5:11:28 PM
    Author     : jvalsesia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.3.7-1/css/bootstrap.min.css'>
        <title>Forum - Ranking</title>
    </head>


    <body style="background-color: #4f4f4f;">
        <div class="container" style="background-color: #e8e8ed;margin-top: 150px">
            <div class="row">
                <div class="col-md-1">
                </div>
                <div class="col-md-7">
                    <h2>Ranking</h2>
                    <table class="table table-striped">
                        <tr>                
                            <th>Nome</th>
                            <th>Login</th>
                            <th>Pontos</th>
                        </tr>
                        <c:forEach  var="r" items="${ranking}">
                            <tr>
                                <td>${r.nome}</td>
                                <td>${r.login}</td>       
                                <td>${r.pontos}</td>       
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
