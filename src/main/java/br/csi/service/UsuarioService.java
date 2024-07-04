package br.csi.service;

import br.csi.dao.UsuarioDAO;
import br.csi.model.Usuario;

public class UsuarioService {

    public boolean inserir(Usuario usuario) {

        return new UsuarioDAO().inserir(usuario);
    }


    public boolean excluir(Usuario usuario) {
        return new UsuarioDAO().excluir(usuario.getId());

    }


}
