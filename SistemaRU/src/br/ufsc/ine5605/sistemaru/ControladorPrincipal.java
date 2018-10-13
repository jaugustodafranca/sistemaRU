/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

import java.util.ArrayList;

/**
 *
 * @author jfranca
 */
public class ControladorPrincipal {
    private TelaPrincipal telaPrincipal;
    private ConteudoTelaPrincipal conteudoTelaPrincipal;
    private ControladorRelatorioAdm controladorRelatorioAdm;
    private Restaurante restaurante;
    private ControladorUsuario controladorUsuario;
    private ControladorAdm controladorAdm;

    public ControladorPrincipal() {
        this.telaPrincipal = new TelaPrincipal(this);
        this.conteudoTelaPrincipal = new ConteudoTelaPrincipal();
        this.controladorRelatorioAdm = new ControladorRelatorioAdm ();
        this.restaurante = new Restaurante(this);
        this.controladorUsuario = new ControladorUsuario(this);
        this.controladorAdm = new ControladorAdm();
    }

    public TelaPrincipal getTelaPrincipal() {
        return telaPrincipal;
    }

    public ConteudoTelaPrincipal getConteudoTelaPrincipal() {
        return conteudoTelaPrincipal;
    }

    public ControladorRelatorioAdm getControladorRelatorioAdm() {
        return controladorRelatorioAdm;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public ControladorUsuario getControladorUsuarios() {
        return controladorUsuario;
    }

    public ControladorAdm getControladorAdm() {
        return controladorAdm;
    }
    
    public void validaLogin(int id){
        ArrayList<Pessoa> pessoas = this.getControladorAdm().getPessoas();
        Pessoa result  = null;
        for(Pessoa pessoa : pessoas){
            String classeCompleta = pessoa.getClass().toString();
            String classe = classeCompleta.substring(classeCompleta.lastIndexOf(".")+1);
            
            if(classe.equals("Visitante")){
                if(((Visitante)pessoa).getId() == id){
                    result = pessoa;
                    
                }
            }else{
                if(((UsuarioUFSC) pessoa).getMatricula() == id){
                    System.out.println(pessoa.getNome());
                    result = pessoa;
                }
            }
        }
        if(result !=null){
            controladorUsuario.setPessoa(result);
            controladorUsuario.getTelaUsuario().mostraConteudoTela();
        }
        
    }
    

}
