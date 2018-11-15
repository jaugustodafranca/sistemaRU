/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jfranca
 */
public class TelaAdm extends TelaPadrao{
    
    private JButton buttonCadastrar;
    private JButton buttonExcluir;
    private JButton buttonEditar;
    private JButton buttonListar;
    private JButton buttonAdicionarSaldo;
    private JButton buttonRelatorioRu;
    private JButton buttonPassarDia;
    private JButton buttonPassarMes;
    private JButton buttonVoltar;
    private GerenciadorBotoes gerenciadorBotoes;

    public TelaAdm(){
        this.gerenciadorBotoes = new GerenciadorBotoes();
    }
    
    
    
    @Override
    public void mostraConteudoTela(){
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //BOTAO CADASTRAR
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonCadastrar = new JButton("Cadastrar");
        buttonCadastrar.addActionListener(gerenciadorBotoes);
        buttonCadastrar.setPreferredSize(new Dimension(125, 50));
        container.add(buttonCadastrar, gbc);
        
        //BOTAO EXCLUIR 
        gbc.gridx = 1;
        gbc.gridy = 0;
        buttonExcluir = new JButton("Excluir");
        buttonExcluir.addActionListener(gerenciadorBotoes);
        buttonExcluir.setPreferredSize(new Dimension(125, 50));
        container.add(buttonExcluir, gbc);
        
        //BOTAO EDITAR 
        gbc.gridx = 2;
        gbc.gridy = 0;
        buttonEditar = new JButton("Editar");
        buttonEditar.addActionListener(gerenciadorBotoes);
        buttonEditar.setPreferredSize(new Dimension(125, 50));
        container.add(buttonEditar, gbc);
        
        //BOTAO LISTAR 
        gbc.gridx = 3;
        gbc.gridy = 0;
        buttonListar = new JButton("Listar");
        buttonListar.addActionListener(gerenciadorBotoes);
        buttonListar.setPreferredSize(new Dimension(125, 50));
        container.add(buttonListar, gbc);
        
        //BOTAO ADICIONAR SALDO 
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        buttonAdicionarSaldo = new JButton("Adicionar Saldo");
        buttonAdicionarSaldo.addActionListener(gerenciadorBotoes);
        buttonAdicionarSaldo.setPreferredSize(new Dimension(250, 50));
        container.add(buttonAdicionarSaldo, gbc);
        
        //BOTAO RELATORIO RU 
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        buttonRelatorioRu = new JButton("Relatório RU");
        buttonRelatorioRu.addActionListener(gerenciadorBotoes);
        buttonRelatorioRu.setPreferredSize(new Dimension(250, 50));
        container.add(buttonRelatorioRu, gbc);
        
        //BOTAO PASSAR DIA 
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        buttonPassarDia = new JButton("Passar Dia");
        buttonPassarDia.addActionListener(gerenciadorBotoes);
        buttonPassarDia.setPreferredSize(new Dimension(250, 50));
        container.add(buttonPassarDia, gbc);
        
        //BOTAO PASSAR MÊS  
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        buttonPassarMes = new JButton("Passar Mês");
        buttonPassarMes.addActionListener(gerenciadorBotoes);
        buttonPassarMes.setPreferredSize(new Dimension(250, 50));
        container.add(buttonPassarMes, gbc);
        
        //BOTAO VOLTAR 
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        buttonVoltar = new JButton("Voltar");
        buttonVoltar.addActionListener(gerenciadorBotoes);
        buttonVoltar.setPreferredSize(new Dimension(500, 50));
        container.add(buttonVoltar, gbc);
        
        
        
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private class GerenciadorBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton botao = (JButton) ae.getSource();
            System.out.println("clicou: "+botao.getText());
            if(botao.equals(buttonCadastrar)){
                try{
                    ControladorAdm.getInstance().getTelaAdmCadastro().mostraConteudoTela();
                    escondeTela();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    System.out.println(e);
                }
            
            }else if(botao.equals(buttonExcluir)){
                try{
                    escondeTela();
                    ControladorAdm.getInstance().getTelaAdmExcluir().mostraConteudoTela();
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    System.out.println(e);
                }
            }else if(botao.equals(buttonEditar)){
                try{
                    escondeTela();
                    ControladorAdm.getInstance().getTelaAdmEditar().mostraConteudoTela();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    System.out.println(e);
                }
            }else if(botao.equals(buttonListar)){
                try{
                    escondeTela();
                    ControladorAdm.getInstance().getTelaAdmListar().mostraConteudoTela();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    System.out.println(e);
                }
            }else if(botao.equals(buttonVoltar)){
                try{
                    escondeTela();
                    ControladorUsuario.getInstance().getTelaUsuario().mostraConteudoTela();
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    System.out.println(e);
                }
            }    
            

        }
        public void escondeTela(){
            setVisible(false);
        }
    }
}       
    /*
    @Override
    public void mostraConteudoTela() {
        
        int opcao = -1;
        do{
            System.out.println("");
            System.out.println("###################################");
            System.out.println("######  MENU ADMINISTRATIVO  ######");
            System.out.println("###################################");
            System.out.println();
            System.out.println("DIA ATUAL: " + ControladorAdm.getInstance().diaAtual());
            System.out.println();
            System.out.println("[1] CADASTRAR USUÁRIO-UFSC");
            System.out.println("[2] CADASTRAR ESTUDANTE");
            System.out.println("[3] CADASTRAR VISITANTE");
            System.out.println("[4] EXCLUIR PESSOA CADASTRADA");
            System.out.println("[5] EDITAR PESSOA CADASTRADA");
            System.out.println("[6] LISTAR TODOS OS CADASTROS");
            System.out.println("[7] ADICIONAR SALDO");
            System.out.println("[8] GERAR RELATÓRIO DE ACESSO AO RU");
            System.out.println();
            System.out.println("[9] PASSAR PARA O PRÓXIMO DIA");
            System.out.println("[10] PASSAR PARA O PRÓXIMO MÊS");
            System.out.println("[0] VOLTAR PARA O MENU DE USUÁRIO");
            System.out.println("");
            
            try{
                opcao = leInteiro();
            }catch(InputInvalidoException e){
                System.out.println(e);
                continue;
            }
            
            
            switch(opcao){
                case 1: {
                try {
                    mostraTelaCadastroUsuarioUFSC();
                } catch (MatriculainvalidaException ex) {
                    System.out.println(ex);
                }
            }
                        break;
                case 2: {
                try {
                    mostraTelaCadastroEstudante();
                } catch (MatriculainvalidaException ex) {
                    System.out.println(ex);
                }
            }
                        break;
                case 3: {
                try {
                    mostraTelaCadastroVisitante();
                } catch (MatriculainvalidaException ex) {
                    System.out.println(ex);
                }
            }
                        break;
                case 4: {
                try {
                    mostraTelaExcluirUsuario();
                } catch (MatriculainvalidaException ex) {
                    System.out.println(ex);
                }
            }
                        break;
                case 5: {
                try {
                    mostraEditarPessoa();
                } catch (MatriculainvalidaException ex) {
                    System.out.println(ex);
                }
            }
                        break;
                case 6: ControladorAdm.getInstance().listarUsuariosCadastrados();
                        break;
                case 7: {
                    try {
                        mostraAdicionarSaldo();
                    } catch (MatriculainvalidaException ex) {
                        System.out.println(ex);
                    }
                }
                        break;
                        
                case 8: ControladorAdm.getInstance().gerarRelatorioRu();
                        break;
                        
                case 9: ControladorAdm.getInstance().passarProximoDia();
                        break;
                        
                case 10:ControladorAdm.getInstance().passarProximoMes();
                        break;
            } 
        }while (opcao!=0);
        
    }
    
    public void mostraTelaCadastroUsuarioUFSC() throws MatriculainvalidaException{
        clear();
        ConteudoTelaAdm conteudoTela = new ConteudoTelaAdm();
        System.out.println("");
        System.out.println("#####################################");
        System.out.println("######  CADASTRO USUARIO UFSC  ######");
        System.out.println("#####################################");
        System.out.println("");
        System.out.print("NOME: ");
        conteudoTela.nome = leString();
        System.out.print("MATRICULA: ");
        try{
            conteudoTela.codigo = leInteiro();
        }catch(InputInvalidoException e){
            System.out.println(e);
            return;
        }
        
        System.out.print("É ADMINISTRADOR (TRUE OU FALSE): ");
        conteudoTela.admin = leBoolean();
        
        ControladorAdm.getInstance().cadastraUsuarioUFSC(conteudoTela);
        
        
    }
    
    public void mostraTelaCadastroEstudante() throws MatriculainvalidaException{
        clear();
        ConteudoTelaAdm conteudoTela = new ConteudoTelaAdm();
        System.out.println("");
        System.out.println("##########################################");
        System.out.println("######  CADASTRO USUARIO ESTUDANTE  ######");
        System.out.println("##########################################");
        System.out.println("");
        System.out.print("NOME: ");
        conteudoTela.nome = leString();
        System.out.print("MATRICULA: ");
        
        try{
            conteudoTela.codigo = leInteiro();
        }catch(InputInvalidoException e){
            System.out.println(e);
            return;
        }
        System.out.print("É ADMINISTRADOR? (TRUE OU FALSE): ");
        conteudoTela.admin = leBoolean();
        System.out.print("ESTUDANTE É INSENTO?(TRUE OU FALSE): ");
        conteudoTela.isencao = leBoolean();
        
        ControladorAdm.getInstance().cadastraEstudante(conteudoTela);
        
    }
    
    public void mostraTelaCadastroVisitante() throws MatriculainvalidaException{
        clear();
        ConteudoTelaAdm conteudoTela = new ConteudoTelaAdm();
        System.out.println("");
        System.out.println("##################################");
        System.out.println("######  CADASTRO VISITANTE  ######");
        System.out.println("##################################");
        System.out.println("");
        System.out.print("NOME: ");
        conteudoTela.nome = leString();
                
        ControladorAdm.getInstance().cadastraVisitante(conteudoTela);
        
        
    }
    
    public void mostraTelaExcluirUsuario() throws MatriculainvalidaException{
        clear();
        ConteudoTelaAdm conteudoTela = new ConteudoTelaAdm();
        System.out.println("");
        System.out.println("###############################");
        System.out.println("######  EXCLUIR USUÁRIO  ######");
        System.out.println("###############################");
        System.out.println("");
        System.out.print("MATRÍCULA OU ID: ");
        
        try{
            conteudoTela.codigo = leInteiro();
        
            ControladorAdm.getInstance().excluirUsiario(conteudoTela.codigo);
        
        
        }catch(InputInvalidoException e){
            System.out.println(e);
            return;
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
    }
    
     
    public void mostraListaCadastro(ArrayList<String> relatorioCadastro){
        clear();
        System.out.println("###################################");
        System.out.println("#  LISTA DE USUÁRIOS CADASTRADOS  #");
        System.out.println("###################################");
        System.out.println();
        for (String linhaDoRelatorio: relatorioCadastro){
            System.out.println(linhaDoRelatorio);
        }
        System.out.println();
        System.out.println("###################################");
        System.out.println();
    }
    
    
    
    public void mostraEditarPessoa() throws MatriculainvalidaException{
        clear();
        ConteudoTelaAdm conteudoTela = new ConteudoTelaAdm();
        System.out.println("");
        System.out.println("##############################");
        System.out.println("#####   EDITAR USUARIO   #####");
        System.out.println("##############################");
        System.out.println("");
        System.out.println("DIGITE A MATRÍCULA OU ID: ");
        
        try{
            conteudoTela.codigo = leInteiro();
        }catch(InputInvalidoException e){
            System.out.println(e);
            return;
        }
        
        
        ControladorAdm.getInstance().editarUsuario(conteudoTela.codigo);
    }    
    
    public void mostraTelaEditarUsuarioUFSC(Pessoa pessoa) throws MatriculainvalidaException{
        clear();
        ConteudoTelaAdm conteudoTela = new ConteudoTelaAdm();
        System.out.println("");
        System.out.println("###################################");
        System.out.println("######  EDITAR USUARIO UFSC  ######");
        System.out.println("###################################");
        System.out.println("");
        System.out.println("NOME ATUAL: "+ ((UsuarioUFSC)pessoa).getNome());
        System.out.print("NOVO NOME: ");
        conteudoTela.nome = leString();
        System.out.println("MATRICULA ATUAL: "+ ((UsuarioUFSC)pessoa).getMatricula());
        System.out.print("MATRICULA: ");
        
        try{
            conteudoTela.codigo = leInteiro();
        }catch(InputInvalidoException e){
            System.out.println(e);
            return;
        }
        
        
        String adm = "ADMIN: "+ ((UsuarioUFSC)pessoa).isAdmin();
        System.out.println(adm.toUpperCase());
        System.out.print("É ADMINISTRADOR (TRUE OU FALSE): ");
        conteudoTela.admin = leBoolean();
        ControladorAdm.getInstance().getPessoas().remove(pessoa);
        ControladorAdm.getInstance().cadastraUsuarioUFSC(conteudoTela);
    }

    public void mostraTelaEditarVisitante(Pessoa pessoa) throws MatriculainvalidaException {
        clear();
        ConteudoTelaAdm conteudoTela = new ConteudoTelaAdm();
        System.out.println("");
        System.out.println("###############################");
        System.out.println("######  EDITAR VISTANTE  ######");
        System.out.println("###############################");
        System.out.println("");
        System.out.println("NOME ATUAL: "+ ((Visitante)pessoa).getNome());
        System.out.print("NOVO NOME: ");
        conteudoTela.nome = leString();
        System.out.println("ID ATUAL: "+ ((Visitante)pessoa).getId());
        System.out.print("ID: ");
        try{
            conteudoTela.codigo = leInteiro();
        }catch(InputInvalidoException e){
            System.out.println(e);
            return;
        }
        ControladorAdm.getInstance().getPessoas().remove(pessoa);
        ControladorAdm.getInstance().cadastraVisitante(conteudoTela);
        
    }

    public void mostraTelaEditarEstudante(Pessoa pessoa) throws MatriculainvalidaException {
        clear();
        ConteudoTelaAdm conteudoTela = new ConteudoTelaAdm();
        System.out.println("");
        System.out.println("################################");
        System.out.println("######  EDITAR ESTUDANTE  ######");
        System.out.println("################################");
        System.out.println("");
        System.out.println("NOME ATUAL: "+ ((Estudante)pessoa).getNome());
        System.out.print("NOVO NOME: ");
        conteudoTela.nome = leString();
        System.out.println("MATRICULA ATUAL: "+ ((Estudante)pessoa).getMatricula());
        System.out.print("MATRICULA: ");
        
        try{
            conteudoTela.codigo = leInteiro();
        }catch(InputInvalidoException e){
            System.out.println(e);
            return;
        }
        
        
        String adm = "ADMIN: "+ ((Estudante)pessoa).isAdmin();
        System.out.println(adm.toUpperCase());
        System.out.print("É ADMINISTRADOR (TRUE OU FALSE): ");
        conteudoTela.admin = leBoolean();
        System.out.print("ESTUDANTE É INSENTO?(TRUE OU FALSE): ");
        conteudoTela.isencao = leBoolean();
        ControladorAdm.getInstance().getPessoas().remove(pessoa);
        ControladorAdm.getInstance().cadastraEstudante(conteudoTela);
        
    }
    
    public void mostraDevolucaoDinheiro(Pessoa pessoa){
        System.out.println("-> REEMBOLSO DE R$: "+ pessoa.getSaldo());
    }
    
    public void mostraAdicionarSaldo() throws MatriculainvalidaException{
        clear();
        ConteudoTelaAdm conteudoTela = new ConteudoTelaAdm();
        System.out.println("###############################");
        System.out.println("######  ADICIONAR SALDO  ######");
        System.out.println("###############################");
        System.out.println("");
        System.out.println("DIGITE A MATRÍCULA OU ID: ");
        
        
        try{
            conteudoTela.codigo = leInteiro();
        }catch(InputInvalidoException e){
            System.out.println(e);
            return;
        }
        
        System.out.print("VALOR: R$ ");
        conteudoTela.saldo = leFloat();
        
        ControladorAdm.getInstance().adicionarSaldo(conteudoTela);
    }


}*/