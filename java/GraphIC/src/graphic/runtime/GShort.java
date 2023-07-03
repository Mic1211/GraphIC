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
public class GShort extends GNumber{
    
    private boolean _signed;
    private short _value;
    
    GShort(GByte b)
    {
        _signed = b.isSigned();
        _value = (short)b.getValue();
        if(_signed)
        {
            _value = (short)(_value & 0x000000FF);
        }
    }
    
    GShort(GShort s)
    {
        _signed = s.isSigned();
        _value = s.getValue();
    }
    
    GShort(GInt i)
    {
        _signed = i.isSigned();
        _value = (short)i.getValue();
    }
    
    GShort(GLong l)
    {
        _signed = l.isSigned();
        _value = (short)l.getValue();
    }
    
    GShort(GFloat f, boolean isSigned)
    {
        _value = (short)f.getValue();
        _signed = isSigned;
    }
    
    GShort(GDouble d, boolean isSigned)
    {
        _value = (short)d.getValue();
        _signed = isSigned;
    }


    GShort(short val, boolean isSigned)
    {
        _signed = isSigned;
        _value = val;
    }
    
    public boolean isSigned()
    {
        return _signed;
    }
    
    public short getValue()
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
        return new GInt(this);
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
        return _signed ? _value : (int)(_value & 0xFFFF);
    }

    @Override
    public short toShort() {
        return _value;
    }

    @Override
    public byte toByte() {
        return (byte)_value;
    }
    
    @Override
    public GNumber add(GNumber left, GNumber right)
    {
        return new GShort((short)(left.toShort() + right.toShort()), this._signed);
    }

    @Override
    public GNumber sub(GNumber left, GNumber right) {
        return new GShort((short)(left.toShort() - right.toShort()), this._signed);
    }

    @Override
    public GNumber mul(GNumber left, GNumber right) {
        return new GShort((short)(left.toShort() * right.toShort()), this._signed);
    }

    @Override
    public GNumber mul2(GNumber left, GNumber right) {
        return new GShort((short)((left.toLong() * right.toLong()) >> 16), this._signed);
    }

    @Override
    public GNumber div(GNumber left, GNumber right) {
        return new GShort((short)(left.toShort()/right.toShort()), this._signed);
    }

    @Override
    public GNumber mod(GNumber left, GNumber right) {
        return new GShort((short)(left.toShort()%right.toShort()), this._signed);
    }

    @Override
    public GNumber shl(GNumber left, GNumber right) {
        return new GShort((short)(left.toShort()<<right.toShort()), this._signed);
    }

    @Override
    public GNumber shr(GNumber left, GNumber right) {
        return this._signed ? new GShort((short)(left.toShort()>>right.toShort()), this._signed) : new GShort((short)(left.toShort()>>>right.toShort()), this._signed);
    }

    @Override
    public GNumber and(GNumber left, GNumber right) {
        return new GShort((short)(left.toShort() & right.toShort()), this._signed);
    }

    @Override
    public GNumber or(GNumber left, GNumber right) {
        return new GShort((short)(left.toShort() | right.toShort()), this._signed);
    }

    @Override
    public GNumber xor(GNumber left, GNumber right) {
        return new GShort((short)(left.toShort() ^ right.toShort()), this._signed);
    }
}
