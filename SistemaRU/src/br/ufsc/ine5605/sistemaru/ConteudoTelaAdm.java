/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

/**
 *
 * @author franca
 */
public class ConteudoTelaAdm {
    
    public String nome;
    public boolean isencao;
    public boolean admin;
    public int codigo;
    public float saldo;
    
    
    public ConteudoTelaAdm() {
        
    }
    
    public ConteudoTelaAdm(String nome) {
        this.nome = nome;
    }
    public ConteudoTelaAdm(int codigo){
        this.codigo = codigo;
    }
   
    public ConteudoTelaAdm(String nome, int codigo, boolean admin) {
        this.codigo = codigo;
        this.nome = nome;
        this.admin = admin;
    }

    public ConteudoTelaAdm(String nome,int codigo, boolean admin, boolean isencao) {
        this.codigo = codigo;
        this.nome = nome;
        this.isencao = isencao;
        this.admin = admin;
    }

    public ConteudoTelaAdm(int codigo,float saldo) {
        this.codigo = codigo; 
        this.saldo = saldo;
    }
    public ConteudoTelaAdm(int codigo,String nome) {
        this.codigo = codigo; 
        this.nome = nome;
    }
    
}
