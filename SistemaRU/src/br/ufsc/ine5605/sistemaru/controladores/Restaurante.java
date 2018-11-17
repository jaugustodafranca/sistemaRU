/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru.controladores;

import br.ufsc.ine5605.sistemaru.enuns.TipoRefeicao;
import br.ufsc.ine5605.sistemaru.entidades.Pessoa;
import br.ufsc.ine5605.sistemaru.controladores.ControladorPrincipal;
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
    
    private static Restaurante restaurante;
    
    private Date diaAtual;
    private HashMap<Date, Integer> acessosRU;
    
            
            
    private Restaurante(){
        Date dataDate = new Date();
        SimpleDateFormat dateFormatMonthYear = new SimpleDateFormat("dd-MM-yyyy");        
        String dateString = dateFormatMonthYear.format(dataDate);
        try{
            this.diaAtual = dateFormatMonthYear.parse(dateString); 
        }catch(Exception e){System.out.println(e);}     
                
        acessosRU = new HashMap();
        
    }

    public Date getDiaAtual() {
        return diaAtual;
    }

    public void proximoDia() {
        
        // conta o numero de pessoas que comeu no dia e guarda no hash
        int count = 0;
        for (Pessoa pessoaCadastrada : ControladorPrincipal.getInstance().getControladorAdm().getPessoas()){
            ArrayList <TipoRefeicao> refeicoesHoje = pessoaCadastrada.getRegistrosRefeicoes().get(this.diaAtual);
            if (refeicoesHoje!=null){
                count+= refeicoesHoje.size();
            }
            
        }
        acessosRU.put(diaAtual,count);
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.diaAtual);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        this.diaAtual = cal.getTime();
        //this.diaAtual = new Date(this.diaAtual.getTime() + (1000*60*60*24));
        
    }
    
    public void proximoMes() {
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDiaAtual());
        int max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        for(int i=0;i<max;i++){
            proximoDia();
        }
        
        
    }

    public HashMap<Date, Integer> getAcessosRU() {
        return acessosRU;
    }   
    
    public static Restaurante getInstance(){
        return (restaurante == null)? restaurante = new Restaurante() : restaurante;

    }
    
}
