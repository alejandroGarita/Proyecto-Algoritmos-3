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
public class Primm {
    
    private Arbol arbol;
    private char[] conjuntoN;
    private char[] conjuntoB;
    
    public Primm(Grafo grafo, char raiz){
        this.arbol=new Arbol();
        this.conjuntoB=new char[0];
        generarArbol(grafo,raiz);
        
    }// constructor
    
    private void generarArbol(Grafo grafo, char raiz){
        Nodo nodo=grafo.buscarNodo(raiz);
        llenarN(grafo);
        verN();
        verB();
        if(nodo!=null){
            arbol.insertarNodo(nodo.getId(), ' ');
            agregarElementoB(nodo.getId());
            eliminarElementoN(nodo.getId());
            verN();
            verB();
            eliminarNodosSinAristas(grafo);
            while(isNVacio()==false){
                Arista menor=buscarAristaMenor(grafo);
                if(menor!=null){
                    agregarElementoB(menor.getDestino().getId());
                    eliminarElementoN(menor.getDestino().getId());
                    arbol.insertarNodo(menor.getDestino().getId(), menor.getOrigen());
                    verN();
                    verB();
                }else break;
            }
        }
        System.out.println("\nN esta vacio");
        System.out.println("\nArbol de recubrimiento minimo: \n");
        arbol.imprimirArbol();
    }// generarArbol
    
    public void llenarN(Grafo grafo){
        conjuntoN=new char[grafo.size()];
        Nodo temp=grafo.getNodoInicial();
        int i=0;
        while(temp!=null){
            conjuntoN[i]=temp.getId();
            i++;
            temp=temp.getSiguienteNodo();
        }
    }// llenarN
    
    public void eliminarElementoN(char id){
        for(int i=0; i<conjuntoN.length; i++){
            if(conjuntoN[i]==id)
                conjuntoN[i]='.';
        }
    }// eliminarElementoN
    
    public boolean isNVacio(){
        for(int i=0; i<conjuntoN.length; i++){
            if(conjuntoN[i]!='.'){
                return false;
            }
        }
        return true;
    }// isNVacio
    
    public void agregarElementoB(char id){
        char[] conjuntoBTemp=new char[conjuntoB.length+1];
        for(int i=0; i<conjuntoB.length; i++){
            conjuntoBTemp[i]=conjuntoB[i];
        }
        conjuntoBTemp[conjuntoBTemp.length-1]=id;
        conjuntoB=conjuntoBTemp;
    }// agregarElementoB
    
    public void verN(){
        System.out.println("\n\nConjunto N");
        for(int i=0; i<conjuntoN.length; i++){
            System.out.print(conjuntoN[i]+" ");
        }
    }// verN
    
    public void verB(){
        System.out.println("\n\nConjunto B");
        for(int i=0; i<conjuntoB.length; i++){
            System.out.print(conjuntoB[i]+" ");
        }
    }// verB
    
    public boolean buscarElementoB(char id){
        for(int i=0; i<conjuntoB.length; i++){
            if(conjuntoB[i]==id)
                return true;
        }
        return false;
    }// buscarElementoB
    
    public void eliminarNodosSinAristas(Grafo grafo){
        Nodo temp=grafo.getNodoInicial();
        while(temp!=null){
            if(temp.getPrimerArista()==null)
                eliminarElementoN(temp.getId());
            temp=temp.getSiguienteNodo();
        }
    }// eliminarNodosSinAristas
    
    public Arista buscarAristaMenor(Grafo grafo){
        Arista aristaMenor=null;
        for(int i=0; i<conjuntoB.length; i++){
            Nodo temp=grafo.buscarNodo(conjuntoB[i]);
            Arista aristaTemp=temp.getPrimerArista();
            while(aristaTemp!=null){
                if(aristaMenor==null){
                    if(buscarElementoB(aristaTemp.getDestino().getId())!=true){
                        aristaMenor=aristaTemp;
                        aristaMenor.setOrigen(temp.getId());
                    }
                }else {
                    if(aristaTemp.getPeso()<aristaMenor.getPeso()){
                        if(buscarElementoB(aristaTemp.getDestino().getId())!=true){
                            aristaMenor=aristaTemp;
                            aristaMenor.setOrigen(temp.getId());
                        }
                    }
                }
                aristaTemp=aristaTemp.getSiguienteArista();
            }
        }
        return aristaMenor;
    }// aristaMenor

    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }
    
    
}// Primm
