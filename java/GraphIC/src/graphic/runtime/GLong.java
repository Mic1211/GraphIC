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
public class GLong extends GNumber{
    
    boolean _signed;
    long _value;
    
    GLong(GByte b)
    {
        _signed = b.isSigned();
        _value = (long)b.getValue();
        if(_signed)
        {
            _value = _value & 0x000000FF;
        }
    }
    
    GLong(GShort s)
    {
        _signed = s.isSigned();
        _value = (long)s.getValue();
        if(_signed)
        {
            _value = _value & 0x0000FFFF;
        }
    }
    
    GLong(GInt i)
    {
        _signed = i.isSigned();
        _value = (long)i.getValue();
        if(_signed)
        {
            _value = _value & 0xFFFFFFFFL;
        }
    }
    
    GLong(GFloat f, boolean isSigned)
    {
        _value = (long)f.getValue();
        _signed = isSigned;
    }
    
    GLong(GDouble d, boolean isSigned)
    {
        _value = (long)d.getValue();
        _signed = isSigned;
    }


    GLong(long val, boolean isSigned)
    {
        _signed = isSigned;
        _value = val;
    }    
    
    public boolean isSigned()
    {
        return _signed;
    }
    
    public long getValue()
    {
        return _value;
    }
    
    @Override
    public boolean isNeg(GNumber other) {
        return _signed && _value < 0;
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
        return new GFloat(this);
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
        return _signed ? _value : Math.abs((double)(_value));
    }
    
    @Override
    public float toFloat() {
        return _signed ? _value : Math.abs((float)(_value));
    }

    @Override
    public long toLong() {
        return _value;
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
        return new GLong(left.toLong() + right.toLong(), this._signed);
    }

    @Override
    public GNumber sub(GNumber left, GNumber right) {
        return new GLong(left.toLong() - right.toLong(), this._signed);
    }

    @Override
    public GNumber mul(GNumber left, GNumber right) {
        return new GLong(left.toLong() * right.toLong(), this._signed);
    }

    @Override
    public GNumber mul2(GNumber left, GNumber right) {
        //TODO: work through this
        //128 multiply top
        return new GLong((long)((left.toLong() * right.toLong()) >> 64), this._signed);
    }

    @Override
    public GNumber div(GNumber left, GNumber right) {
        return new GLong(left.toLong()/right.toLong(), this._signed);
    }

    @Override
    public GNumber mod(GNumber left, GNumber right) {
        return new GLong(left.toLong()%right.toLong(), this._signed);
    }

    @Override
    public GNumber shl(GNumber left, GNumber right) {
        return new GLong(left.toLong()<<right.toLong(), this._signed);
    }

    @Override
    public GNumber shr(GNumber left, GNumber right) {
        return this._signed ? new GLong(left.toLong()>>right.toLong(), this._signed) : new GLong(left.toLong()>>>right.toLong(), this._signed);
    }

    @Override
    public GNumber and(GNumber left, GNumber right) {
        return new GLong(left.toLong() & right.toLong(), this._signed);
    }

    @Override
    public GNumber or(GNumber left, GNumber right) {
        return new GLong(left.toLong() | right.toLong(), this._signed);
    }

    @Override
    public GNumber xor(GNumber left, GNumber right) {
        return new GLong(left.toLong() ^ right.toLong(), this._signed);
    }
}
