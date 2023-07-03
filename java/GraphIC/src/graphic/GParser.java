/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author mic12
 */
public class GParser {

    
    static final String[] keywords = {"inline", "functional", "export", "import", "module", 
        "end", "endmodule", "if", "else", "endif", "endloop", "sync", "async",
        "frame", "const", "symbol"};
    static final char [] sym = {'[',']','(', ')', ',', '{', '}', '"', '<', '>', '='};
    static final String symbols = "[),(\\x5B\\x5D}{><=]\"'";
    static final String strSymbols = "[\"\\\\]";
    String cLine;
    int cNLine;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public ArrayList getTokens()
    {
        Pattern pat;
        return null;
    }
    
    public void skipWhitespace()
    {
        
    }
}
