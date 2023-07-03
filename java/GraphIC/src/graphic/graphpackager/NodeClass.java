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
public class NodeClass {
    //if dependency node is null, it goes to the inputs of this class
    //the output node is the node that has all the outputs and 
    Node output;
    ArrayList<Type> inputs;
    boolean variableInputLen;
    boolean loopable;
    
}
