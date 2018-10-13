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
class TelaPrincipal extends TelaPadrao{
    
    private ControladorPrincipal controladorPrincipal;

    public TelaPrincipal(ControladorPrincipal controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
    }

    public ControladorPrincipal getControladorPrincipal() {
        return controladorPrincipal;
    }
    
    @Override
    public void mostraConteudoTela() {
        int id = 0;
        do{
            System.out.println("######  SISTEMA DE CONTROLE DO RESTAURANTE UNIVERSITÁRIO  ######");
            System.out.println("DIGITE SEU NÚMERO DE MATRÍCULA");
            //System.out.println("[0] FINALIZAR SISTEMA");
            id = leInteiro();
            
            switch(id){
                case 0: 
                    break;
                default:
                    getControladorPrincipal().validaLogin(id);
                    break;
            }
        }while (id==0);
        
        
        
    }
    
}
