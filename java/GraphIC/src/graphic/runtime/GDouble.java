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
public class GDouble extends GNumber{
    double _value;
    
    GDouble(GByte b)
    {
        _value = (double)b.getValue();
        if(b.isSigned())
        {
            _value = Math.abs(_value);
        }
    }
    
    GDouble(GShort s)
    {
        _value = (double)s.getValue();
        if(s.isSigned())
        {
            _value = Math.abs(_value);
        }
    }
    
    GDouble(GInt i)
    {
        _value = (double)i.getValue();
        if(i.isSigned())
        {
            _value = Math.abs(_value);
        }
    }
    
    GDouble(GLong l)
    {
        _value = (double)l.getValue();
        if(l.isSigned())
        {
            _value = Math.abs(_value);
        }
    }
    
    GDouble(GFloat f)
    {
        _value = (double)f.getValue();
    }
    
    GDouble(GDouble d)
    {
        _value = d.getValue();
    }

    GDouble(double val)
    {
        _value = val;
    }
    
    public double getValue()
    {
        return _value;
    }
    
    @Override
    public boolean isNeg(GNumber other) {
        return _value < 0;
    }

    @Override
    public boolean isZero(GNumber other) {
        return _value == 0;
    }
    
    @Override
    public GNumber upDouble() {
        return this;
    }

    @Override
    public GNumber upFloat() {
        return this;
    }

    @Override
    public GNumber upLong() {
        return this;
    }

    @Override
    public GNumber upInt() {
        return this;
    }

    @Override
    public GNumber upShort() {
        return this;
    }

    @Override
    public GNumber upByte() {
        return this;
    }
    
    @Override
    public double toDouble() {
        return _value;
    }

    @Override
    public float toFloat() {
        return (float)_value;
    }

    @Override
    public long toLong() {
        return (long)_value;
    }

    @Override
    public int toInt() {
        return (int)_value;
    }

    @Override
    public short toShort() {
        return (short)_value;
    }

    @Override
    public byte toByte() {
        return (byte)_value;
    }

    @Override
    public GNumber add(GNumber left, GNumber right)
    {
        return new GDouble(left.toDouble() + right.toDouble());
    }

    @Override
    public GNumber sub(GNumber left, GNumber right) {
        return new GDouble(left.toDouble() - right.toDouble());
    }

    @Override
    public GNumber mul(GNumber left, GNumber right) {
        return new GDouble(left.toDouble() * right.toDouble());
    }

    @Override
    public GNumber mul2(GNumber left, GNumber right) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GNumber div(GNumber left, GNumber right) {
        return new GDouble(left.toDouble()/right.toDouble());
    }

    @Override
    public GNumber mod(GNumber left, GNumber right) {
        return new GDouble(left.toDouble()%right.toDouble());
    }

    @Override
    public GNumber shl(GNumber left, GNumber right) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GNumber shr(GNumber left, GNumber right) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GNumber and(GNumber left, GNumber right) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GNumber or(GNumber left, GNumber right) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GNumber xor(GNumber left, GNumber right) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
