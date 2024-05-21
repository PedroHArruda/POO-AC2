package com.mycompany.salaodebeleza.model;
/**
 *
 * @author Pedro Henrique Arruda
 */
import com.mycompany.salaodebeleza.model.dao.ConnectionDAO;
import com.mycompany.salaodebeleza.model.dao.ProfissionalDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class Profissional extends Usuario{

    private String funcao;

    public String getFuncao() {
        return funcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Profissional(String nome, String telefone, String email, String senha, String funcao) {
        super(nome, telefone, email, senha);
        this.funcao = funcao;
    }

    public Profissional(String email, String senha) {
        super(email, senha);
    }


    @Override
    public boolean fazerLogin(){
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ProfissionalDAO.realizarLogin(conn, getEmail(), getSenha());


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean cadastrarUsuario(){

        try {
            Connection conn = ConnectionDAO.getConnection();
            return ProfissionalDAO.realizarCadastro(conn, getNome(), getEmail(), getFuncao(), getSenha(), getTelefone());


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }

    }

    public static void listarProfissionais() {
        try {
            Connection conn = ConnectionDAO.getConnection();
            for(String linha: ProfissionalDAO.selectProfissionais(conn)){
                System.out.println(linha);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();

        }
    }
}
