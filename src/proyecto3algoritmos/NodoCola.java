/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3algoritmos;

/**
 *
 * @author Alejandro
 */
public class NodoCola {
    
    private char id;
    private int peso;
    private NodoCola suiguienteNodo;
    
    public NodoCola(char id, int peso){
        this.id=id;
        this.peso=peso;
    }// constructor

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public NodoCola getSuiguienteNodo() {
        return suiguienteNodo;
    }

    public void setSuiguienteNodo(NodoCola suiguienteNodo) {
        this.suiguienteNodo = suiguienteNodo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
    
}// NodoCola
