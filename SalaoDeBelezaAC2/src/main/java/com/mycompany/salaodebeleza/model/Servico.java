package com.mycompany.salaodebeleza.model;
/**
 *
 * @author Pedro Henrique Arruda
 */
import com.mycompany.salaodebeleza.model.dao.ConnectionDAO;
import com.mycompany.salaodebeleza.model.dao.ServicosDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class Servico extends ItemPagavel {

    private int profissionalResponsavel;
    private String categoria;
    private double gasto;
    private int tempoDeExecucao;

    private String disponibilidade;

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getProfissionalResponsavel() {
        return profissionalResponsavel;
    }

    public void setProfissionalResponsavel(int profissionalResponsavel) {
        this.profissionalResponsavel = profissionalResponsavel;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getGasto() {
        return gasto;
    }

    public void setGasto(double gasto) {
        this.gasto = gasto;
    }

    public int getTempoDeExecucao() {
        return tempoDeExecucao;
    }

    public void setTempoDeExecucao(int tempoDeExecucao) {
        this.tempoDeExecucao = tempoDeExecucao;
    }

    public Servico(String nome, double valor, String descricao, int profissionalResponsavel, String categoria, double gasto, int tempoDeExecucao, String disponibilidade) {
        super(nome, valor, descricao);
        this.profissionalResponsavel = profissionalResponsavel;
        this.categoria = categoria;
        this.gasto = gasto;
        this.disponibilidade = disponibilidade;
        this.tempoDeExecucao = tempoDeExecucao;
    }
    public Servico(int idServico, String nome, double valor, String descricao, int profissionalResponsavel, String categoria, double gasto, int tempoDeExecucao, String disponibilidade) {
        super(idServico, nome, valor, descricao);
        this.profissionalResponsavel = profissionalResponsavel;
        this.categoria = categoria;
        this.gasto = gasto;
        this.disponibilidade = disponibilidade;
        this.tempoDeExecucao = tempoDeExecucao;
    }

    public Servico(){

    }

    public static void listarServicos() {
        try {
            Connection conn = ConnectionDAO.getConnection();
            for (String linha : ServicosDAO.selectServicos(conn)) {
                System.out.println(linha);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();

        }
    }

    public boolean cadastrarServicos() {

        try {
            Connection conn = ConnectionDAO.getConnection();
            return ServicosDAO.cadastrarServicos(conn, getNome(), getValor(), getDescricao(), getProfissionalResponsavel(), getCategoria(), getGasto(), getTempoDeExecucao(), getDisponibilidade());

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }


    }

    public static boolean alterarNome(String novoNome, int idServico) {
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ServicosDAO.alterarServico(conn, "Nome", novoNome, idServico);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }


    public static boolean alterarValor(double novoValor, int idServico) {
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ServicosDAO.alterarServico(conn, "Valor", novoValor, idServico);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean alterarDescricao(String novaDescricao, int idServico) {
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ServicosDAO.alterarServico(conn, "Descricao", novaDescricao, idServico);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean alterarProfissionalResponsavel(int novoProfissionalResponsavel, int idServico) {
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ServicosDAO.alterarServico(conn, "ProfissionalResponsavel", novoProfissionalResponsavel, idServico);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean alterarCategoria(String novaCategoria, int idServico) {
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ServicosDAO.alterarServico(conn, "Categoria", novaCategoria, idServico);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean alterarGasto(double novoGasto, int idServico) {
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ServicosDAO.alterarServico(conn, "Gasto", novoGasto, idServico);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean alterarTempoDeExecucao(int novoTempoDeExecucao, int idServico) {
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ServicosDAO.alterarServico(conn, "TempoDeExecucao", novoTempoDeExecucao, idServico);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean alterarDisponibilidade(String novaDisponibilidade, int idServico) {
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ServicosDAO.alterarServico(conn, "Disponibilidade", novaDisponibilidade, idServico);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }

    }

    public static boolean deletarServico(int idServico) {
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ServicosDAO.deletarServico(conn, idServico);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean verificarID(int idServico){
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ServicosDAO.checarIdServico(conn, idServico);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String toString() {
        return "Servico{" +
                "Profissional Responsavel: " + profissionalResponsavel +
                ", categoria='" + categoria + '\'' +
                ", gasto=" + gasto +
                ", tempoDeExecucao=" + tempoDeExecucao +
                ", disponibilidade='" + disponibilidade + '\'' +
                ", Nome='" + Nome + '\'' +
                ", idItem=" + idItem +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
