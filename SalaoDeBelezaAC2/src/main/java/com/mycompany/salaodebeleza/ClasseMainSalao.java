/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.salaodebeleza;

import com.mycompany.salaodebeleza.controllerview.InterfaceCliente;
import com.mycompany.salaodebeleza.controllerview.InterfaceProfissionais;

import java.util.Scanner;

/**
 *
 * @author Pedro Henrique Arruda
 */
public class ClasseMainSalao {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-----------------------------------");
        System.out.println("Seja bem vindo ao Salão de Beleza!");
        System.out.println("-----------------------------------");
        System.out.println("Você deseja entrar como cliente ou profissional?");
        System.out.println("1. Cliente.");
        System.out.println("2. Profissional.");
        System.out.println("-----------------------------------");
        int opcao = entrada.nextInt();
        switch(opcao){
            case 1:
                InterfaceCliente.interfaceEntrarCliente();
                break;
            case 2:
                InterfaceProfissionais.interfaceEntrarProfissional();
                break;
            default:
                System.out.println("Opção inválida.");
        }


    }


}
