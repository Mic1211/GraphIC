/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic.runtime;

import java.util.ArrayList;

/**
 *
 * @author mic12
 */
public abstract class CompiledNode {
    CompiledNodeClass parent;
    ArrayList<Integer> inMap;
    ArrayList<Integer> outMap;
    ArrayList<Integer> deps;
    
    
    public abstract void execute(ArrayList<GOutput> io);
    
    public boolean canRun(ArrayList<GOutput> io, ArrayList<Boolean> ranNodes)
    {
        boolean failed = false;
        //as we can run Async, check to make sure all dependencies have run
        for(int d = 0; d < deps.size() && !failed; ++d)
        {
            failed |= !ranNodes.get(deps.get(d));
        }
        
        //make sure all inputs have values assigned
        for(int i = 0; i < inMap.size() && !failed; ++i)
        {
            failed |= !io.get(inMap.get(i))._isWritten;
        }
        
        return failed;
    }
}
