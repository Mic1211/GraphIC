/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic.json;

/**
 *
 * @author mic12
 */
public class Whitespace{

    public static int lineNumber = 0;
    
    public static JsonValue parseString(StringBuilder str) {
        while(str.length() > 0 && (str.charAt(0) == ' ' || str.charAt(0) == 0x0D || str.charAt(0) == 0x0A || str.charAt(0) == 0x09))
        {
            if(str.charAt(0) == 0x0A)
            {
                lineNumber++;
            }
            str.deleteCharAt(0);
        }
        return null;
    }
    
}
