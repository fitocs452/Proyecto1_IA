/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchalgorithms;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

/**
 *
 * @author amorales
 */
public class ImageParser {

    private int size;
    private BufferedImage resized;
    
    public ImageParser(int size) {
        this.size = size;
        
        try {
           // get the BufferedImage, using the ImageIO class
            BufferedImage image = ImageIO.read( new File("lab.png"));
            this.resized = this.resize(image);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public BufferedImage resize(BufferedImage originalImage) {
        // Inicializamos el nuevo buffered con el tamaño indicado 
        // y le indicamos que va a contener ints que representan ARGB
        BufferedImage resizedImage = new BufferedImage(this.size, this.size, BufferedImage.TYPE_INT_ARGB);
        // Creamos la nueva imagen virtual 2D
	Graphics2D g = resizedImage.createGraphics();
        /*
            1. Le mandamos la imagen a dibujar
            2. Le mandamos la posicion x en 0 para empezar a dibujar allí
            3. Le mandamos la posicion y en 0 para empezar a dibujar allí
            4. Width: el ancho de la nueva imagen
            5. Height: el alto de la nueva imagen
        */
	g.drawImage(originalImage, 0, 0, this.size, this.size, null);
        return resizedImage;
    }
  
    public BufferedImage getResized() {
        return resized;
    }
  
    public int getSize() {
        return this.size;
    }
}