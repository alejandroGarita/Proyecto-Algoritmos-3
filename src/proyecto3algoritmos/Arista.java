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
public class Arista {
    
    private Nodo destino;
    private int peso;
    
    private Arista siguienteArista;
    
    public Arista(){
        destino=null;
        peso=0;
        siguienteArista=null;
    }// onstructor
    
    public Arista(Nodo destino, int peso){
        this.destino=destino;
        this.peso=peso;
    }// constructor

    public Nodo getDestino() {
        return destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Arista getSiguienteArista() {
        return siguienteArista;
    }

    public void setSiguienteArista(Arista siguienteArista) {
        this.siguienteArista = siguienteArista;
    }
    
}// arista
