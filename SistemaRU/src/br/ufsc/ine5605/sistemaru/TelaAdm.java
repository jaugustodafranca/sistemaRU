/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

import java.util.ArrayList;

/**
 *
 * @author jfranca
 */
public class TelaAdm extends TelaPadrao{
    private ControladorAdm controlador;
    
    public TelaAdm(ControladorAdm controlador){
        this.controlador = controlador;
    }
    
    
    @Override
    public void mostraConteudoTela() {
        int opcao;
        do{
            System.out.println("###################################");
            System.out.println("######  MENU ADMINISTRATIVO  ######");
            System.out.println();
            System.out.println("[1] CADASTRAR USUÁRIO-UFSC");
            System.out.println("[2] CADASTRAR ESTUDANTE");
            System.out.println("[3] CADASTRAR VISITANTE");
            System.out.println("[4] EXCLUIR PESSOA CADASTRADA");
            System.out.println("[5] EDITAR PESSOA CADASTRADA");
            System.out.println("[6] LISTAR TODOS OS CADASTROS");
            System.out.println("[7] GERAR RELATÓRIO DE ACESSO AO RU");
            System.out.println();
            System.out.println("[0] VOLTAR PARA O MENU DE USUÁRIO");
            
            opcao = leInteiro();
            
            switch(opcao){
                case 1: mostraTelaCadastroUsuarioUFSC();
                        break;
                case 2: mostraTelaCadastroEstudante();
                        break;
                case 3: mostraTelaCadastroVisitante();
                        break;
                case 4: mostraTelaExcluirUsuario();
                        break;
                case 6: controlador.listarUsuariosCadastrados();
                        break;
            } 
        }while (opcao==0);
        
    }
    
    public void mostraTelaCadastroUsuarioUFSC(){
        ConteudoTelaAdm conteudoTela = new ConteudoTelaAdm();
        System.out.println("");
        System.out.println("######  CADASTRO USUARIO UFSC  ######");
        System.out.print("NOME: ");
        conteudoTela.nome = leString();
        System.out.print("MATRICULA: ");
        conteudoTela.codigo = leInteiro();
        System.out.print("É ADMINISTRADOR (TRUE OU FALSE) ");
        conteudoTela.admin = leBoolean();
        
        controlador.cadastraUsuarioUFSC(conteudoTela);
        operacaoRealizada();
        mostraConteudoTela();
        
        
    }
    
    public void mostraTelaCadastroEstudante(){
        ConteudoTelaAdm conteudoTela = new ConteudoTelaAdm();
        System.out.println("");
        System.out.println("######  CADASTRO USUARIO ESTUDANTE  ######");
        System.out.print("NOME: ");
        conteudoTela.nome = leString();
        System.out.print("MATRICULA: ");
        conteudoTela.codigo = leInteiro();
        System.out.print("É ADMINISTRADOR? (TRUE OU FALSE): ");
        conteudoTela.admin = leBoolean();
        System.out.print("ESTUDANTE É INSENTO?(TRUE OU FALSE): ");
        conteudoTela.isencao = leBoolean();
        
        controlador.cadastraEstudante(conteudoTela);
        operacaoRealizada();
        mostraConteudoTela();
        
    }
    
    public void mostraTelaCadastroVisitante(){
        ConteudoTelaAdm conteudoTela = new ConteudoTelaAdm();
        System.out.println("");
        System.out.println("######  CADASTRO VISITANTE  ######");
        System.out.print("NOME: ");
        conteudoTela.nome = leString();
                
        controlador.cadastraVisitante(conteudoTela);
        operacaoRealizada();
        mostraConteudoTela();
        
        
    }
    
    public void mostraTelaExcluirUsuario(){
        ConteudoTelaAdm conteudoTela = new ConteudoTelaAdm();
        System.out.println("");
        System.out.println("######  EXCLUIR USUÁRIO  ######");
        System.out.print("MATRÍCULA OU ID: ");
        conteudoTela.codigo = leInteiro();
        controlador.excluirUsiario(conteudoTela.codigo);
        operacaoRealizada();
        mostraConteudoTela();
        
    }
    
    public void mostraTelaEditarUsuario(){
        
    }
    
    public void mostraListaCadastro(ArrayList<Pessoa> pessoas){
        System.out.println("###################################");
        System.out.println("  LISTA DE USUÁRIOS CADASTRADOS");
        System.out.println();
        int cont = 1;
        for (Pessoa pessoa : pessoas){
            System.out.println("# "+cont+" - NOME: "+ pessoa.getNome());
            cont++;
        }
        System.out.println("###################################");
    }
    public void mostraMatriculaExistente(){
        System.out.println("-> USUÁRIO JÁ CADASTRADO COM ESSA MATRÍCULA OU ID");
    }
}
