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
public interface SearchFramework {
    
    /*
        Metodo que indica si estamos o no en un nodo final
    */
    public boolean goalTest(Nodo test);
    
    /*
        Metodo stepCost, que indica cómo llegar desde nNodo hacia yNodo
        por medio de una accion
    */
    public double stepCost(Nodo from, Action a,  Nodo to);
    
    /*
        Método que indica el costo de un camino con un criterio de peso
    */
    public double pathCost(ArrayList<Nodo> path);
    
    /*
        Método que indica las acciones basadas en un nodo
    */
    public ArrayList<Action> actions(Nodo eval);
    
    /*
        Método que indica el nodo al que llegamos con base en una acción
    */
    public Nodo result(Nodo eval, Action a);
}