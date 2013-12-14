/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.kas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Jan Kyselica <kyselica.jan@gmail.com>
 */
public class TextManipulator {

    static final Charset ENCODING = StandardCharsets.UTF_8;
    private File outputFile;
    private Path path;

    public TextManipulator(String iFile, String oFile) {
        this.outputFile = new File(oFile);
        this.path = Paths.get(iFile, new String[0]);
    }

    public byte[] readTextFile(String aFileName)
            throws IOException {
        byte[] data = Files.readAllBytes(this.path);
        return data;
    }

    public void writeToTextFile(byte[] data)
            throws IOException {
        FileOutputStream output = new FileOutputStream(this.outputFile);
        output.write(data);
    }
}