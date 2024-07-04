<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<jsp:useBean id="daofilmes" class="br.csi.dao.FilmeDAO"/>
<jsp:useBean id="daousuario" class="br.csi.dao.UsuarioDAO"/>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Filmes</title>
    <link rel="stylesheet" href="./style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="./style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-custom">
    <div class="container-fluid">
        <img src="imgs/tlogo.png" href="filmes?page=dash" alt="Logo" width="80" height="80" class="d-inline-block align-text-top">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link nav-texto-branco" style="color: white;" aria-current="page" href="filmes?page=dash">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white;" href="filmes?page=cadastrar">Cadastrar Filmes</a>
                </li>
            </ul>
            <ul class="navbar-nav mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color: white;">
                        Olá, ${sessionScope.get('sessaousuario').nome}
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="filmes?page=sair">Sair</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<h1 class="text-center mt-4">Cadastrar Filmes</h1>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <form action="filmes" method="POST">
                        <div class="form-group">
                            <label for="nomefilme">Nome do Filme</label>
                            <input type="text" class="form-control" name="nomefilme" id="nomefilme" placeholder="Nome do Filme">
                        </div>
                        <div class="form-group">
                            <label for="ano">Ano do Filme</label>
                            <input type="text" class="form-control" name="ano" id="ano" placeholder="Ano do Filme">
                        </div>
                        <div class="form-group">
                            <label for="categoria">Categoria do Filme</label>
                            <input type="text" class="form-control" name="categoria" id="categoria" placeholder="Categoria do Filme">
                        </div>
                        <div class="form-group">
                            <label for="descricao">Descricao do Filme</label>
                            <input type="text" class="form-control" name="descricao" id="descricao" placeholder="Descricao do Filme">
                        </div>
                        <div class="form-group">
                            <label for="imagem">Url do Filme</label>
                            <input type="text" class="form-control" name="imagem" id="imagem" placeholder="Url">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Cadastrar</button>
                        </div>
                        <c:if test="${not empty retornofilme}">
                            <div class="alert alert-dark text-center mt-4" role="alert">
                                <h3>${retornofilme}</h3>
                            </div>
                        </c:if>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

</body>
</html>
