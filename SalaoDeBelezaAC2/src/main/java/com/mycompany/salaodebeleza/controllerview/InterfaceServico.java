package com.mycompany.salaodebeleza.controllerview;
/**
 *
 * @author Pedro Henrique Arruda
 */
import com.mycompany.salaodebeleza.model.CarrinhoDeCompras;
import com.mycompany.salaodebeleza.model.Servico;

import java.util.Scanner;

public class InterfaceServico {


    public static void interfaceServicos() {
        Scanner entrada = new Scanner(System.in);
        Servico s1 = new Servico();


        Servico.listarServicos();
        System.out.println("Digite o ID do serviço que você deseja: ");
        int idServico = entrada.nextInt();
        if(s1.verificarID(idServico)) {
            CarrinhoDeCompras.adicionarServico(idServico);
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
            }
        }else{
            System.out.println("ID não encontrado. Tente novamente.");
        }

    }
    public static void interfaceListarServicos() {
        Scanner entrada = new Scanner(System.in);
        Servico.listarServicos();
        System.out.println("Deseja voltar ao menu principal? ");
        System.out.println("1. Sim");
        int opcao = entrada.nextInt();
        switch (opcao) {
            case 1:
                InterfaceProfissionais.interfaceProfissional();
                break;
        }

    }
    public static void interfaceAdicionarServicos() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o nome do serviço: ");
        String nomeServico = entrada.nextLine();

        System.out.println("Digite o valor do serviço: ");
        double valorServico = entrada.nextDouble();
        entrada.nextLine();

        System.out.println("Digite a descricao do serviço: ");
        String descricaoServico = entrada.nextLine();
        System.out.println("Digite o ID do profissional responsável pelo serviço: ");
        int profissionalServico = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Digite a categoria do serviço: ");
        String categoriaServico = entrada.nextLine();
        System.out.println("Digite o gasto do serviço: ");
        double gastoServico = entrada.nextDouble();
        entrada.nextLine();

        System.out.println("Digite o tempo de execução do serviço: (em minutos) ");
        int duracaoServico = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Digite os dias da semana de disponibilidade do serviço: ");
        String disponibilidadeServico = entrada.nextLine();

        Servico s1 = new Servico(nomeServico, valorServico, descricaoServico, profissionalServico, categoriaServico, gastoServico, duracaoServico, disponibilidadeServico);
        if(s1.cadastrarServicos()){
            System.out.println("Serviço registrado com sucesso!");

        }
        else{
            System.out.println("O serviço não foi inserido. Tente novamente.");
            interfaceAdicionarServicos();
        }

        System.out.println("Deseja voltar ao menu principal? ");
        System.out.println("1. Sim");
        int opcao = entrada.nextInt();
        switch (opcao) {
            case 1:
                InterfaceProfissionais.interfaceProfissional();
                break;
        }

    }
    public static void interfaceAlterarServicos() {
        Scanner entrada = new Scanner(System.in);
        Servico s1 = new Servico();

        System.out.println("Digite o  ID do serviço que deseja alterar: ");
        int idServico = entrada.nextInt();
        if(s1.verificarID(idServico)) {
            System.out.println("Selecione a opção que deseja alterar no serviço: ");
            System.out.println("1. Alterar nome. ");
            System.out.println("2. Alterar valor. ");
            System.out.println("3. Alterar descricao.");
            System.out.println("4. Alterar profissional responsável.");
            System.out.println("5. Alterar categoria.");
            System.out.println("6. Alterar gasto.");
            System.out.println("7. Alterar tempo de execução.");
            System.out.println("8. Alterar disponibilidade.");
            int opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o novo nome do serviço: ");
                    entrada.nextLine();
                    String novoNome = entrada.nextLine();

                    if (Servico.alterarNome(novoNome, idServico)) {
                        System.out.println("Serviço alterado com sucesso!");
                        System.out.println("Deseja realizar mais alguma alteração? ");
                        System.out.println("1. Sim.");
                        System.out.println("2. Voltar ao menu principal. ");
                        int opcao2 = entrada.nextInt();
                        switch (opcao2) {
                            case 1:
                                interfaceAlterarServicos();
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
                    System.out.println("Digite o novo valor do serviço: ");
                    double novoValor = entrada.nextDouble();
                    if (Servico.alterarValor(novoValor, idServico)) {
                        System.out.println("Serviço alterado com sucesso!");
                        System.out.println("Deseja realizar mais alguma alteração? ");
                        System.out.println("1. Sim.");
                        System.out.println("2. Voltar ao menu principal. ");
                        int opcao2 = entrada.nextInt();
                        switch (opcao2) {
                            case 1:
                                interfaceAlterarServicos();
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
                    System.out.println("Digite a descrição do serviço: ");
                    entrada.nextLine();
                    String novaDescricao = entrada.nextLine();
                    if (Servico.alterarDescricao(novaDescricao, idServico)) {
                        System.out.println("Serviço alterado com sucesso!");
                        System.out.println("Deseja realizar mais alguma alteração? ");
                        System.out.println("1. Sim.");
                        System.out.println("2. Voltar ao menu principal. ");
                        int opcao2 = entrada.nextInt();
                        switch (opcao2) {
                            case 1:
                                interfaceAlterarServicos();
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
                    System.out.println("Digite o ID do novo profissional responsável pelo serviço: ");
                    int novoProfissionalResponsavel = entrada.nextInt();
                    if (Servico.alterarProfissionalResponsavel(novoProfissionalResponsavel, idServico)) {
                        System.out.println("Serviço alterado com sucesso!");
                        System.out.println("Deseja realizar mais alguma alteração? ");
                        System.out.println("1. Sim.");
                        System.out.println("2. Voltar ao menu principal. ");
                        int opcao2 = entrada.nextInt();
                        switch (opcao2) {
                            case 1:
                                interfaceAlterarServicos();
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
                    System.out.println("Digite a nova categoria do produto: ");
                    entrada.nextLine();
                    String novaCategoria = entrada.nextLine();
                    if (Servico.alterarCategoria(novaCategoria, idServico)) {
                        System.out.println("Serviço alterado com sucesso!");
                        System.out.println("Deseja realizar mais alguma alteração? ");
                        System.out.println("1. Sim.");
                        System.out.println("2. Voltar ao menu principal. ");
                        int opcao2 = entrada.nextInt();
                        switch (opcao2) {
                            case 1:
                                interfaceAlterarServicos();
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
                    System.out.println("Digite o novo gasto do serviço: ");
                    double novaMarca = entrada.nextDouble();
                    if (Servico.alterarGasto(novaMarca, idServico)) {
                        System.out.println("Serviço alterado com sucesso!");
                        System.out.println("Deseja realizar mais alguma alteração? ");
                        System.out.println("1. Sim.");
                        System.out.println("2. Voltar ao menu principal. ");
                        int opcao2 = entrada.nextInt();
                        switch (opcao2) {
                            case 1:
                                interfaceAlterarServicos();
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
                    System.out.println("Digite o novo tempo de execução do serviço:");
                    int novoTempoDeExecucao = entrada.nextInt();
                    if (Servico.alterarTempoDeExecucao(novoTempoDeExecucao, idServico)) {
                        System.out.println("Serviço alterado com sucesso!");
                        System.out.println("Deseja realizar mais alguma alteração? ");
                        System.out.println("1. Sim.");
                        System.out.println("2. Voltar ao menu principal. ");
                        int opcao2 = entrada.nextInt();
                        switch (opcao2) {
                            case 1:
                                interfaceAlterarServicos();
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
                case 8:
                    System.out.println("Digite a nova disponibilidade do serviço:");
                    entrada.nextLine();
                    String novaDisponibilidade = entrada.nextLine();
                    if (Servico.alterarDisponibilidade(novaDisponibilidade, idServico)) {
                        System.out.println("Serviço alterado com sucesso!");
                        System.out.println("Deseja realizar mais alguma alteração? ");
                        System.out.println("1. Sim.");
                        System.out.println("2. Voltar ao menu principal. ");
                        int opcao2 = entrada.nextInt();
                        switch (opcao2) {
                            case 1:
                                interfaceAlterarServicos();
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
                    InterfaceServico.interfaceAlterarServicos();


            }
        } else {
            System.out.println("ID não encontrado na base de dados. Tente novamente. ");
            interfaceAlterarServicos();
        }
    }

        public static void interfaceDeletarServico() {
            Scanner entrada = new Scanner(System.in);
            Servico s1 = new Servico();

            System.out.println("Digite o ID do serviço que você deseja deletar:");
            int idServico = entrada.nextInt();

            if(s1.verificarID(idServico)) {
                if (Servico.deletarServico(idServico)) {
                    System.out.println("Serviço deletado com sucesso!");
                    System.out.println("Deseja voltar ao menu principal? ");
                    System.out.println("1. Sim");
                    System.out.println("2. Deletar outro serviço");
                    int opcao2 = entrada.nextInt();
                    switch (opcao2) {
                        case 1:
                            InterfaceProfissionais.interfaceProfissional();
                            break;
                        case 2:
                            interfaceDeletarServico();
                    }
                } else {
                    System.out.println("O serviço não foi deletado. Tente novamente.");
                    interfaceDeletarServico();
                }
            } else{
                System.out.println("ID não encontrado na base de dados. Tente novamente.");
                interfaceDeletarServico();
            }
        }

}
