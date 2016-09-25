<%-- 
    Document   : cadastro
    Created on : Sep 24, 2016, 12:09:08 PM
    Author     : jvalsesia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.3.7-1/css/bootstrap.min.css'>
        <title>Forum - Cadastro</title>
    </head>
    <body style="background-color: #4f4f4f;">
        <div class="container block-center" style="background-color: #e8e8ed;margin-top: 150px">
            <div class="row">
                <div class="col-md-3">

                </div>
                <div class="col-md-6">
                    <h2>Cadastro</h2>
                    <form method="POST" action="cadastrar">
                        <div>
                            <label>Nome:</label>
                            <input type="text" name="nome" style="margin: 10px">
                        </div>
                        <div>
                            <label>Login:</label>
                            <input type="text" name="login" style="margin: 10px">
                        </div>
                        <div>
                            <label>Email:</label>
                            <input type="email" name="email" style="margin: 10px">
                        </div>
                        <div>
                            <label>Senha:</label>
                            <input type="password" name="senha" style="margin: 10px">
                        </div>
                        <input type="submit" id="btCadastrar" value="Cadastrar" class="btn btn-primary"  style="margin: 10px"/>
                    </form>
                    <div class="alert alert-danger" role="alert">
                        ${erro}
                    </div>

                </div>
                <div class="col-md-3">

                </div>
            </div>
        </div>



        <script type="text/javascript" src="webjars/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    </body>
</html>
