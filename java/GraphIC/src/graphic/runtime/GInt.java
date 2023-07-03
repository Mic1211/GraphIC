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
public class GInt extends GNumber{
    private boolean _signed;
    private int _value;

    GInt(GByte b)
    {
        _signed = b.isSigned();
        _value = (int)b.getValue();
        if(_signed)
        {
            _value = _value & 0x000000FF;
        }
    }
    
    GInt(GShort s)
    {
        _signed = s.isSigned();
        _value = (int)s.getValue();
        if(_signed)
        {
            _value = _value & 0x0000FFFF;
        }
    }
    
    GInt(GInt i)
    {
        _signed = i.isSigned();
        _value = i.getValue();
    }
    
    GInt(GLong l)
    {
        _signed = l.isSigned();
        _value = (int)l.getValue();
    }
    
    GInt(GFloat f, boolean isSigned)
    {
        _value = (int)f.getValue();
        _signed = isSigned;
    }
    
    GInt(GDouble d, boolean isSigned)
    {
        _value = (int)d.getValue();
        _signed = isSigned;
    }


    GInt(int val, boolean isSigned)
    {
        _signed = isSigned;
        _value = val;
    }
    
    public boolean isSigned()
    {
        return _signed;
    }
    
    public int getValue()
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
        return new GLong(this);
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
        return toInt();
    }

    @Override
    public float toFloat() {
        return toInt();
    }

    @Override
    public long toLong() {
        return toInt();
    }

    @Override
    public int toInt() {
        return _signed ? _value : (int)(_value & 0xFF);
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
        return new GInt(left.toInt() + right.toInt(), this._signed);
    }

    @Override
    public GNumber sub(GNumber left, GNumber right) {
        return new GInt(left.toInt() - right.toInt(), this._signed);
    }

    @Override
    public GNumber mul(GNumber left, GNumber right) {
        return new GInt(left.toInt() * right.toInt(), this._signed);
    }

    @Override
    public GNumber mul2(GNumber left, GNumber right) {
        return new GInt((int)((left.toLong() * right.toLong()) >> 32), this._signed);
    }

    @Override
    public GNumber div(GNumber left, GNumber right) {
        return new GInt(left.toInt()/right.toInt(), this._signed);
    }

    @Override
    public GNumber mod(GNumber left, GNumber right) {
        return new GInt(left.toInt()%right.toInt(), this._signed);
    }

    @Override
    public GNumber shl(GNumber left, GNumber right) {
        return new GInt(left.toInt()<<right.toInt(), this._signed);
    }

    @Override
    public GNumber shr(GNumber left, GNumber right) {
        return this._signed ? new GInt(left.toInt()>>right.toInt(), this._signed) : new GInt(left.toInt()>>>right.toInt(), this._signed);
    }

    @Override
    public GNumber and(GNumber left, GNumber right) {
        return new GInt(left.toInt() & right.toInt(), this._signed);
    }

    @Override
    public GNumber or(GNumber left, GNumber right) {
        return new GInt(left.toInt() | right.toInt(), this._signed);
    }

    @Override
    public GNumber xor(GNumber left, GNumber right) {
        return new GInt(left.toInt() ^ right.toInt(), this._signed);
    }
    
}
