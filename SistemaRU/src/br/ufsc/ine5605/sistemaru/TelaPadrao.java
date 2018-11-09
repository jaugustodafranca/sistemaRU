/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 12041789921
 */
public abstract class TelaPadrao extends JFrame{
    
    private Scanner teclado;
    private JLabel labelDiaHoje;
    private static String data;
    private JPanel panel;

    

    public TelaPadrao() {
        super("SISTEMA DE CONTROLE DO RESTAURANTE UNIVERSITÁRIO");
        this.teclado = new Scanner(System.in);
        labelDiaHoje = new JLabel(data);
        getContentPane().setLayout(new BorderLayout());
        
        panel = new JPanel(new GridBagLayout());
        
        getContentPane().add(labelDiaHoje, BorderLayout.SOUTH);
        getContentPane().add(panel, BorderLayout.CENTER);
        //setContentPane(panel);
        
    }
    
    public JPanel getPanel() {
        return panel;
    }
    
    
    
    public JLabel getLabelDiaHoje() {
        labelDiaHoje = new JLabel(data);
        return labelDiaHoje;
    }
    
    public int leInteiro() throws InputInvalidoException{
        String i = teclado.nextLine();
        try{
            int x = Integer.parseInt(i);
            return x;
        }catch(NumberFormatException e){
            throw new InputInvalidoException();
        }
    }
    
    public float leFloat() {
        String i = teclado.nextLine();
        try{
            float x = Float.valueOf(i);
            return x;
        }catch(NumberFormatException e){
            System.out.println("ENTRADA INVÁLIDA, DIGITE APENAS NÚMEROS");
        }
        return 0;
    }
    
    public String leString() {
        return teclado.nextLine();
    }
    public boolean leBoolean() {
        return teclado.nextBoolean();
    }
     
    public abstract void mostraConteudoTela();
    
    public void operacaoRealizada(){
        System.out.println("");
        System.out.println("-> OPERAÇÃO REALIZADA COM SUCESSO");
        System.out.println("");
    }
    
    public void clear(){
        for (int i=0; i<=40;i++){
            System.out.println("");
        }
    }
    
    public static void setData(String dataRecebida){
        data = dataRecebida;
    }
    
    public static String getData(){
        return data;
    }
}
