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
public class JsonNumber {
    public static JsonValue parseString(StringBuilder str) throws ParseException
    {
        JsonValue ret;
        StringBuilder val = new StringBuilder();
        boolean isFloat = false;
        if(!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-')
        {
            throw new ParseException("Expected number", 0);
        }
        
        if(str.charAt(0) == '-' && !Character.isDigit(str.charAt(1)))
        {
            throw new ParseException("Expected digit after -", 0);
        }
        
        val.append(str.charAt(0));
        str.deleteCharAt(0);
        
        while(str.length() > 0 && Character.isDigit(str.charAt(0)))
        {
           val.append(str.charAt(0));
           str.deleteCharAt(0);
        }
        
        //check for decimal point
        if(str.length() > 0 && str.charAt(0) == '.')
        {
            isFloat = true;
            val.append(str.charAt(0));
            str.deleteCharAt(0);
            if(!Character.isDigit(str.charAt(0)))
            {
                throw new ParseException("Digit Expected after .", 0);
            }
            
            while(str.length() > 0 && Character.isDigit(str.charAt(0)))
            {
               val.append(str.charAt(0));
               str.deleteCharAt(0);
            }
        }
        
        //check for exponent
        if(str.length() > 0 && (str.charAt(0) == 'e' || str.charAt(0) == 'E'))
        {
            isFloat = true;
            val.append(str.charAt(0));
            str.deleteCharAt(0);
            
            if(str.charAt(0) == '-' || str.charAt(0) == '+')
            {
                val.append(str.charAt(0));
                str.deleteCharAt(0);
            }
            
            if(!Character.isDigit(str.charAt(0)))
            {
                throw new ParseException("Digit Expected after e/E", 0);
            }
            
            while(str.length() > 0 && Character.isDigit(str.charAt(0)))
            {
               val.append(str.charAt(0));
               str.deleteCharAt(0);
            }
        }
        
        if(isFloat)
        {
            ret = new JsonFloat(Double.parseDouble(val.toString()));
        }
        else
        {
            ret = new JsonInteger(Long.parseLong(val.toString()));
        }
        
        return ret;
    }
}
