package br.csi.dao;

import br.csi.model.Usuario;
import br.csi.util.ConectDBPostgres;

import java.sql.*;
import java.util.ArrayList;


public class UsuarioDAO {
    public ArrayList<Usuario> getUsuarios() {
        ConectDBPostgres cdb = new ConectDBPostgres();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            Statement stmt = cdb.getConecao().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
                usuarios.add(u);
            }
        } catch (SQLException e) {

        }
        return usuarios;
    }


    public Usuario autenticar(String email, String senha){
        try{
            Connection con = new ConectDBPostgres().getConecao();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario " +
                    "where email = '"+email+"' and senha = '"+senha+"'" );

            while (rs.next()){

                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("permissao"
                        ));
            }
            return null;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    public boolean inserir(Usuario usuario) {
        try {
            Connection cdb = new ConectDBPostgres().getConecao();
            Statement stmt = cdb.createStatement();
            String sql = "INSERT INTO usuario (nome, email, senha) " +
                    "VALUES ('" + usuario.getNome() + "', '" + usuario.getEmail() + "', '" + usuario.getSenha() + "')";
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean excluir(Integer id) {
        ConectDBPostgres cdb = new ConectDBPostgres();
        try {
            Connection conn = cdb.getConecao();
            String sql = "DELETE FROM usuario WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


