/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

/**
 *
 * @author 12041789921
 */
public class TelaUsuario extends TelaPadrao{
    private ControladorUsuario controladorUsuario;

    public TelaUsuario(ControladorUsuario controladorUsuario) {
        this.controladorUsuario = controladorUsuario;
    }

    public ControladorUsuario getControladorUsuario() {
        return controladorUsuario;
    }
    
    
    
    
    @Override
    public void mostraConteudoTela() {
        int opcao;
        do{
            System.out.println("######  MENU USUARIO  ######");
            System.out.println();
            System.out.println("[1] ENTRAR NO RESTAURANTE");
            System.out.println("[2] CONSULTAR SALDO");
            System.out.println("[3] GERAR RELATÓRIO");
            System.out.println("[0] DESLOGAR");
            
            opcao = leInteiro();
            
         
        }while (opcao==0);
        switch(opcao){
            case 1: break;
        }
    }
    
    public void mostraConteudoTelaAdm() {
        int opcao;
        do{
            System.out.println("######  MENU USUARIO  ######");
            System.out.println();
            System.out.println("[1] ENTRAR NO RESTAURANTE");
            System.out.println("[2] CONSULTAR SALDO");
            System.out.println("[3] GERAR RELATÓRIO");
            System.out.println("[4] ENTRAR TELA ADM");
            System.out.println("[0] DESLOGAR");
            
            opcao = leInteiro();
            
         
        }while (opcao==0);
        switch(opcao){
            case 1: break;
        }
    }
}
