<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="../../style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<h1 class="text-center mt-4">Login</h1>


<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <form action="login" method="POST">
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="text" class="form-control" name="email" id="email" placeholder="Usuario">
                        </div>
                        <div class="form-group">
                            <label for="senha">Senha</label>
                            <input type="password" class="form-control" name="senha" id="senha" placeholder="Senha">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Entrar</button>
                        </div>
                        <c:if test="${not empty erro}">
                            <div class="alert alert-dark text-center mt-4" role="alert">
                                <h3>${erro}</h3>
                            </div>
                        </c:if>
                    </form>
                    <div class="text-center mt-3">
                        <a href="./cadastrarusuario.jsp" class="textcadastrar">Cadastrar Usuário</a>
                    </div>

                </div>
            </div>
            <div class="text-center mt-3">
                <a href="./index.jsp" class="textcadastrar">Voltar</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
