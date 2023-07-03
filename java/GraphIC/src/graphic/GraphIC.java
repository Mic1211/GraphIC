/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

import graphic.graphpackager.Path;
import graphic.json.JsonParser;
import graphic.json.JsonValue;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;



/**
 *
 * @author mic12
 */
public class GraphIC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, IOException {
        // TODO code application logic here
        
        JsonValue val = JsonParser.parse(Files.readString(new File("test.json").toPath()));
        
        System.out.println(val);
        return;
    }
    
}
