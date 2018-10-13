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
public class TelaAdm extends TelaPadrao{
     
    
    
    
    @Override
    public void mostraConteudoTela() {
        int opcao;
        do{
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
            
         
        }while (opcao==0);
    }
    
    public void mostraTelaCadastroUsuarioUFSC(){
       
        System.out.println("######  CADASTRO USUARIO UFSC  ######");
        System.out.print("NOME: ");
        String nome = leString();
        System.out.print("MATRICULA: ");
        int matricula = leInteiro();
        System.out.print("É ADMINISTRADOR (true ou false: ");
        boolean admin = leBoolean();
        ConteudoTelaAdm conteudoTela = new ConteudoTelaAdm(nome,matricula,admin);
        ControladorAdm.cadastraUsuarioUFSC(conteudoTela);
        
        
    }
    
    public void mostraTelaCadastroEstudante(){
        
    }
    
    public void mostraTelaCadastroVisitante(){
        
    }
    
    
    
}
