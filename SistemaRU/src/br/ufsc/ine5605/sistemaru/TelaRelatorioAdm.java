/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

/**
 *
 * @author Usuario
 */
class TelaRelatorioAdm extends TelaPadrao{
    private ControladorRelatorioAdm controladorRelatorioAdm;
   
  
    
    

    public TelaRelatorioAdm(ControladorRelatorioAdm controladorRelatorioAdm) {
        this.controladorRelatorioAdm = controladorRelatorioAdm;
    }
    
    @Override
    public void mostraConteudoTela() {
        System.out.println("##################################");
        System.out.println("######  MENU RELATORIO ADM  ######");
        System.out.println("##################################");
        System.out.println("");
        System.out.println("FORMATO DE ENTRADA DAS DATAS (DD/MM/AAAA)");
        System.out.print("DIGITE DA INICIAL: ");
        controladorRelatorioAdm.getCounteudoTelaRelatorioAdm().dataInicial = leString();
        System.out.print("DIGITE DA FINAL: ");
        controladorRelatorioAdm.getCounteudoTelaRelatorioAdm().dataFinal = leString();
        
        controladorRelatorioAdm.relatorioRefeicao();      
    }
    
}
