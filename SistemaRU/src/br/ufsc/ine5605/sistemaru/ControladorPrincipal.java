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
    private ControladorRelatorioAdm controladorRelatorioAdm;
    private Restaurante restaurante;
    private ControladorUsuario controladorUsuario;
    private ControladorAdm controladorAdm;

    public ControladorPrincipal() {
        this.telaPrincipal = new TelaPrincipal(this);
        this.controladorRelatorioAdm = new ControladorRelatorioAdm (this);
        this.restaurante = new Restaurante(this);
        this.controladorUsuario = new ControladorUsuario(this);
        this.controladorAdm = new ControladorAdm(this);
    }

    public TelaPrincipal getTelaPrincipal() {
        return telaPrincipal;
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
    
    public void validaLogin(int id) throws MatriculainvalidaException{
        ArrayList<Pessoa> pessoas = this.getControladorAdm().getPessoas();
        Pessoa result  = null;
        for(Pessoa pessoa : pessoas){
            String classeCompleta = pessoa.getClass().toString();
            String classe = classeCompleta.substring(classeCompleta.lastIndexOf(".")+1);
            
            if(classe.equals("Visitante")){
                if(((Visitante)pessoa).getId() == id){
                    result = pessoa;
                    controladorUsuario.setPessoa(result);
                    controladorUsuario.getTelaUsuario().mostraConteudoTela();
                }
            }else{
                if(((UsuarioUFSC) pessoa).getMatricula() == id){
                    result = pessoa;
                    controladorUsuario.setPessoa(result);
                    if(((UsuarioUFSC) pessoa).isAdmin()){
                        controladorUsuario.getTelaUsuario().mostraConteudoTelaAdm();
                    }else{
                        controladorUsuario.getTelaUsuario().mostraConteudoTela();
                    }
                }
            }
        }
        if(result == null){
            throw new MatriculainvalidaException();
        }
        
    }
    
}
