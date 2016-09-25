<%-- 
    Document   : inseretopicos
    Created on : Sep 24, 2016, 3:24:15 PM
    Author     : jvalsesia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.3.7-1/css/bootstrap.min.css'>
        <title>Forum - Insere Topico</title>
    </head>
    <body style="background-color: #4f4f4f;">
        <div class="container" style="background-color: #e8e8ed;margin-top: 150px">
            <div class="row">
                <div class="col-md-1">
                </div>
                <div class="col-md-7" >
                        <h2>Insere Topicos</h2>
                        <form method="POST" action="inserirtopico">
                            <div class="form-group">
                                <label> Titulo:</label>
                                <div>
                                    <input type="text" name="titulo" size="88px">
                                </div>
                            </div>
                            <div class="form-group">
                                <div>
                                    <label>Conteudo:</label>
                                </div>
                                <div>
                                    <textarea class="form-control" rows="10" name="conteudo"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="submit" id="btNewTopico" class="btn btn-primary" value="New Topico" />
                            </div>

                        </form>
                        <div class="alert alert-danger" role="alert">
                            ${erro}
                        </div>
                        <div class="row">
                            <div class="col-md-12">

                            </div>
                        </div>
                </div>
                <div class="col-md-4">
                    <div class="jumbotron" style="border-color: #000000 ">                     
                        <h4>Usuario</h4>
                        <h6>${sessionScope.usuarioAutenticado.nome}</h6>
                    </div>
                </div>

            </div>
        </div>


        <script type="text/javascript" src="webjars/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    </body>
</html>
