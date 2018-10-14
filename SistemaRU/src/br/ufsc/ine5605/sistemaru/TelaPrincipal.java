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
        clear();
        int id;
        boolean existe = false;
        do{
            
            System.out.println("################################################################");
            System.out.println("######  SISTEMA DE CONTROLE DO RESTAURANTE UNIVERSITÁRIO  ######");
            System.out.println("################################################################");
            System.out.println("");
            System.out.print("DIGITE SEU NÚMERO DE MATRÍCULA: ");
            
            id = leInteiro();
            
            switch(id){
                case 0: 
                    break;
                default:
                    try{
                        getControladorPrincipal().validaLogin(id);
                        existe = true;
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    break;
            }
        }while (id!=0);
        
    }
    
}
