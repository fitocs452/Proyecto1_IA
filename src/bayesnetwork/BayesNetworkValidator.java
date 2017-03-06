/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bayesnetwork;

import antlr4.grammarBayesBaseVisitor;
import antlr4.grammarBayesParser;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author amorales
 */
public class BayesNetworkValidator extends grammarBayesBaseVisitor{
    private HashSet<String> variables = new HashSet();
    private ArrayList<BayesNode> network = new ArrayList();
    private boolean isCondition = false;
    
    // Nodo actual
    private String currentNodeId;
    private BayesNode currentNode;

    @Override
    public Object visitOperator(grammarBayesParser.OperatorContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            String child = ctx.getChild(i).getText();
            if (child.equals(",") || child.equals("!")) {
                continue;
            }
            
            currentNode = new BayesNode(child);
            currentNodeId = child;
            if (!this.network.contains(currentNode)) {
                this.network.add(currentNode);
            }
        }
        
        return super.visitOperator(ctx);
    }

    @Override
    public Object visitProgram(grammarBayesParser.ProgramContext ctx) {
        return super.visitProgram(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitProbability(grammarBayesParser.ProbabilityContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++){
            this.visit(ctx.getChild(i));
            if (i == ctx.getChildCount() -1 ) {
                if (!this.network.contains(currentNode))
                    this.network.add(currentNode);
            }
        }
        isCondition = false;
        return null;
//        return super.visitProbability(ctx);
    }

    @Override
    public Object visitOperator2(grammarBayesParser.Operator2Context ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++){
            String child = ctx.getChild(i).getText();
            if (child.equals(",") && child.equals("!")) {
                continue;
            }
            
            if (isCondition) {
                BayesNode search = this.findNodeInNetworkById(child);
                currentNode.AddPrevNode(search);
            } else {
                currentNodeId = child;
            }
            
        }
        return super.visitOperator2(ctx);
    }
    
    public BayesNode findNodeInNetworkById(String nodeId) {
        for (BayesNode bn: this.network) {
            if (bn.getNodeId().equals(nodeId)) {
                return bn;
            }
        }
        return null;
    }

    @Override
    public Object visitCondition(grammarBayesParser.ConditionContext ctx) {
        this.isCondition = true;
        return super.visitCondition(ctx);
    }

    public HashSet<String> getVariables() {
        return variables;
    }

    public void setVariables(HashSet<String> variables) {
        this.variables = variables;
    }

    public ArrayList<BayesNode> getNetwork() {
        return network;
    }

    public void setNetwork(ArrayList<BayesNode> network) {
        this.network = network;
    }

    public BayesNode getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(BayesNode currentNode) {
        this.currentNode = currentNode;
    }
    
    // Esto tiene que hacer match con 2^n nodos
    public int validNetwork() {
        int totalNetwork = 0;
        for (BayesNode n : this.network) {
            int contPrev = n.getPrevNodes().size();
            contPrev = (int) Math.pow(2, contPrev);
            totalNetwork += contPrev;
        }
        
        return totalNetwork;
    }
    
    public boolean validateUnique(String n) {
        boolean valid = true;
        String[] var = n.split("\\n");
        for (int i = 0; i < var.length; i ++) {
            String str1 = var[i];
           for (int j = 0; j < var.length; j++) {
               if (str1.equals(var[j]) && j != i && !str1.contains("//") && !str1.isEmpty()) {
                   valid = false;
               }
           }
        }
        return valid;
    }
}
