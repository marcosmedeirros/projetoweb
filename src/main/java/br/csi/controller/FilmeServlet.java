package br.csi.controller;

import br.csi.model.Avaliacao;
import br.csi.model.Filme;
import br.csi.service.AvaliacaoService;
import br.csi.service.FilmeService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("filmes")
public class FilmeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomefilme = req.getParameter("nomefilme");
        String ano = req.getParameter("ano");
        String categoria = req.getParameter("categoria");
        String descricao = req.getParameter("descricao");
        String imagem = req.getParameter("imagem");

        if (nomefilme != null) {//aqui foi uma maneira de quando eu precisava carregar dnv a pagina ele nao criar um novo filme
            Filme filme = new Filme(nomefilme, ano, categoria, descricao, imagem);
            boolean inseridoComSucesso = new FilmeService().inserirFilmes(nomefilme,ano,categoria,descricao,imagem);
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/cadastrarfilmes.jsp");


            if (inseridoComSucesso) {
                req.setAttribute("retornofilme", "Filme inserido com sucesso!");
            } else {
                req.setAttribute("retornofilme", "Erro ao inserir filme!");
            }
            rd.forward(req, resp);
        } else {
            req.setAttribute("retornofilme", "Preencha todos os campos obrigatórios!");
            req.getRequestDispatcher("WEB-INF/pages/cadastrarfilmes.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamou o GET");
        System.out.println("Opcao: " + req.getParameter("opcao"));
        System.out.println("IDfilme: " + req.getParameter("idfilme"));
        String opcao = req.getParameter("opcao");

        if(opcao !=null){
            if(opcao.equals("excluir")){
                int idfilme = Integer.parseInt(req.getParameter("idfilme"));
                new FilmeService().excluirFilmes(idfilme);
                req.setAttribute("retorno","Filme EXCLUÍDO com SUCESSO");
            }
            resp.sendRedirect("filmes?page=dash");
        }

        List<Filme> filmes = new FilmeService().listarFilmes();
        req.setAttribute("filmes", filmes);

        String page = req.getParameter("page");
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("sessaousuario") != null) {
            if ("cadastrar".equals(page)) {
                RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/cadastrarfilmes.jsp");
                rd.forward(req, resp);
            } else if("dash".equals(page)) {
                RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/dashboard.jsp");
                rd.forward(req, resp);
            } else if ("sair".equals(page)) {
                session.invalidate();
                resp.sendRedirect("index.jsp");
            }
        } else {
            resp.sendRedirect("login.jsp");
        }

    }


}
