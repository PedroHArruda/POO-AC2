package com.mycompany.salaodebeleza.model;
/**
 *
 * @author Pedro Henrique Arruda
 */
public class Usuario {

    protected String nome;
    protected String telefone;
    protected String email;
    protected String senha;

    public Usuario(String nome, String telefone, String email, String senha) {
        this.nome = email;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }
    public Usuario(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean fazerLogin(){

        return false;
    }

    public boolean cadastrarUsuario(){

        return false;
    }



}
