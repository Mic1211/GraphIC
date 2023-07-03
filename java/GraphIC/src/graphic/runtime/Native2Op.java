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
public class Native2Op extends CompiledNode{

    public static final int ADD = 0;
    public static final int SUB = ADD+1;
    public static final int AND = SUB+1;
    public static final int OR = AND+1;
    public static final int XOR = OR+1;
    public static final int SHL = XOR+1;
    public static final int SHR = SHL+1;
    public static final int MUL = SHR+1;
    public static final int MUL2 = MUL+1;
    //div is not a native 2OP its actually a native 4 OP as it also give mod output
    //we can probably still use it here as it takes 2 input
    //same for multiply with the higher part of the mul? ima say yes
    public static final int DIV = MUL2+1;
    public static final int MOD = DIV+1;

    
    int op;
    
    @Override
    public void execute(ArrayList<GOutput> io) {
        GOutput out = io.get(this.outMap.get(0));
        
        GOutput left = io.get(this.inMap.get(0));
        GOutput right = io.get(this.inMap.get(1));
        
        switch (op)
        {
            case ADD:
                out.setNum(out.getNum().add(left.getNum(), right.getNum()));
                break;
            case SUB:
                out.setNum(out.getNum().sub(left.getNum(), right.getNum()));
                break;
            case AND:
                out.setNum(out.getNum().and(left.getNum(), right.getNum()));
                break;
            case OR:
                out.setNum(out.getNum().or(left.getNum(), right.getNum()));
                break;
            case XOR:
                out.setNum(out.getNum().xor(left.getNum(), right.getNum()));
                break;
            case SHL:
                out.setNum(out.getNum().shl(left.getNum(), right.getNum()));
                break;
            case SHR:
                out.setNum(out.getNum().shr(left.getNum(), right.getNum()));
                break;
            case MUL:
                out.setNum(out.getNum().mul(left.getNum(), right.getNum()));
                break;
            case MUL2:
                out.setNum(out.getNum().mul2(left.getNum(), right.getNum()));
                break;
            case DIV:
                out.setNum(out.getNum().div(left.getNum(), right.getNum()));
                break;
            case MOD:
                out.setNum(out.getNum().mod(left.getNum(), right.getNum()));
                break;
        }
        
    }
    
}
