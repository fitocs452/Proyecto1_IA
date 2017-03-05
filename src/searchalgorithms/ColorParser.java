/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchalgorithms;

import java.awt.Color;

/**
 *
 * @author amorales
 */
public class ColorParser {
    public int getPixelRGB(int pixel) {
        
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        
        // Si el color es blanco el tipo es 1
        if (red > 250 && green > 250 && blue > 250) {
            return 1;
        }
                
        // Si el color es rojo el tipo es 2
        if ((red > 200 && green < 200 && blue < 200)) {
            return 2;
        }
        
        // Si el color es verde el tipo es 3
        if (green > 100 && red > 40 && blue < 100 || (red <= 15 && green > 200 && blue <= 15)) {
       
            return 3;
        }
        
        // Si el color es negreo el tipo es 0
        if (red < 192 && blue < 192 && green < 192) {
            return 0;
        }
        
        // El color default es negro
        return 0;
   
    }   
}
