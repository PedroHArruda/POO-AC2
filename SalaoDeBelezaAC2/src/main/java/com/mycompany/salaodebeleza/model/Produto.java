package com.mycompany.salaodebeleza.model;
/**
 *
 * @author Pedro Henrique Arruda
 */
import com.mycompany.salaodebeleza.model.dao.ConnectionDAO;
import com.mycompany.salaodebeleza.model.dao.ProdutosDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class Produto extends ItemPagavel{
    //Adicionar mais um atributo
    private int estoque;
    private String fornecedor;
    private String marca;
    private String dataValidade;

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Produto(String nome, double valor, String descricao, int estoque, String fornecedor, String marca, String dataValidade) {
        super(nome, valor, descricao);
        this.estoque = estoque;
        this.fornecedor = fornecedor;
        this.marca = marca;
        this.dataValidade = dataValidade;
    }

    public Produto(int idProduto, String nome, double valor, String descricao, int estoque, String fornecedor, String marca, String dataValidade) {
        super(idProduto, nome, valor, descricao);
        this.estoque = estoque;
        this.fornecedor = fornecedor;
        this.marca = marca;
        this.dataValidade = dataValidade;
    }

    public Produto(){

    }
    public static void listarProdutos() {
        try {
            Connection conn = ConnectionDAO.getConnection();
            for(String linha: ProdutosDAO.selectProdutos(conn)){
                System.out.println(linha);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();

        }
    }

    public boolean cadastrarProdutos(){

        try {
            Connection conn = ConnectionDAO.getConnection();
            return ProdutosDAO.cadastrarProdutos(conn, getNome(), getValor(), getDescricao(), getEstoque(), getFornecedor(), getMarca(), getDataValidade());

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }

    }


    public static boolean alterarNome(String novoNome, int idProduto){
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ProdutosDAO.alterarProduto(conn, "Nome", novoNome, idProduto);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }
    public static boolean alterarValor(Double novoValor, int idProduto){
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ProdutosDAO.alterarProduto(conn, novoValor, idProduto);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }
    public static boolean alterarDescricao(String novaDescricao, int idProduto){
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ProdutosDAO.alterarProduto(conn, "Descricao", novaDescricao, idProduto);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }
    public static boolean alterarEstoque(int novoEstoque, int idProduto){
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ProdutosDAO.alterarProduto(conn, novoEstoque, idProduto);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }
    public static boolean alterarFornecedor(String novoFornecedor, int idProduto){
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ProdutosDAO.alterarProduto(conn, "Fornecedor", novoFornecedor, idProduto);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }
    public static boolean alterarMarca(String novaMarca, int idProduto){
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ProdutosDAO.alterarProduto(conn, "Marca", novaMarca, idProduto);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }
    public static boolean alterarValidade(String novaValidade, int idProduto){
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ProdutosDAO.alterarProduto(conn, novaValidade, idProduto);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deletarProduto(int idProduto){
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ProdutosDAO.deletarProduto(conn, idProduto);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean verificarID(int idProduto){
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ProdutosDAO.checarIdProduto(conn, idProduto);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String toString() {
        return "Produto:" +
                "\nNome: " + Nome +
                "\nID: " + idItem +
                "\nValor: R$" + valor +
                "\nDescricao: " + descricao +
                "\nEstoque: " + estoque +
                "\nFornecedor: " + fornecedor +
                "\nMarca: " + marca +
                "\nData de Validade: " + dataValidade;
    }
}
