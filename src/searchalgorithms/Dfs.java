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
import java.util.Stack;

/**
 *
 * @author Diego Jacobs
 */
public class Dfs implements SearchFramework{
    private Grafo Graph;
    private ArrayList<Nodo> FinalPath;
    private ArrayList<Nodo> Checked;
    
    public Dfs(int sizeX, int sizeY, BufferedImage image){
        this.Graph = new Grafo(sizeX, sizeY);
        this.Graph.setColorsLogic(image);
        this.Checked = new ArrayList<>();
    }

    public Grafo getGraph() {
        return Graph;
    }

    public void setGraph(Grafo Graph) {
        this.Graph = Graph;
    }

    public ArrayList<Nodo> getFinalPath() {
        return FinalPath;
    }

    public void setFinalPath(ArrayList<Nodo> FinalPath) {
        this.FinalPath = FinalPath;
    }

    public ArrayList<Nodo> getChecked() {
        return Checked;
    }

    public void Solve(){
        this.FinalPath = Solve(this.Graph.getNodoInicial(), new ArrayList(), new ArrayList());
    }
    
    private ArrayList<Nodo> Solve(Nodo actualNode, ArrayList<Nodo> path,  ArrayList<Nodo> shortestPath) {
        path.add(actualNode);
      
        if (goalTest(actualNode))
           return path;
        
        for (Action accion: actions(actualNode)) {
            Nodo nextNode = result(actualNode, accion);
            if (!nextNode.isObstaculo()) {
                if (!this.Checked.contains(nextNode)) {
                    this.Checked.add(nextNode);
                    
                    if (shortestPath.isEmpty() || path.size() < shortestPath.size()) {
                        ArrayList<Nodo> newPath = Solve(nextNode, path, shortestPath);
                        if (!newPath.isEmpty())
                            shortestPath = newPath;
                    }
                }
            }
        }
       
        return shortestPath;
    }

    @Override
    public ArrayList<Action> actions(Nodo node) {
        return this.Graph.getNodosAdyacentes(node);
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
        return this.Graph.getNodosSalida().contains(goal);
    }

    @Override
    public Nodo result(Nodo node, Action action) {
        if(node.equals(action.getFrom())){
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
}