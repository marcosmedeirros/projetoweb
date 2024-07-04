package br.csi.controller;

import br.csi.dao.UsuarioDAO;
import br.csi.model.Usuario;
import br.csi.service.UsuarioService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("usuario")
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        System.out.println("Nome: "  + nome + " Email: " + email + " Senha: " + senha);
        Usuario usuario = new Usuario(nome, email, senha);
        RequestDispatcher rd = req.getRequestDispatcher("./cadastrarusuario.jsp");

        if(new UsuarioService().inserir(usuario)){
            req.setAttribute("retorno", "Usuário inserido com sucesso!");
        } else {
            req.setAttribute("retorno", "Erro ao inserir usuário!");
        }
        rd.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamou o GET");
        System.out.println("Opcao: " + req.getParameter("opcao"));
        System.out.println("ID: " + req.getParameter("id"));

        String opcao = req.getParameter("opcao");

        if (opcao != null) {
            if (opcao.equals("excluir")) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                new UsuarioService().excluir(new Usuario(id, null, null, null));

            }
        }

        UsuarioDAO userdao = new UsuarioDAO();
        RequestDispatcher rd = req.getRequestDispatcher("./cadastrarusuario.jsp");
        rd.forward(req, resp);
    }


}
