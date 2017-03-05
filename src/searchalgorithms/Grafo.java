/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchalgorithms;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author amorales
 */
public class Grafo {
    
    private int ancho;
    private int alto;
    private ArrayList<ArrayList<Nodo>> grafo; 
    private Nodo nodoInicial;
    private ArrayList<Nodo> nodosSalida;

    public Grafo(int w, int h) {
        this.ancho = w;
        this.alto = h;
        nodosSalida = new ArrayList();
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
//                System.out.println("Posicion: " + x + " - " + y);
//                System.out.println(nodo);
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
    
    public Nodo getNodoInicial() {
        return nodoInicial;
    }

    public void setNodoInicial(Nodo nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    public ArrayList<Nodo> getNodosSalida() {
        return nodosSalida;
    }

    public void setNodosSalida(ArrayList<Nodo> nodosSalida) {
        this.nodosSalida = nodosSalida;
    }
    
    public void setColorsLogic(BufferedImage image) {
        ColorParser parser = new ColorParser();
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
//                System.out.println("Y: " + y + " x: " + x);
                try {

                    int type = parser.getPixelRGB(image.getRGB(x, y));

                    // Si el color es negro entonces es un obstaculo
                    if (type == 0) {
                        this.grafo.get(y).get(x).setIsObstaculo(true);
                    }

                    // Si el color es rojo entonces es el inicio
                    else if (type == 2) {
                        this.nodoInicial = this.grafo.get(y).get(x);
                    }

                    // Si el color es verde entonces es una posible salida
                    else if (type == 3) {
                        this.nodosSalida.add(this.grafo.get(y).get(x)); 
                    }
                } catch(NullPointerException e) {
                    System.out.println("Trono en: " + x + " " + y);
                }
                this.grafo.get(y).get(x);
            }
        }
    }    
    
    public ArrayList<Action> getNodosAdyacentes(Nodo eval) {
          //si es con diagonales se crea un número aleatorio con probabilidad 1/2
        int x = eval.getX();
        int y = eval.getY();
        
        // nodos adyacentes a nodo actual
        ArrayList<Action> adyacentes = new ArrayList();
        
        // Buscamos si tiene nodo adyacente hacia abajo
        // Si es y = 0, entonces no tiene
        if ((y != 0)) {
            Nodo temp = this.getNodo(x, y - 1);
            Action acction = new Action(eval, temp);
            adyacentes.add(acction);
        }
        
        // Buscamos si tiene nodo adyacente hacia arriba
        // Si es x = altura, entonces no tiene
        if ((y != (this.getAlto() - 1))) {
             Nodo temp = this.getNodo(x, y + 1);
            Action acction = new Action(eval, temp);
            adyacentes.add(acction);
        }
        
        // Buscamos si tiene nodo adyacente hacia la derecha
        // Si es x = ancho entonces no tiene
        if ((x != (this.getAncho() - 1))) { // -1 por el indice en lista
            Nodo temp = this.getNodo(x + 1,y);
            Action acction = new Action(eval, temp);
            adyacentes.add(acction);

        }
        
        // Buscamos si tiene nodo adyacente hacie la izquierda
        // Si es x = 0, entonces no tiene
        if ((x != 0)) {
            Nodo temp = this.getNodo(x - 1, y);
            Action acction = new Action(eval, temp);
            adyacentes.add(acction);

        }
        
        return adyacentes;
    }
}