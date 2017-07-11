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
public class Queue {
    
    private NodoCola inicioPtr;
    private NodoCola finPtr;
    
    public Queue(){
        this.inicioPtr=null;
        this.finPtr=null;
    }// constructor
    
    public void enQueue(char id, int peso){
        NodoCola nuevoNodo=new NodoCola(id, peso);
        nuevoNodo.setSuiguienteNodo(null);
        
        if(this.inicioPtr==null){
            this.inicioPtr=nuevoNodo;
            this.finPtr=nuevoNodo;
        }else {
            NodoCola temp;
            if(peso<=inicioPtr.getPeso()){
                nuevoNodo.setSuiguienteNodo(inicioPtr);
                inicioPtr=nuevoNodo;
            }else if(peso>=finPtr.getPeso()){
                    finPtr.setSuiguienteNodo(nuevoNodo);
                    finPtr=nuevoNodo;
            }else {
                temp=inicioPtr;
                while(peso>temp.getSuiguienteNodo().getPeso()){
                    temp=temp.getSuiguienteNodo();
                }
                nuevoNodo.setSuiguienteNodo(temp.getSuiguienteNodo());
                temp.setSuiguienteNodo(nuevoNodo);
            }
        
        }
    }// enQueue
    
    public char deQueue(){
        char valor=' ';
        
        if(!isEmpty()){
            valor=this.inicioPtr.getId();
            this.inicioPtr=this.inicioPtr.getSuiguienteNodo();
        
            if(this.inicioPtr==null){
                this.finPtr=null;
            }
        }
        return valor;
    }// deQueue

    public boolean isEmpty(){
        if(this.inicioPtr==null)
            return true;
        else return false;
    }// isEmpty
    
    public void printQueue(){
        NodoCola current=this.inicioPtr;
        if(current==null){
            System.out.println("The queue is empty.\n\n");
        }else {
            System.out.println("Queue values: \n        ");
            while (current != null) {
                System.out.print(current.getId()+"-->");
                current=current.getSuiguienteNodo();
            }
            System.out.print("NULL\n\n");
        }
    }// printQueue
    
}// Cola
