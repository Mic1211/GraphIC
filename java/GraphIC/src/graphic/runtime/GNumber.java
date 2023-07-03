/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic.runtime;

/**
 *
 * @author mic12
 */
public abstract class GNumber {
    
    GNumber upcast(GNumber comparer)
    {
        GNumber ret = this;
        
        if(comparer instanceof GDouble)
        {
            ret = this.upDouble();
        }
        else if(comparer instanceof GFloat)
        {
            ret = this.upFloat();
        }
        else if(comparer instanceof GLong)
        {
            ret = this.upLong();
        }
        else if(comparer instanceof GInt)
        {
            ret = this.upInt();
        }
        else if(comparer instanceof GShort)
        {
            ret = this.upShort();
        }
        else if(comparer instanceof GByte)
        {
            ret = this.upByte();
        }
        
        return ret;
    }
    
    public abstract boolean isNeg(GNumber other);
    public abstract boolean isZero(GNumber other);
    
    public abstract GNumber upDouble();
    public abstract GNumber upFloat();
    public abstract GNumber upLong();
    public abstract GNumber upInt();
    public abstract GNumber upShort();
    public abstract GNumber upByte();
    
    public abstract double toDouble();
    public abstract float toFloat();
    public abstract long toLong();
    public abstract int toInt();
    public abstract short toShort();
    public abstract byte toByte();
    
    public abstract GNumber add(GNumber left, GNumber right);
    public abstract GNumber sub(GNumber left, GNumber right);
    public abstract GNumber mul(GNumber left, GNumber right);
    public abstract GNumber mul2(GNumber left, GNumber right);
    public abstract GNumber div(GNumber left, GNumber right);
    public abstract GNumber mod(GNumber left, GNumber right);
    
    public abstract GNumber shl(GNumber left, GNumber right);
    public abstract GNumber shr(GNumber left, GNumber right);
    public abstract GNumber and(GNumber left, GNumber right);
    public abstract GNumber or(GNumber left, GNumber right);
    public abstract GNumber xor(GNumber left, GNumber right);
}
