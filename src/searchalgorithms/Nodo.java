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

public class Nodo implements Comparable<Nodo> {
    private boolean Obstaculo;
    private Nodo raiz;
    private Grafo grafo;
    private int x;
    private int y;
    private double funcionHeursitica;//costo del camino nodo actual al final -> Greedy
    private double distanciaDesdeInicio; //funcion G:costo del mejor camino encontrado->Dijsktra
 
    public Nodo(int x, int y, Grafo grafo) {
        this.x = x;
        this.y = y;
        this.Obstaculo = false;
        this.distanciaDesdeInicio=Integer.MAX_VALUE; //al principio los nodos tienen costo infinito
        this.grafo = grafo;
    }
    //método para comparar igualdad entre nodos
    public boolean equals(Nodo nodo) {
        return (this.x == nodo.x) && (this.y == nodo.y);
    }
    
    public boolean isObstaculo() {
        return Obstaculo;
    }

    public void setIsObstaculo(boolean Obstaculo) {
        this.Obstaculo = Obstaculo;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getFuncionHeursitica() {
        return funcionHeursitica;
    }

    public void setFuncionHeursitica(double funcionHeursitica) {
        this.funcionHeursitica = funcionHeursitica;
    }

    public double getFuncionG() {
        return distanciaDesdeInicio;
    }

    public void setFuncionG(double funcionG) {
        this.distanciaDesdeInicio = funcionG;
    }

    @Override//método que sirve para ordenar la cola prioritaria según esta comparación
    public int compareTo(Nodo other) {
        double totalDistanceFromGoal = this.distanciaDesdeInicio + this.funcionHeursitica;
        double otherDistanceFromGoal = other.distanciaDesdeInicio + other.funcionHeursitica;
        if (totalDistanceFromGoal < otherDistanceFromGoal)
                return -1;
        if (otherDistanceFromGoal < totalDistanceFromGoal)
                return 1;
        return 0;
    }
    @Override
    public String toString()
    {
        return "("+this.x +" ," + this.y +")";
    }
}
