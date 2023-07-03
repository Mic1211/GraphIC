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
public class ExecNode extends CompiledNode{

    CompiledNodeClass cls;
    
    @Override
    public void execute(ArrayList<GOutput> io) {
        ArrayList<GOutput> inputs = new ArrayList(cls.inNum);
        ArrayList<GOutput> outputs;
        
        
        for(int i = 0; i < this.inMap.size(); ++i)
        {
            inputs.add(io.get(this.inMap.get(i)));
        }
        outputs = cls.execute(inputs);
        
        for(int o = 0; o < cls.outNum; ++o)
        {
            io.set(this.outMap.get(o), outputs.get(o));
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
