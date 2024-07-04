<%@ page import="br.csi.model.Filme" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<jsp:useBean id="daofilme" class="br.csi.dao.FilmeDAO"/>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="./style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-custom">
    <div class="container-fluid">
        <img src="imgs/tlogo.png" href="index.jsp" alt="Logo" width="80" height="80" class="d-inline-block align-text-top">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            </ul>
            <ul class="navbar-nav mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="btn btn-outline-light" href="login.jsp">Login</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<div class="container">
    <h1 class="text-center mt-4">Lista de Filmes</h1>
    <div class="row">
        <c:forEach var="filme" items="${daofilme.getFilmes()}">
            <div class="col-md-4 mb-4">
                <div class="card">
                    <img src="${filme.imagem}" class="card-img-top" alt="${filme.nomefilme}" style="height: 300px; object-fit: cover;">
                    <div class="card-body">
                        <h5 class="card-title">${filme.nomefilme}</h5>
                        <p class="card-text"><strong>Ano:</strong> ${filme.ano}</p>
                        <p class="card-text"><strong>Categoria:</strong> ${filme.genero}</p>
                        <p class="card-text"><strong>Descrição:</strong> ${filme.descricao}</p>
                        <p class="card-text"><strong>Nota:</strong> ${filme.notamedia}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

</body>
</html>
