package com.mycompany.salaodebeleza.model.dao;
/**
 *
 * @author Pedro Henrique Arruda
 */
import com.mycompany.salaodebeleza.model.Servico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicosDAO {


    public static List<String> selectServicos(Connection conn) throws SQLException {
        List<String> linhas = new ArrayList<String>();

        String sql = "select servicos.ID_servico, servicos.nome, servicos.valor, " +
                "servicos.descricao, servicos.categoria, servicos.TempoDeExecucao, servicos.disponibilidade, " +
                "profissionais.nome from servicos join profissionais on servicos.ProfissionalResponsavel = profissionais.ID_Profissional;";
        Statement stmt = conn.createStatement();
        ResultSet dados = stmt.executeQuery(sql);

        while (dados.next()) {
            linhas.add(" ");
            linhas.add("ID: " + dados.getInt(1));
            linhas.add("Nome: " + dados.getString(2));
            linhas.add("Valor: R$" + dados.getDouble(3));
            linhas.add("Descrição: " + dados.getString(4));
            linhas.add("Categoria: " + dados.getString(5));
            linhas.add("Tempo de execução (em minutos): " + dados.getInt(6));
            linhas.add("Disponibilidade: " + dados.getString(7));
            linhas.add("Profissional Responsável: " + dados.getString(8));
            linhas.add("-----------------------------------------------");

        }

        return linhas;
    }

    public static boolean cadastrarServicos(Connection conn, String nome, double valor, String descricao, int profissionalResponsavel, String categoria, double gasto, int tempoDeExecucao, String disponibilidade) {
        try {
            String sql = "insert into Servicos(Nome, valor, descricao, ProfissionalResponsavel, categoria, gasto, TempoDeExecucao, Disponibilidade)" + "values (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setDouble(2, valor);
            stmt.setString(3, descricao);
            stmt.setInt(4, profissionalResponsavel);
            stmt.setString(5, categoria);
            stmt.setDouble(7, gasto);
            stmt.setInt(6, tempoDeExecucao);
            stmt.setString(8, disponibilidade);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao executar a query: " + e.getMessage());
            return false;
        }
    }

    public static boolean alterarServico(Connection conn, String nomeColuna, String novoValor, int idServico){
        try{
            String sql = "update Servicos set " +  nomeColuna + " = ? where ID_Servico = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, novoValor);
            stmt.setInt(2, idServico);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        }catch(SQLException e){
            System.err.println("Erro ao executar a query: " + e.getMessage());
            return false;
        }
    }


    public static boolean alterarServico(Connection conn, String nomeColuna, double novoValor, int idServico){
        try{
            String sql = "update Servicos set " +  nomeColuna + " = ? where ID_Servico = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, novoValor);
            stmt.setInt(2, idServico);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        }catch(SQLException e){
            System.err.println("Erro ao executar a query: " + e.getMessage());
            return false;
        }
    }

    public static boolean alterarServico(Connection conn, String nomeColuna, int novoValor, int idServico){
        try{
            String sql = "update Servicos set " +  nomeColuna + " = ? where ID_Servico = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, novoValor);
            stmt.setInt(2, idServico);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        }catch(SQLException e){
            System.err.println("Erro ao executar a query: " + e.getMessage());
            return false;
        }
    }

    public static boolean deletarServico(Connection conn, int idServico){
        try{
            String sql = "delete from Servicos where ID_Servico = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idServico);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e){
            System.err.println("Erro ao executar a query: " + e.getMessage());
            return false;
        }
    }

    public static boolean checarIdServico(Connection conn, int idServico){

        try{
            String sql = "select count(*) as total from Servicos where ID_Servico = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idServico);
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

    public static Servico buscarServico(Connection conn, int idServico) {
        String sql = "select * from Servicos where ID_Servico = ?;";
        try  {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idServico);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Servico(
                        rs.getString("Nome"),
                        rs.getDouble("Valor"),
                        rs.getString("Descricao"),
                        rs.getInt("ProfissionalResponsavel"),
                        rs.getString("Categoria"),
                        rs.getDouble("Gasto"),
                        rs.getInt("TempoDeExecucao"),
                        rs.getString("Disponibilidade")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




}

