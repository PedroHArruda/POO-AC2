package com.mycompany.salaodebeleza.model.dao;
/**
 *
 * @author Pedro Henrique Arruda
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfissionalDAO {


    public static boolean realizarLogin(Connection conn, String email, String senha){
        String sql = "SELECT COUNT(*) AS total FROM Profissionais WHERE email =? and senha = ?;";
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

    public static List<String> selectProfissionais(Connection conn) throws SQLException {
        List<String> linhas = new ArrayList<String>();

        String sql = "select * from profissionais;";
        Statement stmt = conn.createStatement();
        ResultSet dados = stmt.executeQuery(sql);

        while(dados.next()){
            linhas.add(" ");
            linhas.add("ID: " + dados.getInt(1));
            linhas.add("Nome: " + dados.getString(2));
            linhas.add("E-mail: " + dados.getString(3));
            linhas.add("Função: " + dados.getString(4));
            linhas.add("Telefone: " + dados.getString(5));
            linhas.add("-----------------------------------------------");

        }

        return linhas;
    }

    public static boolean realizarCadastro(Connection conn, String nome, String email, String funcao, String senha, String telefone){
        try {
            String sql = "insert into Profissionais(Nome, email, funcao, senha, telefone)" + "values (?, ?, ?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, funcao);
            stmt.setString(4, senha);
            stmt.setString(5, telefone);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        }catch(SQLException e){
            System.err.println("Erro ao executar a query: " + e.getMessage());
            return false;
        }
    }

}
