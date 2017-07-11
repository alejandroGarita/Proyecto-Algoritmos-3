/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3algoritmos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author Alejandro
 */
public class Nodo {
    
    private char id;
    private Arista primerArista;
    private Nodo siguienteNodo;
    
    private int x;
    private int y;
    
    private int visitado;
    private int distanciaNodoAdyacente;
    private char nodoAdyacente;
    
    public Nodo(char id, int x, int y){
        this.id=id;
        this.x=x;
        this.y=y;
        this.visitado=0;
        this.distanciaNodoAdyacente=0;
        this.nodoAdyacente=id;
    }// constructor
    
    public void dibujarAristas(Graphics2D g2){
        Arista temp=this.primerArista;
        while(temp!=null){
            g2.setStroke(new BasicStroke(1));
            g2.setColor(Color.black);
            g2.drawLine(x, y, temp.getDestino().getX(), temp.getDestino().getY());
            dibujarPeso(x,y,temp.getDestino().getX(),temp.getDestino().getY(), temp.getPeso(),g2);
            temp=temp.getSiguienteArista();
        }
    }// dibujarAristas
    
    public void dibujarPeso(int x1, int y1, int x2, int y2,int peso, Graphics2D g2){
        g2.setColor(Color.MAGENTA);
        int x=0;
        if(x1>x2){
            x=x2+(x1-x2)/2;
        }else x=x1+(x2-x1)/2;
        int y=0; 
        if(y1>y2){
            y=y2+(y1-y2)/2;
        }else y=y1+(y2-y1)/2;
        g2.setFont(new Font("Monospace",Font.BOLD,20));
        g2.drawString(peso+"", x, y);
    }// dibujarPeso
    
    public void dibujarNodo(Graphics2D g2){
        g2.setColor(Color.CYAN);
        g2.fillOval(x-10, y-18, 25, 25);
        
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Monospace",Font.BOLD, 15));
        g2.drawString(id+"", x, y);
        
    }// dibujarNodo
    

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public Arista getPrimerArista() {
        return primerArista;
    }

    public void setPrimerArista(Arista primerArista) {
        this.primerArista = primerArista;
    }

    public Nodo getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVisitado() {
        return visitado;
    }

    public void setVisitado(int visitado) {
        this.visitado = visitado;
    }

    public int getDistanciaNodoAdyacente() {
        return distanciaNodoAdyacente;
    }

    public void setDistanciaNodoAdyacente(int distanciaNodoAdyacente) {
        this.distanciaNodoAdyacente = distanciaNodoAdyacente;
    }

    public char getNodoAdyacente() {
        return nodoAdyacente;
    }

    public void setNodoAdyacente(char nodoAdyacente) {
        this.nodoAdyacente = nodoAdyacente;
    }
    
    
}// Nodo
