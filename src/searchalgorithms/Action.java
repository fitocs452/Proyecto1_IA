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
public class Action {
    private Nodo from;
    private Nodo to;
    
    public Action(Nodo from, Nodo to) {
        this.from = from;
        this.to = to;
    }

    public Nodo getFrom() {
        return from;
    }

    public void setFrom(Nodo from) {
        this.from = from;
    }

    public Nodo getTo() {
        return to;
    }

    public void setTo(Nodo to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Action{" + "from=" + from + ", to=" + to + '}';
    }
}
