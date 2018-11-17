package br.ufsc.ine5605.sistemaru.exceptions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class NaoSelecionadoException extends Exception{
    public NaoSelecionadoException(){
        super("Você não selecionou nenhum usuário!");
    }    
}
