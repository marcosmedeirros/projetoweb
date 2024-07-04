package br.csi.service;

import br.csi.dao.AvaliacaoDAO;
import br.csi.model.Avaliacao;

import java.sql.SQLException;
import java.util.ArrayList;

public class AvaliacaoService {

    private final AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacaoDAO.getAvaliacoes();
    }

    public boolean registrarAvaliacao(Integer usuarioId, Integer filmeId, Float nota) {
        System.out.println("TA NO AVALIACAOSERVICE");
        System.out.println("idfilme: NO SERVICE " + filmeId);
        System.out.println("idusuario:NO SERVICE " + usuarioId);
        avaliacaoDAO.salvarAvaliacao(usuarioId, filmeId, nota);
        return true;
    }

    public Avaliacao obterAvaliacao(int usuarioId, int filmeId) {
        return avaliacaoDAO.obterAvaliacao(usuarioId, filmeId);
    }

}
