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
public class GByte extends GNumber{

    private boolean _signed;
    private byte _value;
    
    GByte(byte val, boolean isSigned)
    {
        _value = val;
        _signed = isSigned;
    }
    
    public boolean isSigned()
    {
        return _signed;
    }
    
    public byte getValue()
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
        return new GShort(this);
    }

    @Override
    public GNumber upByte() {
        return this;
    }

    @Override
    public double toDouble() {
        return toShort();
    }

    @Override
    public float toFloat() {
        return toShort();
    }

    @Override
    public long toLong() {
        return toShort();
    }

    @Override
    public int toInt() {
        return toShort();
    }

    @Override
    public short toShort() {
        return _signed ? _value : (short)(_value & 0xFF);
    }

    @Override
    public byte toByte() {
        return _value;
    }
    
    @Override
    public GNumber add(GNumber left, GNumber right)
    {
        return new GByte((byte)(left.toByte() + right.toByte()), this._signed);
    }

    @Override
    public GNumber sub(GNumber left, GNumber right) {
        return new GByte((byte)(left.toByte() - right.toByte()), this._signed);
    }

    @Override
    public GNumber mul(GNumber left, GNumber right) {
        return new GByte((byte)(left.toByte() * right.toByte()), this._signed);
    }

    @Override
    public GNumber mul2(GNumber left, GNumber right) {
        return new GByte((byte)((left.toLong() * right.toLong()) >> 8), this._signed);
    }

    @Override
    public GNumber div(GNumber left, GNumber right) {
        return new GByte((byte)(left.toByte()/right.toByte()), this._signed);
    }

    @Override
    public GNumber mod(GNumber left, GNumber right) {
        return new GByte((byte)(left.toByte()%right.toByte()), this._signed);
    }

    @Override
    public GNumber shl(GNumber left, GNumber right) {
        return new GByte((byte)(left.toByte()<<right.toByte()), this._signed);
    }

    @Override
    public GNumber shr(GNumber left, GNumber right) {
        return this._signed ? new GByte((byte)(left.toByte()>>right.toByte()), this._signed) : new GByte((byte)(left.toByte()>>>right.toByte()), this._signed);
    }

    @Override
    public GNumber and(GNumber left, GNumber right) {
        return new GByte((byte)(left.toByte() & right.toByte()), this._signed);
    }

    @Override
    public GNumber or(GNumber left, GNumber right) {
        return new GByte((byte)(left.toByte() | right.toByte()), this._signed);
    }

    @Override
    public GNumber xor(GNumber left, GNumber right) {
        return new GByte((byte)(left.toByte() ^ right.toByte()), this._signed);
    }
    
}
