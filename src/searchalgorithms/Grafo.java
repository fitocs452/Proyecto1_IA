/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchalgorithms;

import java.util.ArrayList;

/**
 *
 * @author amorales
 */
public class Grafo {
    
    private int ancho;
    private int alto;
    private int[] diagonalesNodos = null;
    private ArrayList<ArrayList<Nodo>> grafo; 

    public Grafo(int w, int h, int[] diagonalesNodos) {
        this.ancho = w;
        this.alto = h;
        this.diagonalesNodos = diagonalesNodos;
        crearGrafo();
    }

    public Nodo getNodo(int x, int y) {
        return grafo.get(y).get(x);
    }
    
    private void crearGrafo() 
    {
        Nodo nodo;
        grafo = new ArrayList<>();
        for (int y = 0; y < alto; y++) 
        {
            ArrayList temp= new ArrayList();
            grafo.add(temp);
            for (int x = 0; x < ancho; x++)
            {
                nodo = new Nodo(x, y, this);
                grafo.get(y).add(nodo);
            }
        }
        
        int contador = 0;
        for (int y = 0; y < alto; y++) 
        {
            for (int x = 0; x < ancho; x++)
            {
                this.getNodo(x, y).setDistribuicion(diagonalesNodos[contador]);
                contador++;
            }
        }
        
    }

    public void getGrafoGrafico(){
       
        for (int y = 0; y < alto; y++) 
        {
            for (int x = 0; x < ancho; x++)
            {
                //System.out.print(grafo.get(y).get(x));
                if (x==ancho-1){
                    System.out.println("");
                }
                
            }
        }
        
    }
    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public ArrayList<ArrayList<Nodo>> getGrafo() {
        return grafo;
    }

    public void setGrafo(ArrayList<ArrayList<Nodo>> grafo) {
        this.grafo = grafo;
    }

    public int[] getDiagonalesNodos() {
        return diagonalesNodos;
    }

    public void setDiagonalesNodos(int[] diagonalesNodos) {
        this.diagonalesNodos = diagonalesNodos;
    }
}