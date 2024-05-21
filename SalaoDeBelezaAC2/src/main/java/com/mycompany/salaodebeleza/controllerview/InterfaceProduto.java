package com.mycompany.salaodebeleza.controllerview;
/**
 *
 * @author Pedro Henrique Arruda
 */
import com.mycompany.salaodebeleza.model.CarrinhoDeCompras;
import com.mycompany.salaodebeleza.model.Produto;
import com.mycompany.salaodebeleza.model.Servico;

import java.util.Scanner;


public class InterfaceProduto {

    public static void interfaceProdutos() {
        Scanner entrada = new Scanner(System.in);
        Produto p1 = new Produto();

        System.out.println("Lista de produtos:");
        Produto.listarProdutos();
        System.out.println("Digite o ID do produto que você deseja adicionar ao carrinho: ");
        int idProduto = entrada.nextInt();

        if(p1.verificarID(idProduto)){
            System.out.println("Insira a quantidade que você deseja adicionar ao carrinho:");
            int qtdProduto = entrada.nextInt();
            CarrinhoDeCompras.adicionarProduto(idProduto, qtdProduto);

        }else{
            System.out.println("Produto não encontrado. Tente novamente.");
            interfaceProdutos();
        }


        System.out.println("Produto adicionado no carrinho.");
        System.out.println("Escolha como deseja prosseguir: ");
        System.out.println("1. Voltar ao menu principal.");
        System.out.println("2. Visualizar carrinho");
        System.out.println("3. Finalizar compra");
        int opcaoProsseguir2 = entrada.nextInt();

        switch (opcaoProsseguir2) {
            case 1:
                InterfaceCliente.interfaceCliente();
                break;
            case 2:
                CarrinhoDeCompras.listarItens();
            case 3:
                InterfaceCliente.finalizarCompra();
                break;
            default:
                System.out.println("Opção inválida. Você foi redirecionado ao menu principal.");
                InterfaceCliente.interfaceCliente();
        }
    }

    public static void interfaceListarProdutos() {
        Scanner entrada = new Scanner(System.in);
        Produto.listarProdutos();
        System.out.println("Deseja voltar ao menu principal? ");
        System.out.println("1. Sim");
        int opcao = entrada.nextInt();
        switch (opcao) {
            case 1:
                InterfaceProfissionais.interfaceProfissional();
                break;
            default:
                System.out.println("Opção inválida.");
                System.out.println("Você será redirecionado ao menu principal.");
                InterfaceProfissionais.interfaceProfissional();
        }

    }

    public static void interfaceAdicionarProdutos() {
        Scanner entrada = new Scanner(System.in);


        System.out.println("Digite o nome do produto: ");
        String nomeProduto = entrada.nextLine();
        System.out.println("Digite o valor do produto: ");
        double valorProduto = entrada.nextDouble();
        entrada.nextLine();
        System.out.println("Digite a descricao do produto: ");
        String descricaoProduto = entrada.nextLine();
        System.out.println("Digite a quantidade em estoque do produto: ");
        int estoqueProduto = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o fornecedor do produto: ");
        String fornecedorProduto = entrada.nextLine();
        System.out.println("Digite a marca do produto: ");
        String marcaProduto = entrada.nextLine();
        System.out.println("Digite a data de validade do produto: (formato YYYY-MM-DD) ");
        String dataValidadeProduto = entrada.nextLine();

        Produto p1 = new Produto(nomeProduto, valorProduto, descricaoProduto, estoqueProduto, fornecedorProduto, marcaProduto, dataValidadeProduto);

        if(p1.cadastrarProdutos()){
            System.out.println("Produto inserido com sucesso!");
        }
        else{
            System.out.println("O produto não foi inserido. Tente novamente.");
            interfaceAdicionarProdutos();
        }

        System.out.println("Deseja voltar ao menu principal? ");
        System.out.println("1. Sim");
        int opcao = entrada.nextInt();
        switch (opcao) {
            case 1:
                InterfaceProfissionais.interfaceProfissional();
                break;
            default:
                System.out.println("Opção inválida. Você foi redirecionado ao menu principal.");
                InterfaceProfissionais.interfaceProfissional();
                break;
        }

    }

