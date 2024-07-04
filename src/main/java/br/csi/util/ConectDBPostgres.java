package br.csi.util;


import java.sql.*;

public class ConectDBPostgres {
    public Connection getConecao() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetoweb", "postgres", "1234");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("Problemas no " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
