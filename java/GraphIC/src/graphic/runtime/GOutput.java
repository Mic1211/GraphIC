/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic.runtime;

import graphic.graphpackager.BaseType;
import java.util.ArrayList;

/**
 *
 * @author mic12
 */
public class GOutput {
    private GNumber _num;
    BaseType _typ;
    //boolean allowDowncast;
    boolean _isWritten = false;
    public static boolean is64; 
    
    public GNumber getNum()
    {
        return _num;
    }
    
    public void setNum(GNumber num)
    {
        if(_isWritten)
            throw new UnsupportedOperationException("Cannot Assign an output more than once");
        else
        {
            _isWritten = true;
            _num = num;
        }
    }
    
    public GOutput(BaseType typ)
    {
        //take care of integers
        if(typ.type == BaseType.SIGNED || typ.type == BaseType.UNSIGNED)
        {
            if(typ.bits < -64)
            {
                throw new UnsupportedOperationException("Numbers larger than 64 bits not supported by this interpreter.");
            }
            else if(typ.bits < -32)
            {
                _num = new GLong(0, typ.isSigned());
            }
            else if(typ.bits < 0)
            {
                if(is64)
                {
                    _num = new GLong(0, typ.isSigned());
                }
                else
                {
                    _num = new GInt(0, typ.isSigned());
                }
            }
            else if(typ.bits == 0)
            {
                //this is the default type for the system, 8 or 16 bit systems will usually use 16 bit but 8 bit may choose to use 8, use carfully :) 32 bit will of course use 32 bit and 64 bit: 64 bits
                //for this interpreter we can test how different types affect the system
                if(is64)
                {
                    _num = new GLong(0, typ.isSigned());
                }
                else
                {
                    _num = new GInt(0, typ.isSigned());
                }
            }
            else if(typ.bits <= 8)
            {
                _num = new GByte((byte)0, typ.isSigned());
            }
            else if(typ.bits <= 16)
            {
                _num = new GShort((byte)0, typ.isSigned());
            }
            else if(typ.bits <= 32)
            {
                _num = new GInt(0, typ.isSigned());
            }
            else if(typ.bits <= 64)
            {
                _num = new GLong(0, typ.isSigned());
            }
            else
            {
                throw new UnsupportedOperationException("Numbers larger than 64 bits not supported by this interpreter.");
            }
        }
        //take care of floats
        else if(typ.type == BaseType.FLOAT)
        {
            if(typ.bits < -64)
            {
                throw new UnsupportedOperationException("Floats larger than 64 bits not supported by this interpreter.");
            }
            else if(typ.bits < -32)
            {
                _num = new GDouble(0);
            }
            else if(typ.bits < 0)
            {
                if(is64)
                {
                    _num = new GDouble(0);
                }
                else
                {
                    _num = new GFloat(0);
                }
            }
            else if(typ.bits == 0)
            {
                if(is64)
                {
                    _num = new GDouble(0);
                }
                else
                {
                    _num = new GFloat(0);
                }
            }
            else if(typ.bits <= 32)
            {
                _num = new GFloat(0);
            }
            else if(typ.bits <= 64)
            {
                _num = new GFloat(0);
            }
            else
            {
                throw new UnsupportedOperationException("Floats larger than 64 bits not supported by this interpreter.");
            }
        }
        //take care of pointers
        else if(typ.type == BaseType.POINTER)
        {
            //all pointers are the same length on a system
            if(is64)
            {
                _num = new GLong(0, false);
            }
            else
            {
                _num = new GInt(0, false);
            }
        }
    }
    
    public static ArrayList<GOutput> createFromTypes(ArrayList<BaseType> types)
    {
        ArrayList<GOutput> outs = new ArrayList<>(types.size());
        
        for(int t = 0; t < types.size(); t++)
        {
            outs.add(new GOutput(types.get(t)));
            
        }
        
        return outs;
    }
}
