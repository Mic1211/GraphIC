/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic.json;

import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author mic12
 */
public class JsonArray extends JsonValue{
    private ArrayList<JsonValue> _list;
    
    public static JsonArray parseString(StringBuilder str) throws ParseException
    {
        ArrayList<JsonValue> list = new ArrayList();
        if((str.length() > 0 && str.charAt(0) != '[') || str.length() == 0 )
        {
            throw new ParseException("Expected Array", Whitespace.lineNumber);
        }
        
        str.deleteCharAt(0);
        Whitespace.parseString(str);
        
        if(str.charAt(0) != ']')
        {
            while(str.charAt(0) != ']' && str.length() > 0)
            {
                list.add(JsonValue.parseString(str));
                if(str.length() == 0 || str.charAt(0) != ',' && str.charAt(0) != ']')
                {
                    throw new ParseException("Expected , or ]", Whitespace.lineNumber);
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
        
        JsonArray ret = new JsonArray();
        ret._list = list;
        
        return ret;
    }
}
