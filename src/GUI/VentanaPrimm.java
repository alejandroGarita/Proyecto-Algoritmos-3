/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JInternalFrame;
import proyecto3algoritmos.Arbol;
import proyecto3algoritmos.Grafo;
import proyecto3algoritmos.NodoArbol;
import proyecto3algoritmos.Primm;

/**
 *
 * @author Alejandro
 */
public class VentanaPrimm extends JInternalFrame {
    
    private Arbol arbol;
    private int y;
    
    public VentanaPrimm(Grafo grafo, char raiz){
        super("Arbol de recubrimiento minimo");
        this.setSize(new Dimension(350, 350));
        this.setClosable(true);
        this.setResizable(true);
        this.setMaximizable(true);
        
        Primm primm=new Primm(grafo, raiz);
        arbol=primm.getArbol();
        agregarNivelNodosArbol(arbol.getRaiz(),2);
    }// constructor
    
    public void agregarNivelNodosArbol(NodoArbol nodo, int nivelX){
        nodo.setNivel(nivelX);
        for(int i=0; i<nodo.getHijos().size(); i++){
            agregarNivelNodosArbol(nodo.getHijos().get(i), nivelX+3);
        }
    }// agregarNivelNodosArbol
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        repaint();
        Graphics2D g2=(Graphics2D)g;
        g2.setStroke(new BasicStroke(1));
        dibujarAristas(g2, arbol.getRaiz());
        this.y=60;
        dibujarArbol(g2,arbol.getRaiz());
    }// paintComponent
    
    private void dibujarAristas(Graphics2D g2, NodoArbol nodo){
        nodo.dibujarAristas(g2);
    }// dibujarAristas
    
    private void dibujarArbol(Graphics2D g2,NodoArbol nodo){
        nodo.dibujarNodo(g2, y);
        for(int i=0; i<nodo.getHijos().size(); i++){
            dibujarArbol(g2, nodo.getHijos().get(i));
            this.y+=25;
        }
    }// dibujarArbol
    
}// VentanaPrimm
