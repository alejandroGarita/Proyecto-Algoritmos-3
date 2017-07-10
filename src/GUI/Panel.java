/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import proyecto3algoritmos.Arista;
import proyecto3algoritmos.Grafo;
import proyecto3algoritmos.Nodo;

/**
 *
 * @author Alejandro
 */
public class Panel extends JPanel implements MouseListener{
    
    private Grafo grafo;
    
    public Panel(){
        this.addMouseListener(this);
        this.grafo=new Grafo();
    }// constructor
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        repaint();
        Graphics2D g2=(Graphics2D)g;
        draw(g2);
    }// paintComponent
    
    private void draw(Graphics2D g2){
        Nodo temp=this.grafo.getNodoInicial();
        g2.setFont(new Font("Monospace",Font.BOLD,15));
        while(temp!=null){
            temp.dibujarAristas(g2);
            temp=temp.getSiguienteNodo();
        }
        temp=this.grafo.getNodoInicial();
        while(temp!=null){
            temp.dibujarNodo(g2);
            temp=temp.getSiguienteNodo();
        }
        this.grafo.dibujarRuta(g2);
    }// draw

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }
    
    public void agregarNodo(char id, int x, int y){
        this.grafo.agregarNodo(id, x, y);
    }
    
    public void agregarAristaNodo(char origen, char destino, int peso){
        this.grafo.agregarAristaNodo(origen, destino, peso);
    }

    

    @Override
    public void mouseClicked(MouseEvent e) {
        char[] id=JOptionPane.showInputDialog(null,"Ingrese el ID").toCharArray();
        agregarNodo(id[0], e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}// Panel
