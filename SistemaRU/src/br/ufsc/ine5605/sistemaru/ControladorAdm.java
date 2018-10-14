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
    private ControladorPrincipal controladorPrincipal;
    private TelaAdm telaAdm;
    private ConteudoTelaAdm conteudoTelaAdm;

    public ControladorAdm(ControladorPrincipal controladorPrincipal) {
        this.pessoas = new ArrayList();
        this.telaAdm = new TelaAdm (this);
        this.conteudoTelaAdm = new ConteudoTelaAdm();
        this.controladorPrincipal = controladorPrincipal;
        
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }
    public void cadastraUsuarioUFSC(ConteudoTelaAdm conteudoTelaAdm){
        UsuarioUFSC usuario = desempacotaUsuarioUFSC(conteudoTelaAdm);
        if (!idJaExiste(conteudoTelaAdm.codigo)){
            pessoas.add(usuario);
            telaAdm.operacaoRealizada();
        }else{
            telaAdm.mostraMatriculaExistente();
        }
    }
    public void cadastraEstudante(ConteudoTelaAdm conteudoTelaAdm){
        Estudante estudante = desempacotaEstudante(conteudoTelaAdm);
        if (!idJaExiste(conteudoTelaAdm.codigo)){
            pessoas.add(estudante);
            telaAdm.operacaoRealizada();
        }else{
            telaAdm.mostraMatriculaExistente();
        }
    }    
            
    public void cadastraVisitante(ConteudoTelaAdm conteudoTelaAdm){
        Visitante visitante = desempacotaVisitante(conteudoTelaAdm);
        if (!idJaExiste(conteudoTelaAdm.codigo)){
            pessoas.add(visitante);
            telaAdm.operacaoRealizada();
        }else{
            telaAdm.mostraMatriculaExistente();
        }
    }
    
   
    
    public void excluirUsiario(int id){
        for (Pessoa pessoa: pessoas){
            String classeCompleta = pessoa.getClass().toString();
            String classe = classeCompleta.substring(classeCompleta.lastIndexOf(".")+1);
            if(classe.equals("Visitante")){
                if(((Visitante)pessoa).getId() == id){
                    pessoas.remove(pessoa);
                    telaAdm.operacaoRealizada();
                    
                }
            }else{
                if(((UsuarioUFSC) pessoa).getMatricula() == id){
                    pessoas.remove(pessoa);
                    telaAdm.operacaoRealizada();
                }
            }         
            
        }
    }
    
    public void listarUsuariosCadastrados(){
        if (getPessoas().size() > 0){
            
            int cont = 1;
            ArrayList<String> relatorioCadastro = new ArrayList();
            for (Pessoa pessoa : pessoas){
                String classeCompleta = pessoa.getClass().toString();
                String classe = classeCompleta.substring(classeCompleta.lastIndexOf(".")+1);
                if(classe.equals("Visitante")){
                    String linha = ("# "+cont+" - NOME: "+ pessoa.getNome() + " - ID: "+ ((Visitante)pessoa).getId() + " - TIPO CADASTRO: "+ classe.toUpperCase());
                    relatorioCadastro.add(linha);
                }else{
                    String linha = ("# "+cont+" - NOME: "+ pessoa.getNome() + " - MATRÍCULA: "+ ((UsuarioUFSC)pessoa).getMatricula()+ " - TIPO CADASTRO: "+ classe.toUpperCase());
                    relatorioCadastro.add(linha);
                }
                cont++;
            }
            telaAdm.mostraListaCadastro(relatorioCadastro);
        }else{
            System.out.println("-> NÃO HÁ USUÁRIOS CADASTRADO NO SISTEMA");
        }
    }
    
    public void editarUsuario(int id){
        for (Pessoa pessoa: pessoas){
            String classeCompleta = pessoa.getClass().toString();
            String classe = classeCompleta.substring(classeCompleta.lastIndexOf(".")+1);
            switch (classe) {
                case "Visitante":
                    if(((Visitante)pessoa).getId() == id){
                        telaAdm.mostraTelaEditarVisitante(pessoa);
                    }   break;
                case "UsuarioUFSC":
                    if(((UsuarioUFSC) pessoa).getMatricula() == id){
                        telaAdm.mostraTelaEditarUsuarioUFSC(pessoa);
                        
                    }   break;
                default:
                    if(((Estudante) pessoa).getMatricula() == id){
                        telaAdm.mostraTelaEditarEstudante(pessoa);
                    }   break;         
            }
            
        }
        
        
    }
    private Estudante desempacotaEstudante(ConteudoTelaAdm conteudoTelaAdm){
        return new Estudante (conteudoTelaAdm.nome,conteudoTelaAdm.codigo, conteudoTelaAdm.admin, conteudoTelaAdm.isencao);
    }
    
    private UsuarioUFSC desempacotaUsuarioUFSC(ConteudoTelaAdm conteudoTelaAdm){
        return new UsuarioUFSC (conteudoTelaAdm.nome,conteudoTelaAdm.codigo, conteudoTelaAdm.admin);
    }
    private Visitante desempacotaVisitante(ConteudoTelaAdm conteudoTelaAdm){
        int id =0;
        boolean idRepetido = false;
        do{ 
            id = geraID();
            if(idJaExiste(id)){
                idRepetido=true;
            }
        }while (idRepetido==true);
        return new Visitante (id, conteudoTelaAdm.nome);
    }
    private ConteudoTelaAdm empacota(Pessoa pessoa){
        return new ConteudoTelaAdm(pessoa.getNome());
    }
    
    public int geraID (){       
        Random random = new Random();
        return random.nextInt((999999 - 100000) + 1) + 100000;
    }

    public TelaAdm getTelaAdm() {
        return this.telaAdm;
    }

    
    public boolean idJaExiste(int id){
        for (Pessoa pessoa: pessoas){
            String classeCompleta = pessoa.getClass().toString();
            String classe = classeCompleta.substring(classeCompleta.lastIndexOf(".")+1);
            if(classe.equals("Visitante")){
                if(((Visitante)pessoa).getId() == id){
                    return true;
                }
            }else{
                if(((UsuarioUFSC) pessoa).getMatricula() == id){
                    return true;
                }
            }
        }
        return false;
    }    

    public ControladorPrincipal getControladorPrincipal() {
        return controladorPrincipal;
    }
     
}
