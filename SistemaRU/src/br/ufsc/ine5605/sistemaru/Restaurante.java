/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class Restaurante {
    private Date diaAtual;
    private HashMap<Date, Integer> acessosRU;
    
    public Restaurante(){
        this.diaAtual = new Date();
        acessosRU = new HashMap();
    }

    public Date getDiaAtual() {
        return diaAtual;
    }

    public void proximoDia(Date proximoDia) {
        this.diaAtual = proximoDia;
        // conta o numero de pessoas que comeu no dia e guarda no hash
    }

    public HashMap<Date, Integer> getAcessosRU() {
        return acessosRU;
    }   
    
}
