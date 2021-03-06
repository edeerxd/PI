/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ctrl_soft;

import java.util.Date;

/**
 *
 * @author Eder Rodrigues
 */
public class Produto {
    protected Long id;
    protected Long id_filial;
    protected String nome;
    protected String marca;
    protected double preco;
    protected int qtde;
    protected Date dtCadastro;
    
    public Produto(){
        
    }
    public Produto(String n, String m, double p, int q){
        this.nome=n;
        this.marca=m;
        this.preco=p;
        this.qtde=q;
        this.dtCadastro=new Date();
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_filial() {
        return id_filial;
    }

    public void setId_filial(long id_filial) {
        this.id_filial = id_filial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
}
