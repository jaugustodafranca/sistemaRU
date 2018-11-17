/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru.telas;

import br.ufsc.ine5605.sistemaru.controladores.ControladorRelatorioAdm;

/**
 *
 * @author Usuario
 */
public class TelaRelatorioAdm extends TelaPadrao{

   
 
    

    public TelaRelatorioAdm() {

    }
    
    @Override
    public void mostraConteudoTela() {
        clear();
        System.out.println("##################################");
        System.out.println("######  MENU RELATORIO ADM  ######");
        System.out.println("##################################");
        System.out.println("");
        System.out.println("FORMATO DE ENTRADA DAS DATAS (DD/MM/AAAA)");
        System.out.print("DIGITE DA INICIAL: ");
        ControladorRelatorioAdm.getInstance().getConteudoTelaRelatorioAdm().dataInicial = leString();
        System.out.print("DIGITE DA FINAL: ");
        ControladorRelatorioAdm.getInstance().getConteudoTelaRelatorioAdm().dataFinal = leString();
        
        ControladorRelatorioAdm.getInstance().relatorioRefeicao();      
    }
    
    public void mostraRelatorio(String dataInicial, String dataFinal, int count){
        System.out.println("");
        System.out.println("#############################");
        System.out.println("######  RELATORIO ADM  ######");
        System.out.println("#############################");
        System.out.println("");
        System.out.println("DE "+dataInicial+" ATÉ "+ dataFinal + "\nFORAM REGISTRADOS " + count + " ACESSOS AO RESTAURANTE.");
    
    }
    
}
