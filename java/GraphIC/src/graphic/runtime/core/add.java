/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic.runtime.core;

import graphic.runtime.GICValue;
import graphic.runtime.RunnableNode;
import java.util.ArrayList;

/**
 *
 * @author mic12
 */
public class add implements RunnableNode{

    @Override
    public ArrayList<GICValue> execute(ArrayList<GICValue> inputs) {
        GICValue parl = inputs.get(0);
        GICValue par2 = inputs.get(1);
        GICValue sum = null;
        
        
        ArrayList<GICValue> outputs = new ArrayList<>(1);
        outputs.set(0, sum);
        
        return outputs;
    }
    
}
