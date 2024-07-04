package br.csi.service;

import br.csi.dao.FilmeDAO;
import br.csi.model.Filme;

import java.util.List;

public class FilmeService {
    public boolean inserirFilmes(String nomefilme, String ano, String categoria, String descricao, String imagem) {
        System.out.println("TA NO SERVICE dos filmes");
        return new FilmeDAO().inserirFilmes(new Filme(nomefilme, ano, categoria, descricao, imagem));
    }

    public boolean excluirFilmes(int idfilme) {

        return new FilmeDAO().excluirFilmes(idfilme);
    }

    public List<Filme> listarFilmes() {
        return new FilmeDAO().getFilmes();
    }

    public boolean atualizandonotaFilmes(Integer idfilme, Float nota) {
        return new FilmeDAO().atualizandonotaFilmes(idfilme, nota);
    }

}
