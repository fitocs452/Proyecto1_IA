/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchalgorithms;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author amorales
 */
public class Bfs implements SearchFramework{
    private Grafo grafo;
    private final Nodo nodoInicial;
    private final ArrayList<Nodo> nodosSalida;
    private Set<Nodo> nodosEvaluados;
    private ArrayList<Nodo> completePath;

    private Queue<Nodo> queue;  
    private ArrayList<Nodo> nodes=new ArrayList<Nodo>();
    
    public Bfs(int ancho, int alto, BufferedImage image) {
        this.grafo = new Grafo(ancho, alto);
        this.grafo.setColorsLogic(image);
        this.nodoInicial = grafo.getNodoInicial();
        this.nodosSalida = grafo.getNodosSalida();  
        this.nodosEvaluados = new HashSet();
        
    }
    
    public void calcular() {
        Queue<ArrayList<Nodo>> nodosFrontera = new LinkedList();
        // Agregamos el primer path a explotar
        nodosFrontera.add(this.nodeToArray(this.nodoInicial));

        while(!nodosFrontera.isEmpty()) {
            // Tomamos el primer path en cola
            ArrayList<Nodo> path = nodosFrontera.poll();
            // Tomamos el ultimo nodo no explotado del path
            Nodo toExplore = path.get(path.size() - 1);
            
            // Si ya evaluamos el nodo actual podemos continuar
            if (this.nodosEvaluados.contains(toExplore)) {
                continue;
            } else {
                // De lo contrario lo evaluamos pero lo agregamos como ya evaluado
                // para que si se vuelve a aparecer lo ignoremos
                this.nodosEvaluados.add(toExplore);
            }
            
            // Caso base: El nodo actual es el destino
            if (this.goalTest(toExplore)) {
                this.completePath = path;
                break;
            }
            
            // Evaluamos los nodos adyacentes del ultimo nodo del camino actual
            for (Action a: this.actions(toExplore)) {
                // Si el nodo es obstaculo lo ignoramos
                if (a.getTo().isObstaculo()) {
                    continue;
                }
                // Agregamos el nuevo camino que es el camino actual más el adyacente
                nodosFrontera.add(this.getNewPath(path, result(toExplore, a)));            
            }
        }
    }

    public ArrayList<Nodo> getCompletePath() {
        return completePath;
    }

    public void setCompletePath(ArrayList<Nodo> completePath) {
        this.completePath = completePath;
    }

    public Queue<Nodo> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Nodo> queue) {
        this.queue = queue;
    }

    public ArrayList<Nodo> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Nodo> nodes) {
        this.nodes = nodes;
    }

    public Set<Nodo> getNodosEvaluados() {
        return nodosEvaluados;
    }

    public void setNodosEvaluados(Set<Nodo> nodosEvaluados) {
        this.nodosEvaluados = nodosEvaluados;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }
    
    @Override
    public boolean goalTest(Nodo test) {
        return this.nodosSalida.contains(test);
    }

    @Override
    public double stepCost(Nodo from, Action a, Nodo to) {
        // El costo es constante
        if(from.equals(a.getFrom()) && to.equals(a.getTo())) {
          return 1;  
        }
        
        return -1;
    }

    @Override
    public double pathCost(ArrayList<Nodo> path) {
        double costo = 0;
        for(int i = 0; i < path.size() - 1; i++) {
            Action temp = new Action(path.get(i), path.get(i+1));
            costo += stepCost(path.get(i), temp, path.get(i+1));
        }
        return costo;
    }

    @Override
    public ArrayList<Action> actions(Nodo eval) {
        return this.grafo.getNodosAdyacentes(eval);
    }

    @Override
    public Nodo result(Nodo eval, Action a) {
        if (a.getFrom().equals(eval)) {
           return a.getTo();
        }
        return null;
    }
    
    public ArrayList<Nodo> nodeToArray(Nodo n) {
        ArrayList<Nodo> temp = new ArrayList();
        temp.add(n);
        return temp;
    }
    
    public ArrayList<Nodo> getNewPath(ArrayList<Nodo> p, Nodo n) {
        ArrayList<Nodo> temp = new ArrayList();
        temp.addAll(p);
        temp.add(n);
        
        return temp;
    }
}
