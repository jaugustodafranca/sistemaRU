/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemaru;

/**
 *
 * @author 12041789921
 */
public class UsuarioUFSC extends Pessoa{
    
    private int matricula;
    private boolean admin;

    public UsuarioUFSC(String nome,int matricula, boolean admin) {
        super(nome);
        this.matricula = matricula;
        this.admin = admin;
    }
     
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    
    
    
}
