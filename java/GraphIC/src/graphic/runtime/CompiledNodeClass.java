/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic.runtime;

import graphic.graphpackager.BaseType;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author mic12
 */
public class CompiledNodeClass {
    static Random rand = new Random();
    
    int regNum;
    int inNum; //technically variable
    int outNum;
    
    ArrayList<BaseType> types;
    ArrayList<CompiledNode> nodes;
    
    ArrayList<ConMap> consts;
    //this is to emulate asynchronisity
    //10% chance to attempt to run the node as we fly past... XD
    static float chanceToRun = 0.1f;
    
    //@Override
    public ArrayList<GOutput> execute(ArrayList<GOutput> inputs) {
        //should have already checked if we "can" run it.
        boolean running = true;
        ArrayList<GOutput> registers = new ArrayList(regNum+inNum+outNum);
        ArrayList<Boolean> hasRunList = new ArrayList(nodes.size());
        
        
        
        //fill in the registers
        int r = 0;
        for(; r < inNum; r++)
        {
            if(!inputs.get(r)._typ.equals(types.get(r)))
            {
                throw new UnsupportedOperationException("Input type mismatch.");
            }
            registers.add(inputs.get(r));
        }
        for(; r < regNum+inNum; ++r)
        {
            registers.add(new GOutput(types.get(r-inNum)));
        }
        for(; r < inNum+regNum+outNum; ++r)
        {
            registers.add(new GOutput(types.get(r-inNum-regNum)));
        }
        
        //map the constants in
        for(int c = 0; c < consts.size(); ++c)
        {
            registers.set(consts.get(c).pos, consts.get(c).conVal);
        }
        
        //run all the nodes, emulating asynchronisity(this is slow btw)
        while (running)
        {
            running = false;
            //check if we have run all our nodes
            for(int n = 0; n < hasRunList.size(); ++n)
            {
                boolean run = hasRunList.get(n);
                //if any have not run running = true
                running |= !run;
                if(run && rand.nextFloat() < chanceToRun)
                {
                    CompiledNode node = nodes.get(n);
                    if(node.canRun(registers, hasRunList))
                    {
                        node.execute(registers);
                        //mark this node as having run
                        hasRunList.set(n, true);
                    }
                }
            }
        }
        
        
        //make a list of just the outputs to return
        ArrayList<GOutput> out = new ArrayList(outNum);
        for(int o = 0; o < outNum; o++)
        {
            out.set(o, registers.get(o+regNum+inNum));
        }
        return out;
        
    }
}
