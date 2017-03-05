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
        BufferedImage resizedImage = new BufferedImage(this.size, this.size, BufferedImage.TYPE_INT_ARGB);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, this.size, this.size, null);
	g.dispose();
	g.setComposite(AlphaComposite.Src);

	g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	g.setRenderingHint(RenderingHints.KEY_RENDERING,
	RenderingHints.VALUE_RENDER_QUALITY);
	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	RenderingHints.VALUE_ANTIALIAS_ON);
        return resizedImage;
    }
  
    public BufferedImage getResized() {
        return resized;
    }
  
    public int getSize() {
        return this.size;
    }
}