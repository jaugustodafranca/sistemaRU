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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Doniss
 */
public class TelaAdmEditar extends TelaPadrao{
    
    private GerenciadorBotoes gerenciadorBotoes;
    private JButton buttonVoltar;
    private JButton buttonEditar;
    private JLabel labelNome;
    private JTextField textFieldNome;
    private JFormattedTextField formattedTextFieldMatricula;
    private JLabel labelMatricula;
    private JLabel labelAdmin;
    private JComboBox comboBoxAdmin;
    private JLabel labelIsento;
    private JComboBox comboBoxIsento;
    
    public TelaAdmEditar(){
        this.gerenciadorBotoes = new GerenciadorBotoes();
    }

    public void mostraConteudoTela(Pessoa pessoa) {
        getContentPane().removeAll();
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        
        
        //Nome
        labelNome = new JLabel();
        labelNome.setText("Nome:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        
        container.add(labelNome, gbc);
        
        textFieldNome = new JTextField(pessoa.getNome());
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        container.add(textFieldNome, gbc);
        
        int matricula;
        //Matricula
        labelMatricula = new JLabel();
        if(pessoa instanceof UsuarioUFSC){
            labelMatricula.setText("Matricula:");
            matricula = ((UsuarioUFSC)pessoa).getMatricula();
        }else{
            labelMatricula.setText("Id:");
            matricula = ((Visitante)pessoa).getId();
        }

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
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

        formatter.setCommitsOnValidEdit(true);
        formattedTextFieldMatricula = new JFormattedTextField(formatter);
        formattedTextFieldMatricula.setText(matricula+"");
        formattedTextFieldMatricula.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        container.add(formattedTextFieldMatricula, gbc);
        
        //ADMIN
        if(pessoa instanceof UsuarioUFSC){
            labelAdmin = new JLabel();
            labelAdmin.setText("Admin:");
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;

            container.add(labelAdmin, gbc);

            String[] bool = {"Sim","Não"};
            comboBoxAdmin = new JComboBox(bool);
            gbc.gridx = 1;
            gbc.gridwidth = 2;
            container.add(comboBoxAdmin, gbc);
        }
        
        
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

    @Override
    public void mostraConteudoTela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    System.out.println(e);
                }
            
            }
        }
    }
    
}
