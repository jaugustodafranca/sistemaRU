/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

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
    
    public void relatorioRefeicao(){
        int countMes = 0;
        int countMesUltimo = 0;
        int countMesPenultimo = 0;
        
        HashMap<Date, ArrayList<TipoRefeicao>> refeicoes = pessoa.getRegistrosRefeicoes();
        
        Date hoje = controladorPrincipal.getRestaurante().getDiaAtual();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateFormatMonthYear = new SimpleDateFormat("MM-yyyy");
        String mesAnoAtual = dateFormatMonthYear.format(hoje);
      
        Date dia = null;
        Date mesAtual = null;
        Date mesUltimo = null;
        Date mesPenultimo = null;
        Date mesQVem = null;
        try{
            mesAtual = dateFormat.parse("01-"+mesAnoAtual);
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(mesAtual);
            cal.add(Calendar.MONTH, 1);
            mesQVem = cal.getTime();
            cal.add(Calendar.MONTH, -2);
            mesUltimo = cal.getTime();
            cal.add(Calendar.MONTH, -1);
            mesPenultimo = cal.getTime();
            dia = mesPenultimo;
            
        }catch(ParseException e){
            System.out.println(e);
        }
        
        while(dia.before(mesUltimo)){
            ArrayList mes = (ArrayList) refeicoes.get(dia);
            if(mes != null){
                countMesPenultimo += mes.size();
            }
            dia = new Date(dia.getTime() + (1000*60*60*24));
        }
        while(dia.before(mesAtual)){
            ArrayList mes = (ArrayList) refeicoes.get(dia);
            if(mes != null){
                countMesUltimo += mes.size();
            }
            dia = new Date(dia.getTime() + (1000*60*60*24));
        }        
        while(dia.before(mesQVem)){
            ArrayList mes = (ArrayList) refeicoes.get(dia);
            if(mes != null){
                countMes += mes.size();
            }
            dia = new Date(dia.getTime() + (1000*60*60*24));
        }
        
        telaUsuario.mostraRelatorioUsuario(countMes,countMesUltimo,countMesPenultimo);
    
    }
    
}