/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jfranca
 */
public class ControladorAdm {
    private ArrayList<Pessoa> pessoas;
    private ControladorPrincipal ControladorPrincipal;
    private TelaAdm telaAdm;
    private ConteudoTelaAdm conteudoTelaAdm;

    public ControladorAdm() {
        this.pessoas = new ArrayList();
        this.telaAdm = new TelaAdm (this);
        
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }
    public UsuarioUFSC cadastraUsuarioUFSC(ConteudoTelaAdm conteudoTelaAdm){
       UsuarioUFSC usuario = desempacotaUsuarioUFSC(conteudoTelaAdm);
       for (Pessoa pessoaIn: pessoas){
            if (pessoaIn.getMatricula() == usuario.getMatricula()){
                return null;
            }
        }
              pessoas.add(usuario);
       return usuario;
    }
    public Estudante cadastraEstudante(ConteudoTelaAdm conteudoTelaAdm){
        Estudante estudante = desempacotaEstudante(conteudoTelaAdm);
        for (Pessoa pessoaIn: pessoas){
            if (pessoaIn.getMatricula() == estudante.getMatricula()){
                return null;
            }
        }
        pessoas.add(estudante);
        return estudante;
    }
            
    public Visitante cadastraVisitante(ConteudoTelaAdm conteudoTelaAdm){
        Visitante visitante = desempacotaVisitante(conteudoTelaAdm);
        for (Pessoa pessoaIn: pessoas){
            if (pessoaIn.getId() == visitante.getId()){
                return null;
            }
        }
        pessoas.add(visitante);
        return visitante;
    }
    
   
    
    public void excluirUsiario(int id){
        for (Pessoa pessoaIn: pessoas){
                     
            if (pessoaIn.getMatricula() == id){
                pessoas.remove(pessoaIn);
            }
            if (pessoaIn.getId() == id){
                pessoas.remove(pessoaIn);
            }
        }
    }
    
    private Estudante desempacotaEstudante(ConteudoTelaAdm conteudoTelaAdm){
        return new Estudante (conteudoTelaAdm.nome,conteudoTelaAdm.matricula, conteudoTelaAdm.admin, conteudoTelaAdm.Isencao);
    }
    
    private UsuarioUFSC desempacotaUsuarioUFSC(ConteudoTelaAdm conteudoTelaAdm){
        return new UsuarioUFSC (conteudoTelaAdm.nome,conteudoTelaAdm.matricula, conteudoTelaAdm.admin);
    }
    private Visitante desempacotaVisitante(ConteudoTelaAdm conteudoTelaAdm){
        int id = geraID();
        boolean idRepetido = false;
        do{
            for (Pessoa pessoaIn: pessoas){

                if (pessoaIn.getMatricula() == id){
                    idRepetido=true;
                }
                if (pessoaIn.getId() == id){
                    idRepetido=true;
                }
            }
        }while (idRepetido==true);
        return new Visitante (id, conteudoTelaAdm.nome);
    }
    
     public int geraID (){       
        Random random = new Random();
        return random.nextInt((999999 - 100000) + 1) + 100000;
    }

    public ConteudoTelaAdm getConteudoTelaAdm() {
        return conteudoTelaAdm;
    }
     
     
}
