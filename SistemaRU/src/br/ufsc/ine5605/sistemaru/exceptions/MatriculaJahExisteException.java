/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru.exceptions;

/**
 *
 * @author Dall Agnol
 */
public class MatriculaJahExisteException extends Exception{
    public MatriculaJahExisteException(){
        super("Matricula já exite, digite outro numúro de matricula");
    }
}
