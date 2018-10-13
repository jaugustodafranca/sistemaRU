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
public class SistemaRU {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControladorPrincipal a = new ControladorPrincipal ();
        ControladorAdm b = a.getControladorAdm();
        ConteudoTelaAdm j = new ConteudoTelaAdm("admin", 123456, true);
        b.cadastraUsuarioUFSC(j);
        a.getTelaPrincipal().mostraConteudoTela();
        
        
        /*TelaAdm c = b.getTelaAdm();
        c.mostraConteudoTela();*/
    }
    
}
