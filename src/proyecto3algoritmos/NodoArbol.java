/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3algoritmos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class NodoArbol {
    
    private char id;
    private int nivelX;
    private int y;
    private List<NodoArbol> hijos;
    
    public NodoArbol(char id){
        this.id=id;
        this.hijos=new ArrayList<>();
    }// constructor

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public List<NodoArbol> getHijos() {
        return hijos;
    }

    public void setHijos(List<NodoArbol> hijos) {
        this.hijos = hijos;
    }

    public void insertarHijo(char id){
        NodoArbol nuevo=new NodoArbol(id);
        this.hijos.add(nuevo);
    }// insertarHijo

    public int getNivel() {
        return nivelX;
    }

    public void setNivel(int nivel) {
        this.nivelX = nivel;
    }
    
    public void dibujarAristas(Graphics2D g2){
        g2.setColor(Color.black);
        for(int i=0; i<hijos.size(); i++){
            g2.drawLine(nivelX*15, y, hijos.get(i).getNivel()*15, hijos.get(i).getY());
            hijos.get(i).dibujarAristas(g2);
        }
    }// dibujarAristas
    
    public void dibujarNodo(Graphics2D g2, int y){
        g2.setColor(Color.CYAN);
        g2.fillOval(nivelX*15-10, y-18, 25, 25);
        this.y=y;
        
        g2.setColor(Color.black);
        g2.setFont(new Font("Monospace",Font.BOLD, 15));
        g2.drawString(id+"", nivelX*15, y);
    }// dibujarNodo

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
}// NodoArbol
