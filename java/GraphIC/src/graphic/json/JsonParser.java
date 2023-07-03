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
public class JsonParser {
    public static JsonValue parse(String str) throws ParseException
    {
        JsonValue ret;
        StringBuilder builder = new StringBuilder(str);
        
        ret = JsonValue.parseString(builder);
        
        return ret;
    }
}
