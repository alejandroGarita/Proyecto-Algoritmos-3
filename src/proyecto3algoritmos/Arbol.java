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
public class Arbol {
    
    private NodoArbol raiz;
    private boolean nodoRepetido;
    
    public Arbol(){
        this.raiz=null;
    }// constructor
    
    public void insertarNodo(char id, char idPadre){
        NodoArbol nuevo=new NodoArbol(id);
        if(raiz==null){
            raiz=nuevo;
        }else {
            
            NodoArbol temp=raiz;
            insertarHijo(temp, id, idPadre);
            
        }
    }// insertarNodo
    
    private void insertarHijo(NodoArbol nodo, char id, char idPadre){
        if(nodo!=null){
            if(nodo.getId()==idPadre){
                nodo.insertarHijo(id);
            }else{
                for(int i=0; i<nodo.getHijos().size(); i++){
                    insertarHijo(nodo.getHijos().get(i), id, idPadre);
                }
            }
        }
    }// insertarHijo
    
    public void imprimirArbol(){
        imprimir(raiz);
    }// imprimirArbol
    
    
    private void imprimir(NodoArbol nodo){
        if(nodo!=null){
            System.out.print(nodo.getId()+" [");
            for(int i=0; i<nodo.getHijos().size(); i++){
                imprimir(nodo.getHijos().get(i));
            }
            System.out.print(" ]");
        }
    }// imprimir
    
    public boolean repetido(char id){
        this.nodoRepetido=false;
        buscarNodo(raiz, id);
        return nodoRepetido;
    }// repetido
    
    public void buscarNodo(NodoArbol nodo,char id){
        if(nodo!=null){
            if(nodo.getId()==id){
                this.nodoRepetido=true;
            }else {
                for(int i=0; i<nodo.getHijos().size(); i++){
                    buscarNodo(nodo.getHijos().get(i), id);
                }
            }
        }
    }// buscarNodo

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
    
}// Arbol
