/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3algoritmos;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Alejandro
 */
public class Grafo {
    
    private Nodo nodoInicial;
    private char destino;
    private char origen;
    
    public Grafo(){
        this.nodoInicial=null;
        
        this.destino=' ';
        this.origen=' ';
    }// constructor
    
    public void agregarNodo(char id, int x, int y){
        Nodo nuevoNodo=new Nodo(id, x, y);
        nuevoNodo.setPrimerArista(null);
        nuevoNodo.setSiguienteNodo(null);
        
        Nodo temp=this.nodoInicial;
        nuevoNodo.setSiguienteNodo(temp);
        this.nodoInicial=nuevoNodo;
    }// agregarNodo
    
    public void agregarAristaNodo(char origen, char destino, int peso){
        Nodo nodoDestino=buscarNodo(destino);
        if(nodoDestino!=null){
            Arista nuevaArista=new Arista();
            nuevaArista.setDestino(nodoDestino);
            nuevaArista.setPeso(peso);
            nuevaArista.setSiguienteArista(null);

            Nodo temp=buscarNodo(origen);
            if(temp!=null){
                Arista aristaTemp=temp.getPrimerArista();
                nuevaArista.setSiguienteArista(aristaTemp);
                temp.setPrimerArista(nuevaArista);
            }
        }
    }// agregarAristaNodo
    
    public Nodo buscarNodo(char id){
        Nodo temp=this.nodoInicial;
        while(temp!=null){
            if(temp.getId()==id)
                return temp;
            temp=temp.getSiguienteNodo();
        }
        return null;
    }// buscarNodo
    
    public void dibujarRuta(Graphics2D g2){
        Nodo temp=buscarNodo(destino);
        if(temp!=null){
            if(temp.getNodoAdyacente()!=destino){
                System.out.println("Ruta: ");
                while(temp.getId()!=origen){
                    g2.setColor(Color.red);
                    Nodo tempDestino=buscarNodo(temp.getNodoAdyacente());
                    g2.drawLine(temp.getX(), temp.getY(), tempDestino.getX(), tempDestino.getY());
                    g2.setColor(Color.red);
                    g2.fillOval(temp.getX()-10, temp.getY()-18, 25, 25);
                    g2.setColor(Color.WHITE);
                    g2.drawString(temp.getId()+"", temp.getX(), temp.getY()); 
                    System.out.print(temp.getId()+"-->");
                    temp=buscarNodo(temp.getNodoAdyacente());
                }
                g2.setColor(Color.red);
                g2.fillOval(temp.getX()-10, temp.getY()-18, 25, 25);
                g2.setColor(Color.WHITE);
                g2.drawString(temp.getId()+"", temp.getX(), temp.getY()); 
                System.out.print(temp.getId()+"\n");
            }
        }
    }// dibujarRuta
    
    public void imprimirGrafo(){
        Nodo temp=this.nodoInicial;
        while(temp!=null){
            System.out.println(temp.getId());
            Arista aristaTemp=temp.getPrimerArista();
            System.out.print("\t");
            while(aristaTemp!=null){
                System.out.print(aristaTemp.getDestino().getId()+" --> ");
                aristaTemp=aristaTemp.getSiguienteArista();
            }
            System.out.println("NULL\n");
            temp=temp.getSiguienteNodo();
        }System.out.println("Size: "+size());
    }// imprimirGrafo
    
    public int size(){
        int cont=0;
        Nodo temp=this.nodoInicial;
        while(temp!=null){
            cont++;
            temp=temp.getSiguienteNodo();
        }
        return cont;
    }// size

    public Nodo getNodoInicial() {
        return nodoInicial;
    }

    public void setNodoInicial(Nodo nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    public char getDestino() {
        return destino;
    }

    public void setDestino(char destino) {
        this.destino = destino;
    }

    public char getOrigen() {
        return origen;
    }

    public void setOrigen(char origen) {
        this.origen = origen;
    }
    
    
}// Grafo
