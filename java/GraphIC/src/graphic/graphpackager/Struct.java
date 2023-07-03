/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic.graphpackager;

import java.util.ArrayList;

/**
 *
 * @author mic12
 */
//how should sub structs be treated? as substructs or built in to the main struct?
//if built as sub structs, it's more flexible, if built into main struct it's not flexible
//I think it should allow sub structs/arrays?

//To access structs or arrays, you use ACCESS[STRUCTTYPE](ptr,.....) where the other inputs are the various pieces needed to get to there on the pointer
public class Struct extends Type{
    ArrayList<Type> members;
}
