/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bayesnetwork;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author amorales
 */
public class BayesNode {
    private String nodeId;
    private ArrayList<BayesNode> prevNodes = new ArrayList();
    private double probability;
    private String expression;
    
    public BayesNode(String nodeId) {
        this.nodeId = nodeId;
    }
    
    public BayesNode(String exp, double prob) {
        this.expression = exp;
        this.probability = prob;
    }
    
    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public ArrayList<BayesNode> getPrevNodes() {
        return prevNodes;
    }

    public void AddPrevNode(BayesNode b) {
        this.prevNodes.add(b);
    }
    
    public void setPrevNodes(ArrayList<BayesNode> prevNodes) {
        this.prevNodes = prevNodes;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        BayesNode node = (BayesNode)o;
//        System.out.println("Compare: " + o);
        if (this.expression == null || node.getExpression() == null) {
            boolean x = this.nodeId.equals(node.getNodeId());
//            System.out.println("Compare: " + this.nodeId + " - " + node.getNodeId());
//            System.out.println("IsEqual?" + x);
            return x;
        }
        if (this.nodeId == null ) {
            boolean x = this.expression.equals(node.getExpression());
//            System.out.println("Compare: " + this.expression + " - " + node.getExpression());
//            System.out.println("IsEqualEXP? " + x);
            return x;
        }
        return this.nodeId.equals(node.getNodeId()); 
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nodeId);
        return hash;
    }

    @Override
    public String toString() {
        return "BayesNode{ " + nodeId + ", " + prevNodes + '}';
    }
    
    public String specialToString() {
        String prevNodes = "";
        for (BayesNode bn: this.prevNodes) {
            prevNodes += bn.getNodeId() + ", ";
        }
        
        return "Id: " + nodeId + " prevNodes: " + (prevNodes.isEmpty() ? "No tiene" : prevNodes);
    }

    public String toDisplay() {
        return '{' + expression + ", P= " + probability + '}';
    }
}
