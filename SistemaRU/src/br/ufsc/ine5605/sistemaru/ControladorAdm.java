/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author jfranca
 */
public class ControladorAdm {
    
    private static ControladorAdm controladorAdm;
    
    
    private MapeadorPessoa mapeadorPessoa;
    
    //private ArrayList<Pessoa> pessoas;
    
    
    private TelaAdm telaAdm;
    private TelaAdmCadastro telaAdmCadastro;
    private TelaAdmExcluir telaAdmExcluir;
    private TelaAdmEditar telaAdmEditar;
    private TelaAdmListar telaAdmListar;
    private ConteudoTelaAdm conteudoTelaAdm;

    public ControladorAdm() {
        //this.pessoas = new ArrayList();
        this.mapeadorPessoa = new MapeadorPessoa();
        this.telaAdm = new TelaAdm();
        this.telaAdmCadastro = new TelaAdmCadastro();
        this.telaAdmExcluir = new TelaAdmExcluir();
        this.telaAdmEditar = new TelaAdmEditar();
        this.telaAdmListar = new TelaAdmListar();
        this.conteudoTelaAdm = new ConteudoTelaAdm();
    }

    public ArrayList<Pessoa> getPessoas() {
        return mapeadorPessoa.getList();
    }
    public void cadastraUsuarioUFSC (ConteudoTelaAdm conteudoTelaAdm) throws MatriculainvalidaException{
        UsuarioUFSC usuario = desempacotaUsuarioUFSC(conteudoTelaAdm);
        if (!idJaExiste(conteudoTelaAdm.codigo)){
            //pessoas.add(usuario);
            mapeadorPessoa.put(usuario);
            telaAdm.operacaoRealizada();
        }else{
            throw new MatriculainvalidaException();
        }
    }
    public void cadastraEstudante (ConteudoTelaAdm conteudoTelaAdm) throws MatriculainvalidaException{
        Estudante estudante = desempacotaEstudante(conteudoTelaAdm);
        if (!idJaExiste(conteudoTelaAdm.codigo)){
            //pessoas.add(estudante);
            mapeadorPessoa.put(estudante);
            telaAdm.operacaoRealizada();
        }else{
            throw new MatriculainvalidaException();
        }
    }    
            
    public void cadastraVisitante(ConteudoTelaAdm conteudoTelaAdm) throws MatriculainvalidaException{
        Visitante visitante = desempacotaVisitante(conteudoTelaAdm);
        if (!idJaExiste(conteudoTelaAdm.codigo)){
            //pessoas.add(visitante);
            mapeadorPessoa.put(visitante);
            telaAdm.operacaoRealizada();
        }else{
            throw new MatriculainvalidaException();
        }
    }
    
   
    
    public void excluirUsiario(int id) throws MatriculainvalidaException, Exception{
        if (idJaExiste(id)){
            Pessoa logado = ControladorPrincipal.getInstance().getControladorUsuarios().getPessoa();
            if(logado instanceof UsuarioUFSC && ((UsuarioUFSC) logado).getMatricula() != id){
                for (Pessoa pessoa: mapeadorPessoa.getList()){
                    //String classeCompleta = pessoa.getClass().toString();
                    //String classe = classeCompleta.substring(classeCompleta.lastIndexOf(".")+1);
                    //if(classe.equals("Visitante")){
                    if(pessoa instanceof Visitante){
                        if(((Visitante)pessoa).getId() == id){
                            if (pessoa.getSaldo()> 0){
//                                telaAdm.mostraDevolucaoDinheiro(pessoa);
                                //pessoas.remove(pessoa);
                                mapeadorPessoa.remove(pessoa);
                                telaAdm.operacaoRealizada();
                                return;
                            }else{
                                //pessoas.remove(pessoa);
                                mapeadorPessoa.remove(pessoa);
                                telaAdm.operacaoRealizada();
                                return;
                            }
                        }
                    }else{
                        if(((UsuarioUFSC)pessoa).getMatricula() == id){
                             if (pessoa.getSaldo()> 0){
//                                telaAdm.mostraDevolucaoDinheiro(pessoa);
                                //pessoas.remove(pessoa);
                                mapeadorPessoa.remove(pessoa);
                                telaAdm.operacaoRealizada();
                                return;
                            }else{
                                //pessoas.remove(pessoa);
                                mapeadorPessoa.remove(pessoa);
                                telaAdm.operacaoRealizada();
                                return;
                            }
                        }
                    }         
                }
            }else{
                throw new Exception("Não é possivel excluir o usuário logado!");
            }
        }else{
            throw new MatriculainvalidaException();
        }    
    }
    
