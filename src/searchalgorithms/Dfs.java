/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchalgorithms;

/**
 *
 * @author amorales
 */
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Dfs implements SearchFramework{
    private Grafo grafo;
    private Nodo nodoInicial;
    private ArrayList<Nodo> nodosSalida;
    private Set<Nodo> nodosEvaluados;
    private ArrayList<Nodo> completePath;

    private Queue<Nodo> queue;  
    private ArrayList<Nodo> nodes=new ArrayList<Nodo>();
    
    public Dfs(int ancho, int alto, BufferedImage image) {
        this.grafo = new Grafo(ancho, alto);
        this.grafo.setColorsLogic(image);
        this.nodoInicial = grafo.getNodoInicial();
        this.nodosSalida = grafo.getNodosSalida();  
        this.nodosEvaluados = new HashSet();
        
    }

    public void calcular(){
        this.completePath = calcular(this.grafo.getNodoInicial(), new ArrayList(), new ArrayList());
    }
    
    private ArrayList<Nodo> calcular(Nodo actualNode, ArrayList<Nodo> path,  ArrayList<Nodo> shortestPath) {
        path.add(actualNode);
      
        if (goalTest(actualNode))
           return path;
        
        for (Action accion: actions(actualNode)) {
            Nodo nextNode = result(actualNode, accion);
            if (!nextNode.isObstaculo()) {
                if (!this.nodosEvaluados.contains(nextNode)) {
                    this.nodosEvaluados.add(nextNode);
                    
                    if (shortestPath.isEmpty() || path.size() < shortestPath.size()) {
                        ArrayList<Nodo> newPath = calcular(nextNode, path, shortestPath);
//                        System.out.println(newPath);
                        if (!newPath.isEmpty()) {
                            shortestPath = newPath;
                        }
                    }
                }
            }
        }
       
        return shortestPath;
    }

    @Override
    public ArrayList<Action> actions(Nodo node) {
        return this.grafo.getNodosAdyacentes(node);
    }

    @Override
    public double pathCost(ArrayList<Nodo> path) {
        float cost = 0;
        
        for(int i = 0; i < path.size(); i++){
            Action action = new Action(path.get(i), path.get(i + 1));
            cost += this.stepCost(path.get(i), action, path.get(i + 1));
        }
        
        return cost;
    }

    @Override
    public boolean goalTest(Nodo goal) {
        return this.grafo.getNodosSalida().contains(goal);
    }

    @Override
    public Nodo result(Nodo node, Action action) {
        if(node.equals(action.getFrom())) {
            return action.getTo();
        }
        
        return null;
    }

    @Override
    public double stepCost(Nodo from, Action a, Nodo to) {
        if(from.equals(a.getFrom()) && to.equals(a.getTo())){
            return 1;
        }
        
        return 0;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public Set<Nodo> getNodosEvaluados() {
        return nodosEvaluados;
    }

    public void setNodosEvaluados(Set<Nodo> nodosEvaluados) {
        this.nodosEvaluados = nodosEvaluados;
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
    
    
}