/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic.json;

import java.text.ParseException;
import java.util.HashMap;

/**
 *
 * @author mic12
 */
public class JsonObject extends JsonValue{
    private HashMap<String, JsonValue> _map;
    
    public static JsonObject parseString(StringBuilder str) throws ParseException
    {
        HashMap<String, JsonValue> map = new HashMap<>();
        String key;
        JsonValue val;
        
        if((str.length() > 0 && str.charAt(0) != '{') || str.length() == 0 )
        {
            throw new ParseException("Expected Object", Whitespace.lineNumber);
        }
        
        str.deleteCharAt(0);
        Whitespace.parseString(str);
        
        if(str.charAt(0) != '}')
        {
            while(str.length() > 0 && str.charAt(0) != '}')
            {
                Whitespace.parseString(str);
                key = ((JsonString)JsonString.parseString(str)).getValue();
                Whitespace.parseString(str);
                if(str.charAt(0) != ':')
                {
                    throw new ParseException("Expected : got " + str.charAt(0), Whitespace.lineNumber);
                }
                str.deleteCharAt(0);
                val = JsonValue.parseString(str);

                map.put(key, val);

                if(str.length() > 0 && str.charAt(0) != ',' && str.charAt(0) != '}')
                {
                    throw new ParseException("Expected , or }", Whitespace.lineNumber);
                }
                
                if(str.charAt(0) == ',')
                {
                    str.deleteCharAt(0);
                }
            }
            if(str.length() == 0)
            {
                throw new ParseException("Unexpected end of file", Whitespace.lineNumber);
            }
            
        }
        str.deleteCharAt(0);
        
        
        JsonObject ret = new JsonObject();
        ret._map = map;
        return ret;
    }
}
