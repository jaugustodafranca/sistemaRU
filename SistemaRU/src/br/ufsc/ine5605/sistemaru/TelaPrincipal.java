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
    
    @Override
    public void mostraConteudoTela() {
        int opcao;
        do{
            System.out.println("######  SISTEMA DE CONTROLE DO RESTAURANTE UNIVERSITÁRIO  ######");
            System.out.println();
            System.out.println("DIGITE SEU NÚMERO DE MATRÍCULA");

            System.out.println();
            System.out.println("[0] VOLTAR PARA O MENU DE USUÁRIO");
            
            opcao = leInteiro();
            
         
        }while (opcao==0);
    }
    
}
