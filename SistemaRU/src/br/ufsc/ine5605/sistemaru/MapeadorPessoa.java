/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author 73717380125
 */
public class MapeadorPessoa {

    
    private HashMap<Integer,Pessoa> cachePessoas;
    private final String filename = "pessoas.dat";
    
    public MapeadorPessoa() {
        this.cachePessoas = new HashMap();
        load();
        
    }
    
    public Pessoa get(Integer id){
        return cachePessoas.get(id); 
    }
    
    public void put(Pessoa pessoa){
        cachePessoas.put(getIdentificadorPessoa(pessoa), pessoa);
        persist();
    }
    
    public void load(){
        try{
            FileInputStream fIS = new FileInputStream(filename);
            ObjectInputStream oIS = new ObjectInputStream(fIS);
        
            this.cachePessoas =  (HashMap<Integer, Pessoa>) oIS.readObject();
            
            fIS.close();
            oIS.close();
            
        }catch(FileNotFoundException e){
            System.out.println("Arquivo nao encontrado.");
            persist();
        }catch(IOException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    
    }
    
    public void persist(){
        
        try{
            
            FileOutputStream fOS = new FileOutputStream(filename);
            
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);
            
            oOS.writeObject(cachePessoas);
            
            
            fOS.flush();
            oOS.flush();
            fOS.close();
            oOS.close();
            
        
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    
    }
    
    public void remove(Pessoa pessoa){
        cachePessoas.remove(getIdentificadorPessoa(pessoa));
    
    }
    
    public ArrayList<Pessoa> getList(){
        
        return (cachePessoas != null) ? new ArrayList(cachePessoas.values()) : null;
    
    }
    
    public Integer getIdentificadorPessoa( Pessoa pessoa){
        if(pessoa instanceof UsuarioUFSC){
            return ((UsuarioUFSC) pessoa).getMatricula();
        }else if(pessoa instanceof Visitante){
            return ((Visitante) pessoa).getId();
        }
        return null;
    }
    
}
