/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic.graphpackager;

import graphic.runtime.ExecNode;
import graphic.runtime.GICValue;
import java.util.ArrayList;

/**
 *
 * @author mic12
 */
public class Node {
    
    public ArrayList<Type> getOutputs()
    {
        return new ArrayList<Type>();
    }
    
    public void addDependency(Node nd)
    {
        
    }
    
    public void addInput(Node nd, int output, boolean downcast)
    {
        
    }


}
