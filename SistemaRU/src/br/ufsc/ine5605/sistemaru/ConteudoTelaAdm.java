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
    public int id;
    public String nome;
    public boolean Isencao;
    public boolean admin;
    public int matricula;
    
    public ConteudoTelaAdm() {
        
    }
    
    public ConteudoTelaAdm(String nome) {
        this.nome = nome;
    }

    public ConteudoTelaAdm(String nome, int matricula, boolean admin) {
        this.matricula = matricula;
        this.nome = nome;
        this.admin = admin;
    }

    public ConteudoTelaAdm(String nome,int matricula, boolean admin, boolean Isencao) {
        this.matricula = matricula;
        this.nome = nome;
        this.Isencao = Isencao;
        this.admin = admin;
    }

   

    
    
    
}
