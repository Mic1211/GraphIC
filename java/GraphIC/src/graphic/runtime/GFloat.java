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
public class GFloat extends GNumber{
    float _value;
    
    GFloat(GByte b)
    {
        _value = (float)b.getValue();
        if(b.isSigned())
        {
            _value = Math.abs(_value);
        }
    }
    
    GFloat(GShort s)
    {
        _value = (float)s.getValue();
        if(s.isSigned())
        {
            _value = Math.abs(_value);
        }
    }
    
    GFloat(GInt i)
    {
        _value = (float)i.getValue();
        if(i.isSigned())
        {
            _value = Math.abs(_value);
        }
    }
    
    GFloat(GLong l)
    {
        _value = (float)l.getValue();
        if(l.isSigned())
        {
            _value = Math.abs(_value);
        }
    }
    
    GFloat(GFloat f)
    {
        _value = f.getValue();
    }
    
    GFloat(GDouble d)
    {
        _value = (float)d.getValue();
    }

    GFloat(float val)
    {
        _value = val;
    }
    
    public float getValue()
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
        return new GDouble(this);
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
        return _value;
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
        return new GFloat(left.toFloat() + right.toFloat());
    }

    @Override
    public GNumber sub(GNumber left, GNumber right) {
        return new GFloat(left.toFloat() - right.toFloat());
    }

    @Override
    public GNumber mul(GNumber left, GNumber right) {
        return new GFloat(left.toFloat() * right.toFloat());
    }

    @Override
    public GNumber mul2(GNumber left, GNumber right) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GNumber div(GNumber left, GNumber right) {
        return new GFloat(left.toFloat()/right.toFloat());
    }

    @Override
    public GNumber mod(GNumber left, GNumber right) {
        return new GFloat(left.toFloat()%right.toFloat());
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
