/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchalgorithms;

import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author amorales
 */
public class SearchAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int size = 25;
        ImageParser parse = new ImageParser(size);
        AStar astar = new AStar(size, size, parse.getResized());
        astar.calcular(false,false,false, false);
        
        JFrame window = new JFrame();
        window.setLocation(2,150);
        window.setSize(450, 450);
        window.setVisible(true);
        window.add(
                new GrafoGrafico(
                    size,size, 
                    parse.getResized(), astar.getPath(), 
                    astar.getNodosEvaluados(), astar.getGrafo()
               )
        );
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        Bfs bfs = new Bfs(size, size, parse.getResized());
        bfs.calcular();
        
        JFrame windowBFS = new JFrame();
        windowBFS.setSize(450, 450);
        windowBFS.setLocationRelativeTo(null);
        windowBFS.setVisible(true);
        windowBFS.add(
                new GrafoGrafico(
                    size,size, 
                    parse.getResized(), bfs.getCompletePath(), 
                    bfs.getNodosEvaluados(), bfs.getGrafo()
               )
        );
        windowBFS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
