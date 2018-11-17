/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

import br.ufsc.ine5605.sistemaru.exceptions.MatriculainvalidaException;
import br.ufsc.ine5605.sistemaru.controladores.ControladorPrincipal;
import br.ufsc.ine5605.sistemaru.controladores.ControladorAdm;
import br.ufsc.ine5605.sistemaru.exceptions.MatriculaJahExisteException;
import br.ufsc.ine5605.sistemaru.telas.ConteudoTelaAdm;


/**
 *
 * @author 12041789921
 */
public class SistemaRU {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ControladorPrincipal a = ControladorPrincipal.getInstance();
        ControladorAdm b = a.getControladorAdm();
        ConteudoTelaAdm j = new ConteudoTelaAdm("admin",123456, true);
        ConteudoTelaAdm x = new ConteudoTelaAdm("ze", 111, false, true);
        ConteudoTelaAdm y = new ConteudoTelaAdm("doni",222, true,false);
        ConteudoTelaAdm z = new ConteudoTelaAdm("solange");
        ConteudoTelaAdm c = new ConteudoTelaAdm("Paulo",1341,false,false);
        ConteudoTelaAdm d = new ConteudoTelaAdm("Geronimo",12341,false,false);
        ConteudoTelaAdm r = new ConteudoTelaAdm("Geronimo",123241,false,false);
        ConteudoTelaAdm h = new ConteudoTelaAdm("Geronimo",12341,false,false);
        try{
            b.cadastraUsuarioUFSC(j);
            b.cadastraEstudante(x);
            b.cadastraEstudante(y);
            b.cadastraVisitante(z);
            b.cadastraEstudante(c);
            b.cadastraEstudante(d);
            b.cadastraEstudante(r);
            b.cadastraEstudante(h);
        }catch (MatriculaJahExisteException e){System.out.println(e);};
        
        a.getTelaPrincipal().mostraConteudoTela();
        
        
        /*TelaAdm c = b.getTelaAdm();
        c.mostraConteudoTela();*/
    }
    
}
