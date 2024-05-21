package com.mycompany.salaodebeleza.model;
/**
 *
 * @author Pedro Henrique Arruda
 */
import com.mycompany.salaodebeleza.model.dao.ConnectionDAO;
import com.mycompany.salaodebeleza.model.dao.ProdutosDAO;
import com.mycompany.salaodebeleza.model.dao.ServicosDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private static List<ItemPagavel> itens = new ArrayList<>();

    public CarrinhoDeCompras(){

    }


    public static void adicionarProduto(int idProduto, int quantidade) {
        try {
            Connection conn = ConnectionDAO.getConnection();
            Produto produto = ProdutosDAO.buscarProduto(conn, idProduto);
            if (produto != null) {
                for (int i = 0; i < quantidade; i++) {
                    adicionarItem(produto);
                }
            } else {
                System.out.println("Produto não encontrado.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
        }

    }

    public static void adicionarServico(int idServico) {
        try {
            Connection conn = ConnectionDAO.getConnection();
            Servico servico = ServicosDAO.buscarServico(conn, idServico);
            if (servico != null) {
                    adicionarItem(servico);
            } else {
                System.out.println("Serviço não encontrado.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
        }
    }

    private static void adicionarItem(ItemPagavel item) {
        itens.add(item);
    }

    public static double getValorTotal() {
        double total = 0;
        for (ItemPagavel item : itens) {
            total += item.getValor();
        }
        return total;
    }

    public static void listarItens() {
        System.out.println("-------------------------------------------");
        for (int i = 0; i < itens.size(); i++) {
            ItemPagavel item = itens.get(i);
            System.out.println((i + 1) + ". Nome: " + item.getNome() + ", Valor: R$" + item.getValor());
        }
        System.out.println("Valor total: R$" + getValorTotal());
        System.out.println("-------------------------------------------");
    }

    public static void limparCarrinho(){
        itens.clear();
    }


}
