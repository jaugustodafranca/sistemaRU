/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author 12041789921
 */
public abstract class Pessoa implements Crebitavel{
    private String nome;
    float saldo;
    private HashMap<Date, ArrayList<TipoRefeicao>>registrosRefeicoes;

    public Pessoa(String nome) {
        this.nome = nome;
        this.saldo = 0;
        registrosRefeicoes = new HashMap();
    }
       
    @Override
    public void adicionarSaldo(float saldo) {
        this.saldo += saldo;
    }

    @Override
    public void descontaSaldo(float saldo) {
        this.saldo -= saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public HashMap<Date, ArrayList<TipoRefeicao>> getRegistrosRefeicoes() {
        return registrosRefeicoes;
    }

    public void adicionaRefeicao(Date data, TipoRefeicao tipo) {
        ArrayList <TipoRefeicao> refeicoesDiaInclusa ;
        if (registrosRefeicoes.containsKey(data)){
            refeicoesDiaInclusa = registrosRefeicoes.get(data);
            refeicoesDiaInclusa.add(tipo);
            }else{
            refeicoesDiaInclusa = new ArrayList<>();
            refeicoesDiaInclusa.add(tipo);
        }
        registrosRefeicoes.put(data, refeicoesDiaInclusa);
    }
}
