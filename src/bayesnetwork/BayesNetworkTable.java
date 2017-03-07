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
public class BayesNetworkTable extends grammarBayesBaseVisitor {
    private ArrayList<BayesNode> bayesTable = new ArrayList();
    private BayesNode actualNode;

    @Override
    public Object visitProbability(grammarBayesParser.ProbabilityContext ctx) {
        String exp = ctx.getText();
        String probabilityString = exp.substring(exp.indexOf("=") + 1, exp.length()).trim();
        double probability = Double.parseDouble(probabilityString);
        actualNode = new BayesNode(exp, probability);
        
        if (!this.bayesTable.contains(actualNode))
            this.bayesTable.add(actualNode);
            
        return null;
    }

    @Override
    public Object visitOp(grammarBayesParser.OpContext ctx) {
        return super.visitOp(ctx);
    }
    
    public ArrayList<BayesNode> getBayesTable() {
        return this.bayesTable;
    }
    
    public String getTableExp() {
        String tableExpression = "";
        ArrayList<String> temp = new ArrayList();
        
        for (BayesNode bn: this.bayesTable) {
            String bnExpression = bn.getExpression().replace("!", "");
//            System.out.println("bnExp: " + bnExpression);
            if (!temp.contains(bnExpression)) {
                temp.add(bnExpression);
                tableExpression += ":" + bnExpression;
            }
        }
        
        return tableExpression;
    }
    
    /* 
        Completamos la tabla agregando las negaciones de las probabilidades
        Por ejemplo P(A) la negamos y obtenemos P(!A) = 1 - P(A)
    */ 
    public void generateAllPossibilitiesTable() {
        ArrayList<BayesNode> all = new ArrayList();
        for (BayesNode bn: this.bayesTable) {
            String bnExpression = bn.getExpression();
            int promisePos = bnExpression.indexOf("(") + 1;
            // Probabilidad inversa
            String notBnExpression = "P(!";
            notBnExpression += bnExpression.substring(promisePos, bnExpression.length());
            
            double notExpProbabiliy = 1 - bn.getProbability();
//            System.out.println("Prob1: " + bn.getProbability() + " ProbNegado: " + notExpProbabiliy);
            BayesNode notExpNode = new BayesNode(notBnExpression, notExpProbabiliy);
//            System.out.println(notExpNode.toDisplay());
            
            // Agregamos la probabilidad normal
            all.add(bn);
            // Agregamos la probabilidad negada
            all.add(notExpNode);
        }
        
        // Sustituimos la tabla actual con la nueva (Que incluye las negaciones)
        this.bayesTable = all;
    }
}
