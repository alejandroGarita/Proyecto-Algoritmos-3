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
public class Dijkstra {
    
    private Grafo grafo;
    private char origen;
    
    private Queue cola;
        
    public Dijkstra(Grafo grafo, char origen){
        this.grafo=grafo;
        this.origen=origen;
        this.grafo.setOrigen(origen);
        reiniciar();
        calcularRutas();
    }// constructor
    
    private void calcularRutas(){
        cola=new Queue();
        cola.enQueue(origen);
        
        while(!cola.isEmpty()){
            Nodo u=this.grafo.buscarNodo(cola.deQueue());
            if(u!=null){
                if(u.getVisitado()==0){
                    u.setVisitado(1);
                    Arista temp=u.getPrimerArista();
                    while(temp!=null){
                        Nodo v=this.grafo.buscarNodo(temp.getDestino().getId());
                        if(v.getVisitado()==0){
                            relajacion(u, v, temp.getPeso());
                        }
                        temp=temp.getSiguienteArista();
                    }
                }
            }
        }
        
    }// calcularRutas
    
    private void reiniciar(){
        Nodo temp=this.grafo.getNodoInicial();
        while(temp!=null){
            System.out.println("reiniciando nodo");
            temp.setVisitado(0);
            temp.setDistanciaNodoAdyacente(0);
            temp.setNodoAdyacente(temp.getId());
            temp=temp.getSiguienteNodo();
        }
    }// reiniciar
    
    private void relajacion(Nodo actual, Nodo adyacente, int peso){
        if(adyacente.getNodoAdyacente()==adyacente.getId()){
            adyacente.setDistanciaNodoAdyacente(actual.getDistanciaNodoAdyacente()+peso);
            adyacente.setNodoAdyacente(actual.getId());
        }else if((actual.getDistanciaNodoAdyacente()+peso)<adyacente.getDistanciaNodoAdyacente()){
                adyacente.setDistanciaNodoAdyacente(actual.getDistanciaNodoAdyacente()+peso);
                adyacente.setNodoAdyacente(actual.getId());
             }
        this.cola.enQueue(adyacente.getId());
    }// relajacion
    
    
    public void imprimirRuta(char destino){
        Nodo temp=this.grafo.buscarNodo(destino);
        if(temp.getNodoAdyacente()==destino)
           System.out.println("No hay ruta");
        else{
            while(temp.getId()!=origen){
                System.out.print(temp.getId()+"-->");
                temp=this.grafo.buscarNodo(temp.getNodoAdyacente());
                if(temp==null)
                    break;
            }
            System.out.print(origen);
            System.out.println("\n");
        }
    }
    
}// Dijkstra
