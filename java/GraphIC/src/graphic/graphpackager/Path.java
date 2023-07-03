/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic.graphpackager;

/**
 *
 * @author mic12
 */
public class Path {
    Node dependancy;
    Node dependant;
    int outputID;
    boolean allowDowncast; //upcast is always allowed, sidecast(signed/unsigned always allowed)
    
    public Path(Node dep, Node depcy, int out, boolean downcast)
    {
        dependancy = depcy;
        dependant = dep;
        outputID = out;
        allowDowncast = downcast;
    }
}
