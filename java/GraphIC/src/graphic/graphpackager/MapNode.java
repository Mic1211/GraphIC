/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic.graphpackager;

import java.util.ArrayList;

/**
 *
 * @author mic12
 */
public class MapNode extends Node{
    NodeClass nodeCls;
    ArrayList<Path> inputs;
    ArrayList<Type> outputs;
    ArrayList<Node> dependencies; //need to be finished before we run this one even though we don't use the outputs from them
    
    public MapNode(NodeClass cls)
    {
        nodeCls = cls;
        outputs = nodeCls.output.getOutputs();
    }
    
    public void addDependency(Node nd)
    {
        dependencies.add(nd);
    }
    
    public void addInput(Node nd, int output, boolean downcast)
    {
        inputs.add(new Path(nd, this, output, downcast));
    }
    
    @Override
    public ArrayList<Type> getOutputs()
    {
        return outputs;
    }
}
