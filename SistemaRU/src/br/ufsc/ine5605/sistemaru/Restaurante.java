/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class Restaurante {
    private Date diaAtual;
    private HashMap<Date, Integer> acessosRU;
    private ControladorPrincipal controladorPrincipal; 
    
            
            
    public Restaurante(ControladorPrincipal controladorPrincipal){
        Date dataDate = new Date();
        SimpleDateFormat dateFormatMonthYear = new SimpleDateFormat("dd-MM-yyyy");        
        String dateString = dateFormatMonthYear.format(dataDate);
        try{
            this.diaAtual = dateFormatMonthYear.parse(dateString); 
        }catch(Exception e){System.out.println(e);}     
                
        acessosRU = new HashMap();
        this.controladorPrincipal = controladorPrincipal;
    }

    public Date getDiaAtual() {
        return diaAtual;
    }

    public void proximoDia() {
        
        // conta o numero de pessoas que comeu no dia e guarda no hash
        int count = 0;
        for (Pessoa pessoaCadastrada : controladorPrincipal.getControladorAdm().getPessoas()){
            ArrayList <TipoRefeicao> refeicoesHoje = pessoaCadastrada.getRegistrosRefeicoes().get(this.diaAtual);
            if (refeicoesHoje!=null){
                count+= refeicoesHoje.size();
            }
            
        }
        acessosRU.put(diaAtual,count);
        this.diaAtual = new Date(this.diaAtual.getTime() + (1000*60*60*24));
        
    }
    
    public void proximoMes() {
        
        proximoDia();
        
        Date dia = getDiaAtual();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dia);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_YEAR, -1);
        this.diaAtual = cal.getTime();
        
    }

    public HashMap<Date, Integer> getAcessosRU() {
        return acessosRU;
    }   
    
}
