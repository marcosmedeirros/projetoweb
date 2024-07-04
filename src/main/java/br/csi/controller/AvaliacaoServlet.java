package br.csi.controller;

import br.csi.model.Avaliacao;

import br.csi.service.AvaliacaoService;
import br.csi.service.FilmeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("avaliacao")
public class AvaliacaoServlet extends HttpServlet {

    private final AvaliacaoService avaliacaoService = new AvaliacaoService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamou o POST da Avaliacao");
        System.out.println("idfilme: " + req.getParameter("idfilme"));
        System.out.println("idusuario: " + req.getParameter("idusuario"));

        int usuarioId = Integer.parseInt(req.getParameter("idusuario"));
        int filmeId = Integer.parseInt(req.getParameter("idfilme"));
        float nota = Float.parseFloat(req.getParameter("nota"));

        Avaliacao avaliacao = new Avaliacao(usuarioId, filmeId, nota);
        boolean novaavaliacao = new AvaliacaoService().registrarAvaliacao(usuarioId, filmeId, nota);
        boolean filme = new FilmeService().atualizandonotaFilmes(filmeId, nota);
        if (novaavaliacao) {
            req.setAttribute("retornoavaliacao", "Filme inserido com sucesso!");
        } else {
            req.setAttribute("retornoavaliacao", "Erro ao inserir filme!");
        }
        resp.sendRedirect("filmes?page=dash");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamou o GET da Avaliacao");
        //aqui eu estava usando antes, nao é mais necessário
        int usuarioId = Integer.parseInt(req.getParameter("usuarioId"));
        int filmeId = Integer.parseInt(req.getParameter("filmeId"));
        Avaliacao avaliacao = null;
        avaliacao = avaliacaoService.obterAvaliacao(usuarioId, filmeId);
        req.setAttribute("avaliacao", avaliacao);
        resp.sendRedirect("filmes?page=dash");

    }
}


