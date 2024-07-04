package br.csi.controller;

import br.csi.model.Usuario;
import br.csi.service.LoginService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("login")
public class LoginServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        System.out.println("Chamou O LOGIN");

        System.out.println(email + " " + senha);

        Usuario usuario = new LoginService().logar(email, senha);

        HttpSession sessao = req.getSession(true);
        sessao.setAttribute("sessaousuario", usuario);
        System.out.printf("ID DA SESSAO: %s%n", sessao.getId());
        sessao.setAttribute("id", sessao.getId());
        System.out.printf("ID DA SESSAO: %s%n", sessao.getId());


        if(usuario != null){
            req.setAttribute("usuario", usuario);
            System.out.println("foi");
            resp.sendRedirect("filmes?page=dash");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            req.setAttribute("erro", "Email ou senha inválidos");
            rd.forward(req, resp);
        }


    }

}
