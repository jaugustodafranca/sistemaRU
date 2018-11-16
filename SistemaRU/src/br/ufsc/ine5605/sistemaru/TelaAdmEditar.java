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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author franca
 */
public class TelaAdmEditar extends TelaPadrao{
    private GerenciadorBotoes gerenciadorBotoes;
    private JButton buttonVoltar;
    
    public TelaAdmEditar(){
        this.gerenciadorBotoes = new GerenciadorBotoes();
    }
    @Override
    public void mostraConteudoTela() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //BOTAO VOLTAR 
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        buttonVoltar = new JButton("Voltar");
        buttonVoltar.addActionListener(gerenciadorBotoes);
        buttonVoltar.setPreferredSize(new Dimension(500, 50));
        container.add(buttonVoltar, gbc);
        
        setSize(new Dimension(600, 400));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    private class GerenciadorBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton botao = (JButton) ae.getSource();
            TelaPadrao telaEditar = ControladorAdm.getInstance().getTelaAdmEditar();
            System.out.println("clicou: "+botao.getText());
            if(botao.equals(buttonVoltar)){
                try{
                    ControladorAdm.getInstance().escondeTela(telaEditar);
                    ControladorAdm.getInstance().getTelaAdm().mostraConteudoTela();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    System.out.println(e);
                }
            
            }
        }
    }
    
}