    public void listarUsuariosCadastrados(){
        if (getPessoas().size() > 0){
            
            int cont = 1;
            ArrayList<String> relatorioCadastro = new ArrayList();
            for (Pessoa pessoa : mapeadorPessoa.getList()){
                String classeCompleta = pessoa.getClass().toString();
                String classe = classeCompleta.substring(classeCompleta.lastIndexOf(".")+1);
                //if(classe.equals("Visitante")){
                if(pessoa instanceof Visitante){
                    String linha = ("# "+cont+" - NOME: "+ pessoa.getNome() + " - ID: "+ ((Visitante)pessoa).getId() + " - TIPO CADASTRO: "+ pessoa.getClass().getName().toUpperCase());
                    relatorioCadastro.add(linha);
                }else{
                    String linha = ("# "+cont+" - NOME: "+ pessoa.getNome() + " - MATRÍCULA: "+ ((UsuarioUFSC)pessoa).getMatricula()+ " - TIPO CADASTRO: "+ pessoa.getClass().getName().toUpperCase());
                    relatorioCadastro.add(linha);
                }
                cont++;
            }
//            telaAdm.mostraListaCadastro(relatorioCadastro);
        }else{
            System.out.println("-> NÃO HÁ USUÁRIOS CADASTRADO NO SISTEMA");
        }
    }
    
    public void editarUsuario(int id) throws MatriculainvalidaException{
        if (idJaExiste(id)){
            for (Pessoa pessoa: mapeadorPessoa.getList()){
                String classeCompleta = pessoa.getClass().toString();
                String classe = classeCompleta.substring(classeCompleta.lastIndexOf(".")+1);
                switch (classe) {
                    case "Visitante":
                        if(((Visitante)pessoa).getId() == id){
//                            telaAdm.mostraTelaEditarVisitante(pessoa);
                        }   break;
                    case "UsuarioUFSC":
                        if(((UsuarioUFSC) pessoa).getMatricula() == id){
//                            telaAdm.mostraTelaEditarUsuarioUFSC(pessoa);
                        }   break;
                    default:
                        if(((Estudante) pessoa).getMatricula() == id){
//                            telaAdm.mostraTelaEditarEstudante(pessoa);
                        }   break;         
                }
            }
        }else{
            throw new MatriculainvalidaException();
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
        }while (idRepetido);
        return new Visitante (id, conteudoTelaAdm.nome);
    }
    
    
    public int geraID (){
        int id = 0;
        while(idJaExiste(id) || id == 0){
            Random random = new Random();
            id = random.nextInt((999999 - 100000) + 1) + 100000;
        }
        return id;
    }

    public TelaAdm getTelaAdm() {
        return this.telaAdm;
    }
    
    public TelaAdmCadastro getTelaAdmCadastro() {
        return this.telaAdmCadastro;
    }
    
    public TelaAdmExcluir getTelaAdmExcluir() {
        return this.telaAdmExcluir;
    }
    public TelaAdmEditar getTelaAdmEditar() {
        return this.telaAdmEditar;
    }
    public TelaAdmListar getTelaAdmListar() {
        return this.telaAdmListar;
    }

    
    public boolean idJaExiste(int id){
        if( mapeadorPessoa.getList() != null){
            for (Pessoa pessoa: mapeadorPessoa.getList()){
                if(pessoa instanceof Visitante){
                    if(((Visitante)pessoa).getId() == id){
                        return true;
                    }
                }else{
                    if(((UsuarioUFSC) pessoa).getMatricula() == id){
                        return true;
                    }
                }
            }
        }
        return false;
    }    

    public ControladorPrincipal getControladorPrincipal() {
        return ControladorPrincipal.getInstance();
    }
    public void adicionarSaldo(ConteudoTelaAdm conteudoTela) throws MatriculainvalidaException{
        if (idJaExiste(conteudoTela.codigo)){
            for (Pessoa pessoa: mapeadorPessoa.getList()){
                if(pessoa instanceof Visitante){
                    if(((Visitante)pessoa).getId() == conteudoTela.codigo){
                        pessoa.adicionarSaldo(conteudoTela.saldo);
                        telaAdm.operacaoRealizada();
                        return;
                    }
                }else{
                    if(((UsuarioUFSC)pessoa).getMatricula() == conteudoTela.codigo){
                        pessoa.adicionarSaldo(conteudoTela.saldo);
                        telaAdm.operacaoRealizada();
                        return;
                    }
                }         
            }
        } else{
            throw new MatriculainvalidaException();
        }   
    } 
    
    public void gerarRelatorioRu(){
        ControladorPrincipal.getInstance().getControladorRelatorioAdm().getTelaRelatorioAdm().mostraConteudoTela();
    }
    
    public void passarProximoDia(){
        System.out.println("-> PROXIMO DIA");
        ControladorPrincipal.getInstance().getRestaurante().proximoDia();
        TelaPadrao.setData(ControladorPrincipal.getInstance().dateToString(ControladorPrincipal.getInstance().diaAtual()));
        telaAdm.operacaoRealizada();
    }
    
    public void passarProximoMes(){
        System.out.println("-> PROXIMO MÊS");
        ControladorPrincipal.getInstance().getRestaurante().proximoMes();
        telaAdm.operacaoRealizada();
    }
    
    public String diaAtual (){
        Date diaAtual = ControladorPrincipal.getInstance().diaAtual();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
        String hoje = formato.format(diaAtual);
        return hoje;
    }
    
    public static ControladorAdm getInstance(){
        return (controladorAdm == null)? controladorAdm = new ControladorAdm() : controladorAdm;

    }
    public void mostraTela(){
        telaAdm.setVisible(true);
        
    }
    public void escondeTela(){
        telaAdm.getContentPane().removeAll();
        telaAdm.setVisible(false);
    }        
}
