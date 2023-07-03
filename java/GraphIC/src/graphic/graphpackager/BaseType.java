/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic.graphpackager;

/**
 *
 * @author mic12
 */
public class BaseType extends Type {
    public static int UNSIGNED = 0;
    public static int SIGNED = 1;
    public static int FLOAT = 2;
    public static int POINTER = 3;
    
    
    public int type;
    public int bits;   //-1 means undefined until compiled(if on integer type its default integer size, same for float, same for pointer)
                //-number of other size mean undefined but the fastest size that is at least nbits where -1 is smallest size
                //normal for pointers, and usually floats too, unless the upper lang require a specific number of bytes...

    public boolean isSigned()
    {
        return type != UNSIGNED && type != POINTER;
    }
    
    @Override
    public boolean equals(Object other)
    {
        if(other instanceof BaseType)
        {
            return (this.type == ((BaseType) other).type && this.bits == ((BaseType) other).bits);
        }
        return false;
    }
}
