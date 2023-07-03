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
public class JsonInteger extends JsonValue{
    long _val;
    
    public JsonInteger(long val)
    {
        _val = val;
    }
}
