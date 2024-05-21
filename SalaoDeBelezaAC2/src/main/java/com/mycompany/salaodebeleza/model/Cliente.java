package com.mycompany.salaodebeleza.model;
/**
 *
 * @author Pedro Henrique Arruda
 */
import com.mycompany.salaodebeleza.model.dao.ClienteDAO;
import com.mycompany.salaodebeleza.model.dao.ConnectionDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class Cliente extends Usuario{



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

    public Cliente(String nome, String telefone, String email, String senha) {
        super(nome, telefone, email, senha);
    }

    public Cliente(String email, String senha) {
        super(email, senha);
    }

    @Override
    public boolean cadastrarUsuario(){

        try {
            Connection conn = ConnectionDAO.getConnection();
            return ClienteDAO.realizarCadastro(conn, getNome(), getEmail(), getSenha(), getTelefone());


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean fazerLogin(){
        try {
            Connection conn = ConnectionDAO.getConnection();
            return ClienteDAO.realizarLogin(conn, getEmail(), getSenha());


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não Conectou!");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String toString() {
        return "Cliente: \n" +
                "Nome: " + nome +
                "\nTelefone: " + telefone;
    }
}
