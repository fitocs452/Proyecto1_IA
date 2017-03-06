/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bayesnetwork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author amorales
 */
public class FIleManager {
    private int cantLines = 0;
    
    public String leerArchivo(File inputFile) {
        String input = " ";
        BufferedReader br = null;
 
        try {
            br = new BufferedReader(new FileReader(inputFile.getAbsoluteFile()));
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                input += sCurrentLine + "\n";
                if (!sCurrentLine.isEmpty() && !sCurrentLine.contains("/")){
                    cantLines++;
                }
            }
            
            input += "\n";

            return input;
        } catch (IOException e) {
               
        } finally {
                try {
                        if (br != null)br.close();
                } catch (IOException ex) {
                        ex.printStackTrace();
                }
        }
        return null;
        
    }

    public int getCantLines() {
        return cantLines;
    }
}
