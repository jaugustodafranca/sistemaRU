/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

import com.sun.glass.ui.Cursor;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jfranca
 */
public class ControladorPrincipal {
    
    private static ControladorPrincipal controladorPrincipal;
    
    private TelaPrincipal telaPrincipal;
    private ControladorRelatorioAdm controladorRelatorioAdm;
    private Restaurante restaurante;
    private ControladorUsuario controladorUsuario;
    private ControladorAdm controladorAdm;

    private ControladorPrincipal() {
        this.restaurante = new Restaurante(this);
        
        telaPrincipal.setData(dateToString(diaAtual()));
        this.telaPrincipal = new TelaPrincipal(this);
        this.controladorRelatorioAdm = new ControladorRelatorioAdm (this);
        
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
    
    public void validaLogin(ConteudoTelaPrincipal conteudo) throws MatriculainvalidaException{
        
        int id = conteudo.id;
        ArrayList<Pessoa> pessoas = this.getControladorAdm().getPessoas();
        Pessoa result  = null;
        for(Pessoa pessoa : pessoas){
            
            if(pessoa instanceof Visitante){
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
                        controladorUsuario.getTelaUsuario().mostraConteudoTela();
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
    
    
    public Date diaAtual (){
        Date diaAtual = restaurante.getDiaAtual();
        return diaAtual;
    }
    
    public String dateToString(Date d){
        Format f = new SimpleDateFormat("dd/MM/yyyy");
        return f.format(d);
    
    }
    
    public void mostraTela(){
        telaPrincipal.setVisible(true);
    }
    public void escondeTela(){
        telaPrincipal.limpaLogin();
        telaPrincipal.setVisible(false);
    }
    
    public static ControladorPrincipal getInstance(){
        if(controladorPrincipal == null)
            controladorPrincipal = new ControladorPrincipal();
    
        return controladorPrincipal;
    }
}
