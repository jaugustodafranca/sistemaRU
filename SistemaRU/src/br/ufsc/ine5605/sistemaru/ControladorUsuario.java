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
public class ControladorUsuario {
    
    private ControladorPrincipal controladorPirncipal;
    private TelaUsuario telaUsuario;
    private Pessoa pessoa;

    public ControladorUsuario(ControladorPrincipal controladorPirncipal) {
        this.controladorPirncipal = controladorPirncipal;
        this.telaUsuario = new TelaUsuario(this);
    }
    
    public ControladorPrincipal getControladorPirncipal() {
        return controladorPirncipal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public TelaUsuario getTelaUsuario() {
        return telaUsuario;
    }
    
}