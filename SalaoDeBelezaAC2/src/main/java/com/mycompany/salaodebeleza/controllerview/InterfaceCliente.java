package com.mycompany.salaodebeleza.controllerview;
/**
 *
 * @author Pedro Henrique Arruda
 */
import com.mycompany.salaodebeleza.model.CarrinhoDeCompras;
import com.mycompany.salaodebeleza.model.Cliente;

import java.util.Scanner;

public class InterfaceCliente {

    public static void interfaceEntrarCliente(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Você, cliente, já possui cadastro em nosso sistema? ");
        System.out.println("1. Sim.");
        System.out.println("2. Não.");
        int opcao = entrada.nextInt();

        switch(opcao){
            case 1:
                interfaceLogin();
                break;
            case 2:
                interfaceCadastroCliente();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }

    public static void interfaceLogin(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite seu email: ");
        String email = entrada.next();
        entrada.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = entrada.nextLine();

        Cliente c2 = new Cliente(email, senha);
        if(c2.fazerLogin()){
            System.out.println("Login realizado com sucesso! Seja bem-vindo(a)!");
            System.out.println("-----------------------------------");
            interfaceCliente();
        }
        else{
            System.out.println("Erro ao fazer login, tente novamente.");
            System.out.println("-----------------------------------");
            interfaceLogin();
        }


    }

    public static void interfaceCadastroCliente(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = entrada.next();
        System.out.println("Digite seu email: ");
        String emailCadastro = entrada.next();
        System.out.println("Digite seu número de telefone: ");
        String numeroCadastro = entrada.next();
        System.out.println("Digite sua senha: ");
        String senhaCadastro = entrada.next();

        Cliente c1 = new Cliente(nome, emailCadastro, senhaCadastro, numeroCadastro);
        if(c1.cadastrarUsuario()){
            System.out.println("Cadastro realizado com sucesso! Seja bem-vindo(a) " + c1.getNome());
            interfaceCliente();
        }else{
            System.out.println("Não foi possível realizar o cadastro. Reveja seus dados e tente novamente.");
            interfaceCadastroCliente();
        }
    }

    public static void interfaceCliente() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Selecione a opção desejada: (digite apenas o número)");
        System.out.println("1. Serviço");
        System.out.println("2. Itens de beleza");

        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1:
                InterfaceServico.interfaceServicos();
                break;
            case 2:
                InterfaceProduto.interfaceProdutos();
                break;
        }

    }


    public static void finalizarCompra() {
        Scanner entrada = new Scanner(System.in);
        CarrinhoDeCompras.listarItens();
        System.out.println("Digite o numero da opção desejada: ");
        System.out.println("1. Realizar pagamento.");
        System.out.println("2. Voltar ao menu principal. ");
        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1:
                formaDePagamento();
                break;
            case 2:
                interfaceCliente();
                break;
        }
    }

    public static void compraFinalizada(){
        Scanner entrada = new Scanner(System.in);

        CarrinhoDeCompras.limparCarrinho();
        System.out.println("Compra finalizada com sucesso! Agradecemos pela preferência!");
        System.out.println("Escolha como deseja prosseguir: ");
        System.out.println("1. Realizar uma nova compra");
        System.out.println("2. Sair");
        int opcao = entrada.nextInt();

        switch(opcao){
            case 1:
                interfaceCliente();
                break;
            case 2:
                System.out.println("Espero que volte novamente!");
                System.exit(0);
                break;
        }


    }

    public static void formaDePagamento(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("O valor total da sua compra é: R$" + CarrinhoDeCompras.getValorTotal());
        System.out.println("Escolha a forma de pagamento: ");
        System.out.println("1. Pix.");
        System.out.println("2. Boleto Bancário.");
        System.out.println("3. Cartão de Crédito.");
        System.out.println("4. Cartão de Débito.");
        int opcao = entrada.nextInt();

        switch(opcao){
            case 1:
                System.out.println("Você escolheu a opção Pix. ");
                compraFinalizada();
                break;
            case 2:
                System.out.println("Você escolheu a opção Boleto Bancário. ");
                compraFinalizada();
                break;
            case 3:
                System.out.println("Você escolheu a opção Cartão de Crédito. ");
                compraFinalizada();
                break;
            case 4:
                System.out.println("Você escolheu a opção Cartão de Débito. ");
                compraFinalizada();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                formaDePagamento();
                break;
        }
    }

}
