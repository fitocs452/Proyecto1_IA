/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bayesnetwork;

import java.util.ArrayList;

/**
 *
 * @author amorales
 */
public class BayesNode implements Comparable<BayesNode>{
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
    public int compareTo(BayesNode t) {
        if (this.nodeId == null) {
            return this.expression.equals(t.getExpression()) ? 1: -1;
        }
        
        return this.nodeId.equals(t.getNodeId()) ? 1: -1;
    }

    @Override
    public String toString() {
        return "BayesNode{" + "nodeId=" + nodeId + ", prevNodes=" + prevNodes + '}';
    }

    public String toDisplay() {
        return "BayesNode{" + "probability=" + probability + ", expression=" + expression + '}';
    }
}
