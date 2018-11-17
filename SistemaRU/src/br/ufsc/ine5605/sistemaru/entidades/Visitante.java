/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru.entidades;

/**
 *
 * @author 12041789921
 */
public class Visitante extends Pessoa{
    int id;
    
    public Visitante(int id, String nome){
        super(nome);
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
