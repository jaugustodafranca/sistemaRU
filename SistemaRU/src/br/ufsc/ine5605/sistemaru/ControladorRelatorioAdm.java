/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author 12041789921
 */
public class ControladorRelatorioAdm {
    private TelaRelatorioAdm telaRelatorioAdm; 
    private CounteudoTelaRelatorioAdm counteudoTelaRelatorioAdm;
     private ControladorPrincipal controladorPrincipal;

    public ControladorRelatorioAdm(ControladorPrincipal controladorPrincipal) {
        this.telaRelatorioAdm = new TelaRelatorioAdm(this);
        this.counteudoTelaRelatorioAdm = new CounteudoTelaRelatorioAdm();
    }

    public TelaRelatorioAdm getTelaRelatorioAdm() {
        return telaRelatorioAdm;
    }

    public CounteudoTelaRelatorioAdm getCounteudoTelaRelatorioAdm() {
        return counteudoTelaRelatorioAdm;
    }
    
    public void relatorioRefeicao(){
        Date dataInicial = stringToDate(counteudoTelaRelatorioAdm.dataInicial);
        Date dataFinal = stringToDate(counteudoTelaRelatorioAdm.dataFinal);
        Date atual = dataInicial;
        int contadorRefeicoes = 0;
        System.out.println(dataInicial);
        System.out.println(dataFinal);
        HashMap<Date,Integer> acessosRU = controladorPrincipal.getRestaurante().getAcessosRU();
        Collection<Date> teste = acessosRU.keySet();
        while(atual.before(dataFinal)){
            
            contadorRefeicoes+= acessosRU.get(atual);
            atual = new Date(atual.getTime() + (1000*60*60*24));
        }
        System.out.println("CONTADOR REFEICOES: " + contadorRefeicoes);
    }
    
    public Date stringToDate(String data){
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.parse(data);
        } catch(Exception e) {
            System.out.println(e);
            return null;
        }
        
        
    }
}
