/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bayesnetwork;

import antlr4.grammarBayesLexer;
import antlr4.grammarBayesParser;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author amorales
 */
public class BayesNetwork {
    public static void main(String[] args) {
        FIleManager fileMan = new FIleManager();
        String networkStr = fileMan.leerArchivo(new File("network.txt"));
        
        CharStream stream =  new ANTLRInputStream(networkStr);

        // Lexer
        grammarBayesLexer bayesLexer = new grammarBayesLexer(stream);
        // Tokens (lexer)
        CommonTokenStream bayesTokens = new CommonTokenStream(bayesLexer);
        // Parser (lexer, tokens)
        grammarBayesParser bayesParser = new grammarBayesParser(bayesTokens);
        grammarBayesParser.ProgramContext networkCtx = bayesParser.program();
        
        // Arbol semantico
        ParseTree networkParseTree = networkCtx;
        
        // total de errores en el arbol semantico (este bien escrito y tenga sentido)
        int errorsCount = bayesParser.getNumberOfSyntaxErrors();
        System.out.println("Errors: " + errorsCount);
        // Aqui termina la validacion de la gramatica
        
        // Si no hay errores, esta bien descrita
        if (errorsCount == 0) {
            // Validamos la red de bayes ingresada
            BayesNetworkValidator validate = new BayesNetworkValidator();
            validate.visit(networkParseTree);
            
            // Generamos el la tabla de nodos (variables en red bayesiana)
            BayesNetworkTable table = new BayesNetworkTable();
            table.visit(networkParseTree);
            
            // Obtenemos el string total que describe toda nuestra red bayesiana
            String redBayesianaProbs = table.getTableExp();
                    
            // Imprimimos la tabla de nodos
            System.out.println("**************************************"
                    + "\nPrint tabla de nodos");
            for (BayesNode bn: validate.getNetwork()) {
                System.out.println(bn.specialToString());
            }
            System.out.println("**************************************\n");
            
            // Imprimimos la tabla de probabilidades
            System.out.println("**************************************"
                    + "\nPrint tabla de probabilidades completa");
            for (BayesNode bn: table.getBayesTable()) {
                System.out.println(bn.toDisplay());
            }
            System.out.println("**************************************\n");
            
            // Validamos que la cantidad de probabilidades parseadas sea la cantidad de probabilides ingresadas
            boolean validCantProbs = fileMan.getCantLines() == validate.validNetwork();
            System.out.println("Is valid " + (validCantProbs ? "Si": "No"));
            
            // Validamos que la red bayesiana cumpla con las probabilidades ingresadas
            boolean validProbsEquality = validate.validateUnique(networkStr);
            System.out.println("Is valid " + (validProbsEquality ? "Si": "No"));
            
            // network: Nodos de la red bayesiana
            ArrayList<BayesNode> network = validate.getNetwork();
            // probs: Nodos con las probabilidades (tabla de probs)
            ArrayList<BayesNode> completeNetwork = table.getBayesTable();
            
            
            // Si la tabla esta completa con todas las probabilidades y verificamos que tenemos
            // las probabilidades bien
            while (validCantProbs && validProbsEquality) {
                String expression = JOptionPane.showInputDialog(
                   null,
                   "Ingrese expresion a calcular",
                   "",
                   JOptionPane.QUESTION_MESSAGE).toUpperCase();
                
                // Solo para mostrar error
                errorsCount = 1;
                if (!expression.isEmpty()) {
                    System.out.println("Expresion a calcular: " + expression);
                    // Validamos que la expresion a evaluar este bien escrita
                    stream =  new ANTLRInputStream(expression);
                    bayesLexer = new grammarBayesLexer(stream);
                    bayesTokens = new CommonTokenStream(bayesLexer);
                    bayesParser = new grammarBayesParser(bayesTokens);
                    grammarBayesParser.CliBayesContext context = bayesParser.cliBayes();
                    networkParseTree = context;
                    errorsCount = bayesParser.getNumberOfSyntaxErrors();
                    // terminamos la validacion
                }
                // Si tenemos errores en la expresion (mal escrita) entonces pedimos otra vez
                if (errorsCount > 0) {
                    JOptionPane.showMessageDialog(null, "Expresión mal ingresada", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    BayesNetworkEnumeration enumeration = new BayesNetworkEnumeration();
                    enumeration.visit(networkParseTree);
                    enumeration.getHiddenVars(network);
//                    pTotal = enumeration.includeExpression(pTotal, expression);
                    double answer = enumeration.calcEnumerationTotal(enumeration.includeExpression(redBayesianaProbs, expression), completeNetwork);
                    JOptionPane.showMessageDialog(null, expression+" = "+answer);

                }
            }
        }
    }
}
