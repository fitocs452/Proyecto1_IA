/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchalgorithms;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author amorales
 */
public class AStar implements SearchFramework{

    private final Grafo grafo;
    private final Nodo inicio;
    
    private final ArrayList<Nodo> path = new ArrayList<>();
    private Set<Nodo> nodosEvaluados;
    private final ArrayList<Nodo> nodosSalida;
    
    public AStar(int ancho, int alto, BufferedImage image) {
        this.grafo = new Grafo(ancho, alto);
        this.grafo.setColorsLogic(image);
        this.inicio = grafo.getNodoInicial();
        this.nodosSalida = grafo.getNodosSalida();  
    }

    public void calcular(boolean diagonales, boolean dijkstra, boolean greedy, boolean h1) 
    {
        nodosEvaluados= new HashSet<>(); //set de nodos evaluados
        PriorityQueue<Nodo> nodosPorEvaluar = new PriorityQueue<>();//set de nodos por evaluar, contiene inicialmente al nodo inicial

        inicio.setFuncionG(0); //costo desde el inicio hasta el mejor camino conocido
        
        // Le decimos que comience a buscar con el nodoInicial
        nodosPorEvaluar.add(inicio);
        int contadorIteraciones = 0;
        
        // Recorremos todos los nodos hasta llegar a uno de los destinos
        while (!nodosPorEvaluar.isEmpty()) {
            
            // Nos devuelve el nodo Head y lo elimina
            Nodo actual = nodosPorEvaluar.poll();

            // Caso base: Nodo actual es el destino
            if (this.goalTest(actual)) {  
                System.out.println("Iteraciones totales-> " + contadorIteraciones);
                System.out.println("Costo Total-> " + actual.getFuncionG()+actual.getFuncionHeursitica());
                reconstruirCamino(actual);
                break;
            }
            System.out.println("nodos por evaluar (frontera)"+ contadorIteraciones);
            System.out.println(nodosPorEvaluar);
            System.out.println("nodos evaluados");
            System.out.println(nodosEvaluados);
            
            nodosEvaluados.add(actual);

            
//            for (Nodo adyacente : actual.getNodosAdyacente(diagonales)) {
              for (Action action: this.actions(actual)) {
                /************************************
                int contN = 0;
                int diagonalN = arregloDiagonales.indexOf(contN);
                adyacente.setDistribuicion(diagonalN);
                contN++;
                ***********************************/
          
                boolean adyacenteIsMejor;
                Nodo adyacente = this.result(actual, action);
                // Si ya evaluamos el nodo actual, nos pasamos a evaluar el siguiente
                if (nodosEvaluados.contains(adyacente))
                    continue; //se salta una iteracion
                
                
                if (!adyacente.isObstaculo()) {
//                    double nuevoCosto = actual.getFuncionG() + getDistanciaEntre(actual, adyacente);
                    
                    // Obtenemos el costo real de pasar de nuestro nodo actual a nuestro nodo
                    // adyacente
                    double nuevoCosto = this.stepCost(actual, action, adyacente);
                    
                    // Agregamos al nodo adyacente a evaluar
                    if (!nodosPorEvaluar.contains(adyacente)) {
                        //Collections.sort(nodosPorEvaluar);
                        //equivale a cambiar la prioridad a una cola
                        nodosPorEvaluar.add(adyacente);
                        adyacenteIsMejor = true;
                    } else if (nuevoCosto < adyacente.getFuncionG()) {
                        adyacenteIsMejor = true;
                    } else {
                        adyacenteIsMejor = false;
                    }
                    if (adyacenteIsMejor){
                        adyacente.setRaiz(actual); //añadir el camino
                        //System.out.println("n: " + nuevoCosto);
                        adyacente.setFuncionG(nuevoCosto);
                        adyacente.setFuncionHeursitica(calcularHeuristica(adyacente, nodosSalida, diagonales, h1));
                    }
                    
                    if (dijkstra) {
                        adyacente.setFuncionHeursitica(0);
                    }
                    if (greedy) {
                        adyacente.setFuncionG(0);
                    }
                }
            }//cierra for adyacente
            contadorIteraciones++;
        }//cierra while
    }//cierra calcular

