package com.mycompany.salaodebeleza.model.dao;
/**
 *
 * @author Pedro Henrique Arruda
 */
import com.mycompany.salaodebeleza.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    public static List<String> selectProdutos(Connection conn) throws SQLException {
        List<String> linhas = new ArrayList<String>();

        String sql = "select * from produtos;";
        Statement stmt = conn.createStatement();
        ResultSet dados = stmt.executeQuery(sql);

        while(dados.next()){
            linhas.add(" ");
            linhas.add("ID: " + dados.getInt(1));
            linhas.add("Nome: " + dados.getString(2));
            linhas.add("Valor: " + dados.getDouble(3));
            linhas.add("Descrição: " + dados.getString(4));
            linhas.add("Estoque: " + dados.getInt(5));
            linhas.add("Fornecedor: " + dados.getString(6));
            linhas.add("Marca: " + dados.getString(7));
            linhas.add("Data de validade: " + dados.getDate(8));
            linhas.add("-----------------------------------------------");

        }

        return linhas;
    }

    public static boolean cadastrarProdutos(Connection conn, String nome, double valor, String descricao, int estoque, String fornecedor, String marca, String validade){
        try {
            String sql = "insert into Produtos(Nome, valor, descricao, Estoque, Fornecedor, Marca, Validade)" + "values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setDouble(2, valor);
            stmt.setString(3, descricao);
            stmt.setInt(4, estoque);
            stmt.setString(5, fornecedor);
            stmt.setString(6, marca);
            stmt.setDate(7, java.sql.Date.valueOf(validade));
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        }catch(SQLException e){
            System.err.println("Erro ao executar a query: " + e.getMessage());
            return false;
        }
    }

    public static boolean alterarProduto(Connection conn, String nomeColuna, String novoValor, int idProduto){
        try{
            String sql = "update Produtos set " +  nomeColuna + " = ? where ID_Produto = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, novoValor);
            stmt.setInt(2, idProduto);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        }catch(SQLException e){
            System.err.println("Erro ao executar a query: " + e.getMessage());
            return false;
        }
    }


    public static boolean alterarProduto(Connection conn, Double valor, int idProduto){
        try{
            String sql = "update Produtos set valor = ? where ID_Produto = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, valor);
            stmt.setInt(2, idProduto);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        }catch(SQLException e){
            System.err.println("Erro ao executar a query: " + e.getMessage());
            return false;
        }
    }

    public static boolean alterarProduto(Connection conn, int novoEstoque, int idProduto){
        try{
            String sql = "update Produtos set Estoque = ? where ID_Produto = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, novoEstoque);
            stmt.setInt(2, idProduto);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        }catch(SQLException e){
            System.err.println("Erro ao executar a query: " + e.getMessage());
            return false;
        }
    }

    public static boolean alterarProduto(Connection conn, String novaValidade, int idProduto){
        try{
            String sql = "update Produtos set Validade = ? where ID_Produto = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDate(1, java.sql.Date.valueOf(novaValidade));
            stmt.setInt(2, idProduto);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        }catch(SQLException e){
            System.err.println("Erro ao executar a query: " + e.getMessage());
            return false;
        }
    }

    public static boolean deletarProduto(Connection conn, int idProduto){
        try{
            String sql = "delete from Produtos where ID_Produto = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProduto);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e){
            System.err.println("Erro ao executar a query: " + e.getMessage());
            return false;
        }
    }

    public static boolean checarIdProduto(Connection conn, int idProduto){

        try{
            String sql = "select count(*) as total from Produtos where ID_Produto = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProduto);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                int total = rs.getInt("total");

                return total > 0;
            }
            else{
                return false;
            }


        }catch (SQLException e){
            throw new RuntimeException("Erro ao verificar a existência do ID: " + e.getMessage());

        }
    }


    public static Produto buscarProduto(Connection conn, int idProduto) {
        String sql = "SELECT * FROM Produtos WHERE ID_Produto = ?;";
        try  {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProduto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Produto(
                        rs.getString("Nome"),
                        rs.getDouble("Valor"),
                        rs.getString("Descricao"),
                        rs.getInt("Estoque"),
                        rs.getString("Fornecedor"),
                        rs.getString("Marca"),
                        rs.getDate("Validade").toString()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
