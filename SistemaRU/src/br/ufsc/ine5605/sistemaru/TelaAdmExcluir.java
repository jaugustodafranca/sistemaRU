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
 * @author franca
 */
public class TelaAdmExcluir extends TelaPadrao {
    
    private JLabel labelTitulo;
    private JLabel labelmatricula;
    private JFormattedTextField textFieldMatricula;
    private JButton buttonExcluir;
    private JButton buttonVoltar;
    private GerenciadorBotoes gerenciadorBotoes;
    
    public TelaAdmExcluir(){

    }
    
    @Override
    public void mostraConteudoTela() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
       
        
        labelTitulo = new JLabel();
        labelTitulo.setText("Entre com a matrícula que deseja excluir:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        container.add(labelTitulo, gbc);
        
        labelmatricula = new JLabel();
        labelmatricula.setText("Matricula: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        container.add(labelmatricula, gbc);
        
        // O QUE FAZ ISSO ?
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
        formatter.setCommitsOnValidEdit(true);
        textFieldMatricula = new JFormattedTextField(formatter);
        textFieldMatricula.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        // ATÉ AQUI
        gbc.gridx = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        container.add(textFieldMatricula, gbc);
        
        buttonExcluir = new JButton();
        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // excluir a matricula se existir e devolve o saldo!
            }
        });
        buttonExcluir.setPreferredSize(new Dimension(80, 40));
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        container.add(buttonExcluir, gbc);
        
        
        
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
            if(botao.equals(buttonVoltar)){
                try{
                    ControladorAdm.getInstance().getTelaAdm().mostraConteudoTela();
                    escondeTela();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    System.out.println(e);
                }
            
            }
        }
        
    }
    
}
