<%-- 
    Document   : index
    Created on : Sep 24, 2016, 2:50:30 PM
    Author     : jvalsesia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Forum - Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.3.7-1/css/bootstrap.min.css'>
    </head>
    <body style="background-color: #4f4f4f;">

        <div class="container block-center" style="background-color: #e8e8ed;margin-top: 150px">
            <div class="row">
                <div class="col-md-4">

                </div>
                <div class="col-md-4">
                    <h2>Login</h2>
                    <form method="POST" action="logar">
                        <div class="form-group">
                            <label >Login:</label>
                            <input type="text" name="login">
                        </div>
                        <div class="form-group">
                            <label>Senha:</label>
                            <input type="password" name="senha">
                        </div>
                        <div class="form-group">
                            <input type="submit" id="btLogin"  class="btn btn-primary" value="Login" />
                        </div>
                        <div class="alert alert-danger" role="alert">
                            ${erro}
                        </div>

                    </form>



                </div>
                <div class="col-md-4" style="margin-top: 20px">
                    <form method="POST" action="topage">
                        <input type="hidden" name="topage" value="cadastro">
                        <input type="submit" id="btToCadastro" class="btn btn-success" value="Cadastro" />
                    </form>
                </div>

            </div>


            <script type="text/javascript" src="webjars/jquery/3.1.0/jquery.min.js"></script>
            <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
        </div>
    </body>
</html>