    public static void interfaceAlterarProdutos() {
        Scanner entrada = new Scanner(System.in);
        Produto p1 = new Produto();

        System.out.println("Digite o  ID do produto que deseja alterar: ");
        int idProduto = entrada.nextInt();

        if(p1.verificarID(idProduto)) {
            System.out.println("Selecione a opção que deseja alterar no produto: ");
            System.out.println("1. Alterar nome. ");
            System.out.println("2. Alterar valor. ");
            System.out.println("3. Alterar descricao.");
            System.out.println("4. Alterar estoque.");
            System.out.println("5. Alterar fornecedor.");
            System.out.println("6. Alterar marca.");
            System.out.println("7. Alterar validade.");
            int opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o novo nome do produto: ");
                    entrada.nextLine();
                    String novoNome = entrada.nextLine();

                    if (Produto.alterarNome(novoNome, idProduto)) {
                        System.out.println("Produto alterado com sucesso!");
                        System.out.println("Deseja realizar mais alguma alteração? ");
                        System.out.println("1. Sim.");
                        System.out.println("2. Voltar ao menu principal. ");
                        int opcao2 = entrada.nextInt();
                        switch (opcao2) {
                            case 1:
                                interfaceAlterarProdutos();
                                break;

                            case 2:
                                InterfaceProfissionais.interfaceProfissional();
                                break;
                            default:
                                System.out.println("Opção inválida. Você foi redirecionado ao menu principal.");
                                InterfaceProfissionais.interfaceProfissional();

                        }

                    }

                    break;
                case 2:
                    System.out.println("Digite o novo valor do produto: ");
                    double novoValor = entrada.nextDouble();
                    if (Produto.alterarValor(novoValor, idProduto)) {
                        System.out.println("Produto alterado com sucesso!");
                        System.out.println("Deseja realizar mais alguma alteração? ");
                        System.out.println("1. Sim.");
                        System.out.println("2. Voltar ao menu principal. ");
                        int opcao2 = entrada.nextInt();
                        switch (opcao2) {
                            case 1:
                                interfaceAlterarProdutos();
                                break;

                            case 2:
                                InterfaceProfissionais.interfaceProfissional();
                                break;
                            default:
                                System.out.println("Opção inválida. Você foi redirecionado ao menu principal.");
                                InterfaceProfissionais.interfaceProfissional();

                        }

                    }

                    break;
                case 3:
                    System.out.println("Digite a descrição do produto: ");
                    entrada.nextLine();
                    String novaDescricao = entrada.nextLine();
                    if (Produto.alterarDescricao(novaDescricao, idProduto)) {
                        System.out.println("Produto alterado com sucesso!");
                        System.out.println("Deseja realizar mais alguma alteração? ");
                        System.out.println("1. Sim.");
                        System.out.println("2. Voltar ao menu principal. ");
                        int opcao2 = entrada.nextInt();
                        switch (opcao2) {
                            case 1:
                                interfaceAlterarProdutos();
                                break;

                            case 2:
                                InterfaceProfissionais.interfaceProfissional();
                                break;
                            default:
                                System.out.println("Opção inválida. Você foi redirecionado ao menu principal.");
                                InterfaceProfissionais.interfaceProfissional();

                        }

                    }
                    break;
                case 4:
                    System.out.println("Digite o novo estoque do produto: ");
                    int novoEstoque = entrada.nextInt();
                    if (Produto.alterarEstoque(novoEstoque, idProduto)) {
                        System.out.println("Produto alterado com sucesso!");
                        System.out.println("Deseja realizar mais alguma alteração? ");
                        System.out.println("1. Sim.");
                        System.out.println("2. Voltar ao menu principal. ");
                        int opcao2 = entrada.nextInt();
                        switch (opcao2) {
                            case 1:
                                interfaceAlterarProdutos();
                                break;

                            case 2:
                                InterfaceProfissionais.interfaceProfissional();
                                break;
                            default:
                                System.out.println("Opção inválida. Você foi redirecionado ao menu principal.");
                                InterfaceProfissionais.interfaceProfissional();

                        }

                    }
                    break;
                case 5:
                    System.out.println("Digite o novo fornecedor do produto: ");
                    entrada.nextLine();
                    String novoFornecedor = entrada.nextLine();
                    if (Produto.alterarFornecedor(novoFornecedor, idProduto)) {
                        System.out.println("Produto alterado com sucesso!");
                        System.out.println("Deseja realizar mais alguma alteração? ");
                        System.out.println("1. Sim.");
                        System.out.println("2. Voltar ao menu principal. ");
                        int opcao2 = entrada.nextInt();
                        switch (opcao2) {
                            case 1:
                                interfaceAlterarProdutos();
                                break;

                            case 2:
                                InterfaceProfissionais.interfaceProfissional();
                                break;
                            default:
                                System.out.println("Opção inválida. Você foi redirecionado ao menu principal.");
                                InterfaceProfissionais.interfaceProfissional();

                        }

                    }
                    break;
                case 6:
                    System.out.println("Digite a nova marca do produto: ");
                    entrada.nextLine();
                    String novaMarca = entrada.nextLine();
                    if (Produto.alterarMarca(novaMarca, idProduto)) {
                        System.out.println("Produto alterado com sucesso!");
                        System.out.println("Deseja realizar mais alguma alteração? ");
                        System.out.println("1. Sim.");
                        System.out.println("2. Voltar ao menu principal. ");
                        int opcao2 = entrada.nextInt();
                        switch (opcao2) {
                            case 1:
                                interfaceAlterarProdutos();
                                break;

                            case 2:
                                InterfaceProfissionais.interfaceProfissional();
                                break;
                            default:
                                System.out.println("Opção inválida. Você foi redirecionado ao menu principal.");
                                InterfaceProfissionais.interfaceProfissional();

                        }
                    }
                    break;
                case 7:
                    System.out.println("Digite a nova validade do produto: (formato: YYYY-MM-DD)");
                    String novaValidade = entrada.next();
                    if (Produto.alterarMarca(novaValidade, idProduto)) {
                        System.out.println("Produto alterado com sucesso!");
                        System.out.println("Deseja realizar mais alguma alteração? ");
                        System.out.println("1. Sim.");
                        System.out.println("2. Voltar ao menu principal. ");
                        int opcao2 = entrada.nextInt();
                        switch (opcao2) {
                            case 1:
                                interfaceAlterarProdutos();
                                break;

                            case 2:
                                InterfaceProfissionais.interfaceProfissional();
                                break;
                            default:
                                System.out.println("Opção inválida. Você foi redirecionado ao menu principal.");
                                InterfaceProfissionais.interfaceProfissional();

                        }
                    }
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    interfaceAlterarProdutos();


            }
        } else {
            System.out.println("ID não encontrado na base de dados. Tente novamente!");
            interfaceAlterarProdutos();
        }

    }

    public static void interfaceDeletarProduto() {
        Scanner entrada = new Scanner(System.in);
        Produto p1 = new Produto();

        System.out.println("Digite o ID do produto que você deseja deletar:");
        int idProduto = entrada.nextInt();
        if(p1.verificarID(idProduto)){
            if(Servico.deletarServico(idProduto)){
                System.out.println("Produto deletado com sucesso!");
                System.out.println("Deseja voltar ao menu principal? ");
                System.out.println("1. Sim");
                System.out.println("2. Deletar outro serviço");
                int opcao2 = entrada.nextInt();
                switch (opcao2) {
                    case 1:
                        InterfaceProfissionais.interfaceProfissional();
                        break;
                    case 2:
                        interfaceDeletarProduto();
                    default:
                        System.out.println("Opção inválida. Você foi redirecionado ao menu principal.");
                        InterfaceProfissionais.interfaceProfissional();
                }
            } else {
                System.out.println("O serviço não foi deletado. Tente novamente.");
                interfaceDeletarProduto();
            }
        } else {
            System.out.println("ID não encontrado na base de dados. Tente novamente!");
            interfaceDeletarProduto();
        }

    }

}
