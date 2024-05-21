package com.mycompany.salaodebeleza.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Pedro Henrique Arruda
 */
public class ClienteDAO {



    public static boolean realizarCadastro(Connection conn, String nome, String email, String senha, String telefone){
        try {
            String sql = "insert into Clientes(Nome, email, senha, telefone)" + "values (?, ?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);
            stmt.setString(4, telefone);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        }catch(SQLException e){
            System.err.println("Erro ao executar a query: " + e.getMessage());
            return false;
        }
    }

    public static boolean realizarLogin(Connection conn, String email, String senha){
        String sql = "SELECT COUNT(*) AS total FROM Clientes WHERE email =? and senha = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int total = rs.getInt("total");
                return total > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao realizar login: " + e.getMessage());
        }
        return false;
    }





}
