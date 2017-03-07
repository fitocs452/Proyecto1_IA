/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bayesnetwork;

import antlr4.grammarBayesLexer;
import antlr4.grammarBayesParser;
import java.io.File;
import static java.lang.System.in;
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
        
        CharStream cs =  new ANTLRInputStream(networkStr);

        grammarBayesLexer lexer = new grammarBayesLexer(cs);

        CommonTokenStream tokens = new CommonTokenStream( lexer);
        grammarBayesParser  parser = new grammarBayesParser(tokens);
        grammarBayesParser.ProgramContext networkCtx = parser.program();
        ParseTree networkParseTree = networkCtx;
        
        int errorsCount = parser.getNumberOfSyntaxErrors();
        System.out.println("Errors: " + errorsCount);
        // Si no hay errores esta bien descrita
        if (errorsCount == 0) {
            // Validamos la sintaxis
            BayesNetworkValidator validate = new BayesNetworkValidator();
            validate.visit(networkParseTree);
            
            
            BayesNetworkTable table = new BayesNetworkTable();
            table.visit(networkParseTree);
            
            table.generateAllPossibilitiesTable();
                    
            System.out.println("**************************************"
                    + "\nPrint tabla de nodos");
            for (BayesNode bn: validate.getNetwork()) {
                System.out.println(bn.specialToString());
            }
            System.out.println("**************************************\n");
            
            System.out.println("**************************************"
                    + "\nPrint tabla de probabilidades completa");
            for (BayesNode bn: table.getBayesTable()) {
                System.out.println(bn.toDisplay());
            }
            System.out.println("**************************************\n");
            
            System.out.println("NetworkCant: " + validate.validNetwork());
            System.out.println("LinesTotal: " + fileMan.getCantLines());
            boolean validCantProbs = fileMan.getCantLines() == validate.validNetwork();
            System.out.println("Is valid " + (validCantProbs ? "Si": "No"));
            
            boolean validR = validate.validateUnique(networkStr);
            System.out.println("Is valid " + (validR ? "Si": "No"));
            
            System.out.println("");
        }
    }
}
