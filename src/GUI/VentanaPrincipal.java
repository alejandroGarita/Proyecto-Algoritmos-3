/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import proyecto3algoritmos.Dijkstra;
import proyecto3algoritmos.Primm;

/**
 *
 * @author Alejandro
 */
public class VentanaPrincipal extends JFrame implements ActionListener{
    
    private JMenuBar jmb;
    
    private JMenu jMenuOpciones;
    private JMenuItem jMenuItemAgregarArista;
    
    private JMenu jMenuCalcularRuta;
    private JMenuItem jMenuItemCalcularRuta;
    
    private JMenu jMenuPrimm;
    private JMenuItem jMenuItemPrimm;
    
    public static Panel panel;
    
    public VentanaPrincipal(){
        super("Proyecto 3");
        this.setSize(550, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        jMenuOpciones=new JMenu("Opciones");
        jMenuItemAgregarArista=new JMenuItem("Agregar arista");
        jMenuItemAgregarArista.addActionListener(this);
        jMenuOpciones.add(jMenuItemAgregarArista);
        
        jMenuCalcularRuta=new JMenu("Dijkstra");
        jMenuItemCalcularRuta=new JMenuItem("Calcular ruta");
        jMenuItemCalcularRuta.addActionListener(this);
        jMenuCalcularRuta.add(jMenuItemCalcularRuta);
        
        jMenuPrimm=new JMenu("Primm");
        jMenuItemPrimm=new JMenuItem("Generar arbol");
        jMenuItemPrimm.addActionListener(this);
        jMenuPrimm.add(jMenuItemPrimm);
        
        jmb=new JMenuBar();
        this.setJMenuBar(jmb);
        jmb.add(jMenuOpciones);
        jmb.add(jMenuCalcularRuta);
        jmb.add(jMenuPrimm);
        
        this.panel=new Panel();
        this.add(panel);
    }// constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jMenuItemAgregarArista){
            if(panel.getGrafo().size()<2){
                JOptionPane.showMessageDialog(rootPane, "Ingrese al menos dos nodos");
            }else{
                AgregarArista agregarArista=new AgregarArista(this.panel.getGrafo());
                agregarArista.setVisible(true);
                this.panel.add(agregarArista);
            }
            
        }else if(e.getSource()==jMenuItemCalcularRuta){
                char[] origenArray=JOptionPane.showInputDialog(rootPane,"Ingrese el origen").toCharArray();
                if(panel.getGrafo().buscarNodo(origenArray[0])!=null){
                    char[] destinoArray=JOptionPane.showInputDialog(rootPane,"Ingrese el destino").toCharArray();
                    if(panel.getGrafo().buscarNodo(destinoArray[0])!=null){
                        Dijkstra dijkstra=new Dijkstra(panel.getGrafo(), origenArray[0]);
                        dijkstra.imprimirRuta(destinoArray[0]);
                        panel.getGrafo().setDestino(destinoArray[0]);
                        panel.getGrafo().setOrigen(origenArray[0]);
                    }else JOptionPane.showMessageDialog(rootPane, "El destino no existe");
                }else JOptionPane.showMessageDialog(rootPane, "El nodo de salida no existe");
        
        }else if(e.getSource()==jMenuItemPrimm){
                
                String raiz=JOptionPane.showInputDialog(rootPane, "Ingrese el ID de la raiz del arbol");
                if(raiz!=null){
                    char[] raizArray=raiz.toCharArray();
                    if(raizArray.length>0){
                        if(panel.getGrafo().buscarNodo(raizArray[0])!=null){
                            VentanaPrimm ventanaPrimm=new VentanaPrimm(panel.getGrafo(),raizArray[0]);
                            ventanaPrimm.setVisible(true);
                            panel.add(ventanaPrimm);
                        }else JOptionPane.showMessageDialog(rootPane, "El nodo no se encuentra en el grafo");
                    }else JOptionPane.showMessageDialog(rootPane, "Debe ingresar el ID de algun nodo");
                }
                
        }
        
    }

    
    
    
    
}// VentanaPrincipal
