package br.csi.dao;

import br.csi.model.Filme;
import br.csi.util.ConectDBPostgres;

import java.sql.*;
import java.util.ArrayList;

public class FilmeDAO {
    public ArrayList<Filme> getFilmes() {
        ConectDBPostgres cdb = new ConectDBPostgres();
        ArrayList<Filme> filmes = new ArrayList<>();
        try {
            Statement stmt = cdb.getConecao().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM filme");
            while (rs.next()) {
                Filme f = new Filme(
                        rs.getInt("idfilme"),
                        rs.getString("nomefilme"),
                        rs.getString("ano"),
                        rs.getString("categoria"),
                        rs.getString("descricao"),
                        rs.getString("imagem"),
                        rs.getFloat("notamedia")
                        );
                filmes.add(f);
            }
        } catch (SQLException e) {

        }
        return filmes;
    }

    public boolean inserirFilmes(Filme filme) {
        try {
            System.out.println("TA NO DAO");
            Connection cdb = new ConectDBPostgres().getConecao();
            Statement stmt = cdb.createStatement();
            String sql = "INSERT INTO filme (nomefilme, ano, categoria, descricao, imagem) " +
                    "VALUES ('" + filme.nomefilme + "', '" + filme.ano + "', '" + filme.categoria + "', '" +
                    filme.descricao + "', '" + filme.imagem + "')";
            stmt.execute(sql);
            System.out.println("SQL: " + sql);
            System.out.println("Filme inserido com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean excluirFilmes(int idfilme) {
        Connection cdb;
        try{

            cdb = new ConectDBPostgres().getConecao();
            String sqlDeleteAvaliacoes = "DELETE FROM avaliacao WHERE idfilme = ?";
            PreparedStatement stmtDeleteAvaliacoes = cdb.prepareStatement(sqlDeleteAvaliacoes);
            stmtDeleteAvaliacoes.setInt(1, idfilme);
            int rowsAffected = stmtDeleteAvaliacoes.executeUpdate();
            System.out.println(rowsAffected + " avaliações excluídas para o filme com id " + idfilme);

            String sqlDeleteFilme = "DELETE FROM filme WHERE idfilme = ?";
            PreparedStatement stmtDeleteFilme = cdb.prepareStatement(sqlDeleteFilme);
            stmtDeleteFilme.setInt(1, idfilme);
            rowsAffected = stmtDeleteFilme.executeUpdate();
            System.out.println("Filme excluído com sucesso!");
            return true;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean atualizandonotaFilmes(Integer idfilme, Float notamedia) {
        try {
            Connection cdb = new ConectDBPostgres().getConecao();
            Statement stmt = cdb.createStatement();
            String sql = "UPDATE filme f SET notamedia = (" +
                    "  SELECT AVG(a.nota) FROM avaliacao a WHERE a.idfilme = f.idfilme" +
                    ")";
            stmt.execute(sql);
            System.out.println("SQL: " + sql);
            System.out.println("Nota média atualizada com sucesso!");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
