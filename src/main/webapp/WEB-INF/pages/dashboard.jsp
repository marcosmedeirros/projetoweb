<%@ page import="br.csi.model.Filme" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<jsp:useBean id="daofilme" class="br.csi.dao.FilmeDAO"/>
<jsp:useBean id="daousuario" class="br.csi.dao.UsuarioDAO"/>
<jsp:useBean id="daoavaliacao" class="br.csi.dao.AvaliacaoDAO"/>

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


<div class="container">
    <h1 class="text-center mt-4">Lista de Filmes</h1>
    <div class="row mt-4">
        <c:forEach var="filme" items="${filmes}">
            <div class="col-md-4 mb-4">
                <div class="card h-100">
                    <img src="${filme.imagem}" class="card-img-top" alt="${filme.nomefilme}" style="height: 300px; object-fit: cover;">
                    <div class="card-body">
                        <h5 class="card-title">${filme.nomefilme}</h5>
                        <p class="card-text"><strong>Ano:</strong> ${filme.ano}</p>
                        <p class="card-text"><strong>Categoria:</strong> ${filme.categoria}</p>
                        <p class="card-text"><strong>Descrição:</strong> ${filme.descricao}</p>
                        <p class="card-text"><strong>Nota Média:</strong> ${filme.notamedia}</p>
                        <jsp:useBean id="daoAvaliacao" class="br.csi.dao.AvaliacaoDAO"/>
                        <c:set var="notaUsuario" value="${daoAvaliacao.obterAvaliacao(sessionScope.get('sessaousuario').id, filme.idfilme).nota}"/>
                        <c:if test="${notaUsuario != null}">
                            <p class="card-text"><strong>Sua Nota:</strong> ${notaUsuario}</p>
                        </c:if>
                    </div>
                    <div class="card-footer"> <%-- Movido o fechamento da div para cá --%>
                        <div class="d-flex justify-content-between align-items-center">
                            <c:if test="${(sessionScope.get('sessaousuario').permissao) == 'admin'}">
                                <a href="filmes?opcao=excluir&idfilme=${filme.idfilme}" class="btn btn-danger btn-sm">Excluir</a>
                            </c:if>
                            <form action="avaliacao" method="post">
                                <input type="hidden" name="idfilme" value="${filme.idfilme}">
                                <input type="hidden" name="idusuario" value="${sessionScope.get('sessaousuario').id}">
                                <div class="input-group m-4 justify-content-center">
                                    <div class="input-group m-4 justify-content-center">
                                        <div class="rating">
                                            <input type="radio" name="nota" id="star1" value="1" required>
                                            <label for="star1" title="1 stars">1</label>
                                            <input type="radio" name="nota" id="star2" value="2">
                                            <label for="star2" title="2 stars">2</label>
                                            <input type="radio" name="nota" id="star3" value="3">
                                            <label for="star3" title="3 stars">3</label>
                                            <input type="radio" name="nota" id="star4" value="4">
                                            <label for="star4" title="4 stars">4</label>
                                            <input type="radio" name="nota" id="star5" value="5">
                                            <label for="star5" title="5 star">5</label>
                                        </div>
                                        <button type="submit" class="btn btn-primary rounded-pill ms-2">
                                            <i class="fas fa-star"></i> Avaliar
                                        </button>
                                    </div>
                                </div>

                            </form>
                        </div>
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
