/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru.exceptions;

/**
 *
 * @author 12041789921
 */
public class InputInvalidoException extends Exception {
    public InputInvalidoException(){
        super("INPUT INVÁLIDO, DIGITE APENAS NÚMEROS!");
    }
    
}
