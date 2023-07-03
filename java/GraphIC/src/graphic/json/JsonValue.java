/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic.json;

import java.text.ParseException;

/**
 *
 * @author mic12
 */
public class JsonValue{
    
    public static JsonValue parseString(StringBuilder str) throws ParseException
    {
        JsonValue val;
        Whitespace.parseString(str);
        switch(str.charAt(0))
        {
            case '"':
                val = JsonString.parseString(str);
                break;
            case '{':
                val = JsonObject.parseString(str);
                break;
            case '-':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                val = JsonNumber.parseString(str);
                break;
            case '[':
                val = JsonArray.parseString(str);
                break;
            default:
                String part = str.substring(0, Math.min(5, str.length()));
                if(part.startsWith("true"))
                {
                    str.delete(0, 4);
                    val = new JsonBool(true);
                }
                else if(part.startsWith("false"))
                {
                    str.delete(0, 5);
                    val = new JsonBool(false);
                }
                else if(part.startsWith("null"))
                {
                    str.delete(0, 4);
                    val = null;
                }
                else
                {
                    throw new ParseException("expected JSON value " + part, Whitespace.lineNumber);
                }
        }
        Whitespace.parseString(str);
        
        return val;
    }
    
}
