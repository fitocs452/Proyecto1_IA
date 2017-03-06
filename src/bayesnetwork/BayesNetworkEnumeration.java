/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bayesnetwork;

import antlr4.grammarBayesBaseVisitor;
import antlr4.grammarBayesParser;
import java.util.ArrayList;

/**
 *
 * @author amorales
 */
public class BayesNetworkEnumeration extends grammarBayesBaseVisitor {
    private boolean isCondition = false;
    private String numerator = "";
    private String denominator = "";
    private ArrayList<String> hiddenVarsNumerator = new ArrayList();
    private ArrayList<String> hiddenVarsDenominator = new ArrayList();
    private String input = "";

    @Override
    public Object visitCliBayes(grammarBayesParser.CliBayesContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            visit(ctx.getChild(i));
            // Cuando es el ultimo tomamos la expresion final
            if (i == ctx.getChildCount() - 1) {
                // Si tenemos variables de condicion
                if (isCondition) {
                    input = numerator + " / " + denominator;
                } else {
                    input = numerator;
                }
                
                // Limpiamos la expresion
                numerator = "";
                denominator = "";
            }
        }
        return super.visitCliBayes(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitCondition(grammarBayesParser.ConditionContext ctx) {
        // Activar bandera ya que tenemos condicion
        isCondition = true;
        return super.visitCondition(ctx); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
        Tomamos el numerador, el numerador es la parte izquierda de la expresion
    */
    @Override
    public Object visitOperator(grammarBayesParser.OperatorContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            String variable = ctx.getChild(i).getText();
            
            numerator += variable;
        }
        return super.visitOperator(ctx); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Object visitOp2(grammarBayesParser.Op2Context ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            String variable = ctx.getChild(i).getText();
            denominator += variable;
            if (variable.contains(",")) {
                variable = variable.replace(",", "");
            }
            
            // Agregamos la variable de condicion al numerador para completarla ya que tomamos ',' como condicion
            numerator += "," + variable;
        }
        return super.visitOp2(ctx); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void getHiddenVars(ArrayList<BayesNode> bayesNetwork) {
        String[] numeratorVariables = numerator.split(",");
        
        getHiddenVarsX(numeratorVariables, bayesNetwork, "numerator");
        
        if (!denominator.isEmpty()) {
            String[] denominatorVariables = numerator.split(",");
            getHiddenVarsX(denominatorVariables, bayesNetwork, "denominator");
        } else {
            hiddenVarsDenominator = new ArrayList();
        }
    }
    
    public void getHiddenVarsX(String[] expVariables, ArrayList<BayesNode> bayesNetwork, String eval) {
        for (BayesNode node : bayesNetwork) {
            boolean found = false;
            for (String expVariable : expVariables) {
                String tmp = expVariable.replace("!", "");
                if (tmp.equals(node.getNodeId())) {
                    found = true;
                }
            }
            if (!found) {
                if ("numerator".equals(eval)) {
                    hiddenVarsNumerator.add(node.getNodeId());
                } else {
                    hiddenVarsDenominator.add(node.getNodeId());
                }
            }
        }
    }
    
    public void calcEnumerationTotal(String exp, ArrayList<BayesNode> bayesNetwork) {
        
    }
    
    public double enumerateNumerator(String exp, ArrayList<BayesNode> bayesNetwork) {
        return 0;
    }
}
