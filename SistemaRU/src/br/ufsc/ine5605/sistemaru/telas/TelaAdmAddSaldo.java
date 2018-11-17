/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru.telas;

import br.ufsc.ine5605.sistemaru.controladores.ControladorAdm;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Usuario
 */
public class TelaAdmAddSaldo extends TelaPadrao{
    private GerenciadorBotoes gerenciadorBotoes;
    private JButton buttonVoltar;
    private JLabel labelTitulo;
    private JLabel labelMatricula;
    
    
     public TelaAdmAddSaldo(){
        this.gerenciadorBotoes = new GerenciadorBotoes();
    }
    
    
    
    @Override
    public void mostraConteudoTela() {
        getContentPane().removeAll();
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //TITULO
        labelTitulo = new JLabel();
        labelTitulo.setText("Adicionar Saldo:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        container.add(labelTitulo, gbc);
        
        //MATRICULA
        labelMatricula = new JLabel();
        labelMatricula.setText("Matrícula: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        container.add(labelMatricula, gbc);
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format) {
            public Object stringToValue(String string)
                throws ParseException {
                if (string == null || string.length() == 0) {
                    return null;
                }
                return super.stringToValue(string);
            }
        };
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        
        // If you want the value to be committed on each keystroke instead of focus lost
        formatter.setCommitsOnValidEdit(true);
        textField = new JFormattedTextField(formatter);
        textFieldLogin.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
    
        gbc.gridx = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        container.add(textFieldLogin, gbc);
        
        

        //BOTAO VOLTAR 
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        buttonVoltar = new JButton("Voltar");
        buttonVoltar.addActionListener(gerenciadorBotoes);
        buttonVoltar.setPreferredSize(new Dimension(100, 50));
        container.add(buttonVoltar, gbc);
        
        
        setSize(new Dimension(600, 400));
        mostraTela();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    private class GerenciadorBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton botao = (JButton) ae.getSource();
            TelaPadrao telaExcluir = ControladorAdm.getInstance().getTelaAdmExcluir();
            System.out.println("clicou: "+botao.getText());
            
            if(botao.equals(buttonVoltar)){
                try{
                    getContentPane().removeAll();
                    escondeTela();
                    ControladorAdm.getInstance().chamaTelaAdmListar();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    System.out.println(e);
                }
            }else if (botao.equals(buttonExcluir)){
                try{
                    getContentPane().removeAll();
                    ControladorAdm.getInstance().excluirUsiario(ControladorAdm.getInstance().getMatricula(pessoa));
                    JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
                    ControladorAdm.getInstance().chamaTelaAdmListar();
                    escondeTela();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    System.out.println(e);
                }
            }
        }
        
    }
    
}
    
}
