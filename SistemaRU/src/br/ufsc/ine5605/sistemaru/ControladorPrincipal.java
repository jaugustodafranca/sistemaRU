/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

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
        this.telaPrincipal = new TelaPrincipal();
        this.conteudoTelaPrincipal = new ConteudoTelaPrincipal();
        this.controladorRelatorioAdm = new ControladorRelatorioAdm ();
        this.restaurante = new Restaurante(this);
        this.controladorUsuario = new ControladorUsuario();
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
    
    
    

    










}