    //método para mostrar el camino más corto encontrado
    public void reconstruirCamino(Nodo nodo)
    {
//        grafo.getGrafoGrafico();
        while (!(nodo.getRaiz() == null)) {
            path.add(nodo);
            nodo = nodo.getRaiz();
        }
        path.add(nodo);
        Collections.reverse(path); //cambiar el orden
        System.out.println("");
        System.out.println(path.toString() + " ->Camino más corto");
        
    }
    //distancia entre nodos
    public double getDistanciaEntre(Nodo n1, Nodo n2) {
        if ((n1.getX() == n2.getX() ) || (n1.getY() == n2.getY()))
            return 1; //si estan a a la par el costo es constante
        else
            return Math.sqrt(2); //en otro caso estan en diagonal, costo = hipotenusa
    }
    
    //referencia: http://theory.stanford.edu/~amitp/GameProgramming/Heuristics.html#diagonal-distance
    public double calcularHeuristica(Nodo current, ArrayList<Nodo> goals, boolean diagonales, boolean h1) {
        
        double D = 1.0; //peso de aristas adyacentes
        double D2 = Math.sqrt(2); //peso de arista diagonales
        double tempLength = this.grafo.getAlto()*this.grafo.getAncho();
        Nodo goal = null;
        for (int i = 0; i < goals.size(); i++) {
            double dxTemp = Math.abs(current.getX() - goals.get(i).getX());
            double dyTemp = Math.abs(current.getY() - goals.get(i).getY());
            double calcLength = Math.sqrt(Math.pow(dxTemp, 2) + Math.pow(dyTemp, 2));
            if (calcLength < tempLength) {
                tempLength = calcLength;
                goal = goals.get(i);
            }
            
        }
        
        //manhattan de 4
        double dx = Math.abs(current.getX() - goal.getX());
        double dy = Math.abs(current.getY() - goal.getY());
        //cross breaking ties
        double dx1 = current.getX()-goal.getX();
        double dy1 = current.getY()-goal.getY();
        double p = 1/1000;//minimum cost of taking one step/expected maximum path length
        double dw = inicio.getX()-goal.getX(); //cross heuristics
        double dz = inicio.getY()-goal.getY(); //cross heuristics
    
        //se realiza un promedio de distancia manhattan de 8 movimientos y 4 movimientos
        double promedio = ((D*(dx+dy)+(D2-2*D)*Math.min(dx,dy))+(D*(dx+dy)))/2;
        if (diagonales)
            return promedio;//normal heuristics for diagonals
        if (h1) //sum of absolute differences. Manhattan distance
            return D*(dx + dy);
        return (D*(dx+dy))+Math.abs(dx1*dz-dw*dy1); //normal heuristic + cross breaking ties
       
    }

    public Set<Nodo> getNodosEvaluados() {
        return nodosEvaluados;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public ArrayList<Nodo> getPath() {
        return path;
    }

    @Override
    public boolean goalTest(Nodo test) {
//        if (nodosSalida.contains(test)) {
//            return true;
//        }
        return nodosSalida.contains(test);
    }

    @Override
    public double stepCost(Nodo from, Action a, Nodo to) {
        if (from.equals(a.getFrom()) && to.equals(a.getTo())) {
            return from.getFuncionG() + this.getDistanciaEntre(from, to);
        }
        
        return -1;
    }

    @Override
    public double pathCost(ArrayList<Nodo> path) {
        Nodo nodo = path.get(path.size() - 1);
        return nodo.getFuncionG() + nodo.getFuncionHeursitica();
    }

    @Override
    public ArrayList<Action> actions(Nodo eval) {
        return this.grafo.getNodosAdyacentes(eval);
    }

    @Override
    public Nodo result(Nodo eval, Action a) {
        // Si el nodo from de la accion es el que estamos evaluando
        // devolvemos el TO
        if (a.getFrom().equals(eval)) {
            return a.getTo();
        }
        
        // Si no cumple devolvemos null
        return null;
    }
}
