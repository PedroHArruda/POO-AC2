/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salaodebeleza.model;

/**
 *
 * @author Pedro Henrique Arruda
 */
public class ItemPagavel {


    protected String Nome;

    protected int idItem;

    protected double valor;
    protected String descricao;

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ItemPagavel(String nome, double valor, String descricao) {
        Nome = nome;
        this.valor = valor;
        this.descricao = descricao;
    }

    public ItemPagavel(int idItem, String nome, double valor, String descricao) {
        this.idItem = idItem;
        Nome = nome;
        this.valor = valor;
        this.descricao = descricao;
    }

    public ItemPagavel() {

    }

    public boolean verificarID(int idItem) {
        return false;
    }
}

