/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

import java.util.Date;

/**
 *
 * @author 12041789921
 */
public class ControladorUsuario {
    
    private ControladorPrincipal controladorPrincipal;
    private TelaUsuario telaUsuario;
    private Pessoa pessoa;

    public ControladorUsuario(ControladorPrincipal controladorPirncipal) {
        this.controladorPrincipal = controladorPirncipal;
        this.telaUsuario = new TelaUsuario(this);
    }
    
    public ControladorPrincipal getControladorPrincipal() {
        return controladorPrincipal;
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
    
    public float consultarSaldo(){
        return pessoa.getSaldo();
    }
    
    public void validaRefeicao(int i) throws SaldoInsuficienteException{
        TipoRefeicao tipo = null;
        switch(i){
            case 1: tipo = TipoRefeicao.JANTA;
                    break;
            default:tipo = TipoRefeicao.ALMOCO;
                    break;
        
        }
        
        String classeCompleta = pessoa.getClass().toString();
        String classe = classeCompleta.substring(classeCompleta.lastIndexOf(".")+1);
        float preco = 0;
        
        if(classe.equals("Visitante")){
            preco = 6.1f;
        }else if(classe.equals("UsuarioUFSC")){
            preco = 2.9f;
        }else{
            if(!((Estudante)pessoa).isIsencao()){
                preco = 1.5f;
            }
        }
        
        if(consultarSaldo() >= preco){
            pessoa.descontaSaldo(preco);
            Date hoje = controladorPrincipal.getRestaurante().getDiaAtual();
            pessoa.adicionaRefeicao(hoje, tipo);
            telaUsuario.mostraSucessoRefeicao();
        }else{
            throw new SaldoInsuficienteException();
        }
    }
    
}