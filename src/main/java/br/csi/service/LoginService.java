package br.csi.service;

import br.csi.dao.UsuarioDAO;
import br.csi.model.Usuario;

public class LoginService {
        public Usuario logar(String email, String senha) {
            return new UsuarioDAO().autenticar(email, senha);
        }


}