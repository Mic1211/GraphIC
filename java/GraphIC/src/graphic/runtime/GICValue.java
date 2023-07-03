/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic.runtime;

import graphic.graphpackager.BaseType;

/**
 *
 * @author mic12
 */


public class GICValue {
    final BaseType _type;
    final Object _value;
    
    
    public GICValue(Object val, BaseType type)
    {
        
        Object realVal = val;
        //TODO: convert to correct bit width
        //if type is an integer
        if(type.type == BaseType.SIGNED || type.type == BaseType.UNSIGNED)
        {
            
            if(type.type == BaseType.SIGNED)
            {
                long tval = (long)val;
                if((tval | (1 << (type.bits-1))) == 0)
                {
                    //TODO: FIX THIS EVENTUALLY....
                }
            }
            
            if(type.bits < 0)
            {
                if(-type.bits <= 32)
                {
                    realVal = (int)val;
                }
                else if(-type.bits <= 64)
                {
                    realVal = (long)val;
                }
                else
                {
                    System.out.println("ERROR: bits too big for system");
                }
            }
            else if(type.bits == 0)
            {
                realVal = (int)val;
            }
            else if(type.bits <= 8)
            {
                realVal = (byte)val;
            }
            else if(type.bits <= 16)
            {
                realVal = (short)val;
            }
            else if(type.bits <= 32)
            {
                realVal = (int)val;
            }
            else if(type.bits <= 64)
            {
                realVal = (long)val;
            }
            else
            {
                System.out.println("ERROR: bits too big for system");
            }
            
            
        }
        
        _type = type;
        _value = realVal;
    }
    
    public byte getAsByte(boolean canDowncast) throws Exception
    {
        if(_value instanceof Byte)
        {
            return (Byte)_value;
        }
        else if(_value instanceof Short && canDowncast)
        {
            return (byte)((short)(Short)_value);
        }
        else if(_value instanceof Integer && canDowncast)
        {
            return (byte)((int)(Integer)_value);
        }
        else if(_value instanceof Long && canDowncast)
        {
            return (byte)((long)(Long)_value);
        }
        else if(_value instanceof Float && canDowncast)
        {
            return (byte)((float)(Float)_value);
        }
        else if(_value instanceof Double && canDowncast)
        {
            return (byte)((double)(Double)_value);
        }
        else 
        {
            throw new Exception("type not accounted for or cannot downcast");
        }
    }
    
    public short getAsShort(boolean canDowncast) throws Exception
    {
        if(_value instanceof Byte)
        {
            return _type.isSigned() ? (short)(Byte)_value : (short)Math.abs((short)(Byte)_value);
        }
        else if(_value instanceof Short)
        {
            return (short)(Short)_value;
        }
        else if(_value instanceof Integer && canDowncast)
        {
            return (short)((int)(Integer)_value);
        }
        else if(_value instanceof Long && canDowncast)
        {
            return (short)((long)(Long)_value);
        }
        else if(_value instanceof Float && canDowncast)
        {
            return (short)((float)(Float)_value);
        }
        else if(_value instanceof Double && canDowncast)
        {
            return (short)((double)(Double)_value);
        }
        else 
        {
            throw new Exception("type not accounted for or cannot downcast");
        }
    }
    
    public int getAsInt(boolean canDowncast) throws Exception
    {
        if(_value instanceof Byte)
        {
            return _type.isSigned() ? (int)(Byte)_value : Math.abs((int)(Byte)_value);
        }
        else if(_value instanceof Short)
        {
            return _type.isSigned() ? (int)(Short)_value : Math.abs((Short)_value);
        }
        else if(_value instanceof Integer)
        {
            return (Integer)_value;
        }
        else if(_value instanceof Long && canDowncast)
        {
            return (int)((long)(Long)_value);
        }
        else if(_value instanceof Float && canDowncast)
        {
            return (int)((float)(Float)_value);
        }
        else if(_value instanceof Double && canDowncast)
        {
            return (int)((double)(Double)_value);
        }
        else 
        {
            throw new Exception("type not accounted for");
        }
    }
    
    public long getAsLong(boolean canDowncast) throws Exception
    {
        if(_value instanceof Byte)
        {
            return _type.isSigned() ? (long)(Byte)_value : Math.abs((long)(Byte)_value);
        }
        else if(_value instanceof Short)
        {
            return _type.isSigned() ? (long)(Short)_value : Math.abs((long)(Short)_value);
        }
        else if(_value instanceof Integer)
        {
            return _type.isSigned() ? (long)(Integer)_value : Math.abs((long)(Integer)_value);
        }
        else if(_value instanceof Long)
        {
            return (long)((long)(Long)_value);
        }
        else if(_value instanceof Float && canDowncast)
        {
            return (long)((float)(Float)_value);
        }
        else if(_value instanceof Double && canDowncast)
        {
            return (long)((double)(Double)_value);
        }
        else 
        {
            throw new Exception("type not accounted for");
        }
    }
    
    public float getAsFloat(boolean canDowncast) throws Exception
    {
        if(_value instanceof Byte)
        {
            return _type.isSigned() ? (float)(Byte)_value : Math.abs((float)(Byte)_value);
        }
        else if(_value instanceof Short)
        {
            return _type.isSigned() ? (float)(Short)_value : Math.abs((float)(Short)_value);
        }
        else if(_value instanceof Integer)
        {
            return _type.isSigned() ? (float)(Integer)_value : Math.abs((float)(Integer)_value);
        }
        else if(_value instanceof Long)
        {
            return _type.isSigned() ? (float)(Long)_value : Math.abs((float)(Long)_value);
        }
        else if(_value instanceof Float)
        {
            return ((float)(Float)_value);
        }
        else if(_value instanceof Double && canDowncast)
        {
            return (float)((double)(Double)_value);
        }
        else 
        {
            throw new Exception("type not accounted for");
        }
    }
    
    public double getAsDouble(boolean canDowncast) throws Exception
    {
        if(_value instanceof Byte)
        {
            return _type.isSigned() ? (double)(Byte)_value : Math.abs((double)(Byte)_value);
        }
        else if(_value instanceof Short)
        {
            return _type.isSigned() ? (double)(Short)_value : Math.abs((double)(Short)_value);
        }
        else if(_value instanceof Integer)
        {
            return _type.isSigned() ? (double)(Integer)_value : Math.abs((double)(Integer)_value);
        }
        else if(_value instanceof Long)
        {
            return _type.isSigned() ? (double)(Long)_value : Math.abs((double)(Long)_value);
        }
        else if(_value instanceof Float)
        {
            return ((float)(Float)_value);
        }
        else if(_value instanceof Double)
        {
            return ((double)(Double)_value);
        }
        else 
        {
            throw new Exception("type not accounted for");
        }
    }
}
