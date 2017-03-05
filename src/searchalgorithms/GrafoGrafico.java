/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchalgorithms;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JPanel;

/**
 *
 * @author amorales
 */
public class GrafoGrafico extends JPanel{
    private final Grafo grafo;
    private final int EscalaX;
    private final int EscalaY;
    private final int ancho;
    private final int alto;
    private final List<Nodo> path;
    private final Set<Nodo> nodosEvaluados;
    private final BufferedImage image;

    public GrafoGrafico(int ancho, int alto, BufferedImage image, ArrayList path, Set<Nodo> nodosEvaluados, Grafo grafo) {
        this.EscalaX=400/ancho;
        this.EscalaY=400/alto;
        this.ancho = ancho;
        this.alto = alto;
        this.image = image;
        this.path = path;
        this.nodosEvaluados = nodosEvaluados;
        this.grafo = grafo;
        setSize(EscalaX * ancho, EscalaY * alto);
        setVisible(true);
    }
    
    
    private void fillRect(Graphics graphics, int x, int y) {
          graphics.fill3DRect(EscalaX*x, EscalaY*y, EscalaX, EscalaY, true);
     }
     public void paintObstacles(Graphics graphics) {
          graphics.setColor(Color.BLACK);
          
          for (int x = 0; x < alto; ++x) {
               for (int y = 0; y < ancho; ++y) {
                    if (grafo.getNodo(x, y).isObstaculo()) {
                         fillRect(graphics, x, y);
                    }
               }
          }
     }
    public void paintGrafo(Graphics graphics){
        boolean red = false;
        ColorParser imageColor = new ColorParser();
        for (int y = 0; y < alto; y++) {
           for (int x = 0; x < ancho; x++) {
             graphics.setColor(Color.white);
             int type =  imageColor.getPixelRGB(this.image.getRGB(x, y));
             
             if (type == 0) {
                graphics.setColor(Color.black);
             }
             else if (type == 1) {
                graphics.setColor(Color.white);
             }
             else if (type == 2 && red == false) {
                red = true;
                graphics.setColor(Color.red);
             }
             else if (type == 3) {
                graphics.setColor(Color.green);
             }
             
             fillRect(graphics,x,y);
           }
       }
    }
      @Override
    public void paint(Graphics graphics) {

         graphics.setColor(Color.DARK_GRAY);
         paintGrafo(graphics);
//         paintObstacles(graphics);
         paintPath(graphics);
         //paintEvaluatedNodes(graphics);
    }
      
    private void paintPath(Graphics graphics) {
       
        graphics.setColor(Color.lightGray);
        for (Nodo n1: nodosEvaluados) {
            if (!this.grafo.getNodosSalida().contains(n1) && n1 != this.grafo.getNodoInicial()) {
                fillRect(graphics,n1.getX(),n1.getY());
            }
       }
       
        graphics.setColor(Color.YELLOW);
        for (Nodo n : path) {
            if (!this.grafo.getNodosSalida().contains(n) && n != this.grafo.getNodoInicial()) {
                int x = n.getX(); int y = n.getY();
                fillRect(graphics, x, y);   
            }
       }
       
       
    }
   
}
