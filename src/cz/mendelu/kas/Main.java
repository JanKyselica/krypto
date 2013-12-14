/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.kas;

/**
 *
 * @author Jan Kyselica <kyselica.jan@gmail.com>
 */
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    static String inputFileName = "nesifrovany.txt";
    static String outputFileName = "sifrovany.txt";

    public static void main(String[] args) {
        TextManipulator text = new TextManipulator(inputFileName, outputFileName);
        try {
            byte[] data = text.readTextFile(inputFileName);
            String s = new String(data);
            System.out.println(data.length);
            Serpent serpent = new Serpent();

            text.writeToTextFile(serpent.encode(data));
        } catch (FileNotFoundException e) {           
            System.out.println("Subor sa nenasiel " + e);
        } catch (IOException e) {           
            e.printStackTrace();
        } finally {
        }
    }
}
