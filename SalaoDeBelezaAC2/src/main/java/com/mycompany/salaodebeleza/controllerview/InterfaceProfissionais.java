package com.mycompany.salaodebeleza.controllerview;
/**
 *
 * @author Pedro Henrique Arruda
 */
import com.mycompany.salaodebeleza.model.Profissional;

import java.util.Scanner;

public class InterfaceProfissionais {
    public static void interfaceEntrarProfissional(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Você, profissional, já possui cadastro em nosso sistema? ");
        System.out.println("1. Sim.");
        System.out.println("2. Não.");
        int opcao = entrada.nextInt();

        switch(opcao){
            case 1:
                interfaceLoginProfissional();
                break;
            case 2:
                interfaceCadastroProfissional();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }
    public static void interfaceLoginProfissional(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite seu email: ");
        String email = entrada.next();
        entrada.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = entrada.nextLine();

        Profissional p1 = new Profissional(email, senha);
        if(p1.fazerLogin()){
            System.out.println("Login realizado com sucesso! Seja bem-vindo(a)");
            interfaceProfissional();

        }
        else{
            System.out.println("Erro ao realizar login! Tente novamente!");
            interfaceLoginProfissional();
        }
    }

    public static void interfaceCadastroProfissional(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do profissional: ");
        entrada.nextLine();
        String nome = entrada.nextLine();
        System.out.println("Digite o email do profissional: ");
        String emailCadastro = entrada.next();
        System.out.println("Digite a função do profissional: ");
        entrada.nextLine();
        String funcaoCadastro = entrada.nextLine();
        System.out.println("Digite o número de telefone do profissional: ");
        String numeroCadastro = entrada.next();
        System.out.println("Digite a senha: ");
        String senhaCadastro = entrada.next();

        Profissional p1 = new Profissional(nome, numeroCadastro, emailCadastro, senhaCadastro, funcaoCadastro);
        if(p1.cadastrarUsuario()){
            System.out.println("Cadastro realizado com sucesso! Seja bem-vindo(a)" + p1.getNome());
            interfaceProfissional();

        }else{
            System.out.println("Não foi possível realizar o cadastro. Reveja seus dados e tente novamente.");
            interfaceCadastroProfissional();
        }
    }

    public static void interfaceProfissional() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite a opção que deseja: ");
        System.out.println("1. Listar Produtos. ");
        System.out.println("2. Listar Serviços. ");
        System.out.println("3. Listar Profissionais. ");
        System.out.println("4. Adicionar Produto.");
        System.out.println("5. Adicionar Serviço.");
        System.out.println("6. Alterar Produto.");
        System.out.println("7. Alterar Serviço.");
        System.out.println("8. Deletar Produto.");
        System.out.println("9. Deletar Serviço.");
        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1:
                InterfaceProduto.interfaceListarProdutos();
                break;
            case 2:
                InterfaceServico.interfaceListarServicos();
                break;
            case 3:
                interfaceListarProfissionais();
                break;
            case 4:
                InterfaceProduto.interfaceAdicionarProdutos();
                break;
            case 5:
                InterfaceServico.interfaceAdicionarServicos();
                break;
            case 6:
                InterfaceProduto.interfaceAlterarProdutos();
                break;
            case 7:
                InterfaceServico.interfaceAlterarServicos();
                break;
            case 8:
                InterfaceProduto.interfaceDeletarProduto();
                break;
            case 9:
                InterfaceServico.interfaceDeletarServico();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                interfaceProfissional();
        }
    }




    public static void interfaceListarProfissionais() {
        Scanner entrada = new Scanner(System.in);
        Profissional.listarProfissionais();
        System.out.println("Deseja voltar ao menu principal? ");
        System.out.println("1. Sim");
        int opcao = entrada.nextInt();
        switch (opcao) {
            case 1:
                interfaceProfissional();
                break;
        }

    }
}
