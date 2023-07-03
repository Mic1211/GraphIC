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
public class JsonString extends JsonValue{
    private String _str;
    
    public String getValue()
    {
        return _str;
    }
    
    public static JsonString parseString(StringBuilder str) throws ParseException
    {
        JsonString val;
        StringBuilder nStr = new StringBuilder();
        if(str.charAt(0) == '"')
        {
            str.deleteCharAt(0);
            while(str.charAt(0) != '"' && str.length() > 0)
            {
                if(str.charAt(0) == '\\')
                {
                    //TODO: Make sure we have another character, don't just assume
                    switch(str.charAt(1))
                    {
                        case '"':
                            nStr.append('"');
                            str.delete(0, 2);
                            break;
                        case '\\':
                            nStr.append('\\');
                            str.delete(0, 2);
                            break;
                        case '/':
                            nStr.append('/');
                            str.delete(0, 2);
                            break;
                        case 'b':
                            nStr.append(0x08);
                            str.delete(0, 2);
                            break;
                        case 'f':
                            nStr.append(0x0C);
                            str.delete(0, 2);
                            break;
                        case 'n':
                            nStr.append(0x0A);
                            str.delete(0, 2);
                            break;
                        case 'r':
                            nStr.append(0x0D);
                            str.delete(0, 2);
                            break;
                        case 't':
                            nStr.append(0x09);
                            str.delete(0, 2);
                            break;
                        case 'u':
                            //TODO: ERROR CHECK for 4 hex digits, don't just assume(for now we just assume XD)
                            if(!isHexDigit(str.charAt(2)) || !isHexDigit(str.charAt(3)) || !isHexDigit(str.charAt(4)) || !isHexDigit(str.charAt(5)))
                            {
                                throw new ParseException("Expected hex digit!", Whitespace.lineNumber);
                            }
                            nStr.append((char)Integer.parseInt(str.substring(2, 6), 16));
                            str.delete(0, 6);
                            break;
                        default:
                            throw new ParseException("Expected valid escape character!", Whitespace.lineNumber);
                    }
                    
                }
                else
                {
                    if(str.charAt(0) != '"' &&
                        str.charAt(0) != '\\' &&
                        str.charAt(0) != '/' &&
                        str.charAt(0) != 0x08 &&
                        str.charAt(0) != 0x09 &&
                        str.charAt(0) != 0x0A &&
                        str.charAt(0) != 0x0C &&
                        str.charAt(0) != 0x0D)
                    {
                        nStr.append(str.charAt(0));
                    }
                    if(str.charAt(0) == 0x0A)
                    {
                        Whitespace.lineNumber++;
                    }
                    str.deleteCharAt(0);
                }
            }
            if(str.length() < 0)
            {
                throw new ParseException("Expected \"", Whitespace.lineNumber);
            }
            str.deleteCharAt(0);
        }
        else
        {
            throw new ParseException("Expected \" got " + str.charAt(0), Whitespace.lineNumber);
        }
        
        val = new JsonString();
        val._str = nStr.toString();
        
        return val;
    }
    
    public static boolean isHexDigit(char c)
    {
        boolean ret = false;
        switch(c)
        {
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
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
                ret = true;
        }
        
        return ret;
    }
}
