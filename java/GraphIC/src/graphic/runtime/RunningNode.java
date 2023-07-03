/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic.runtime;

import java.util.ArrayList;

/**
 *
 * @author mic12
 */
public class RunningNode {
    CompiledNode n;
    //are inputs and outputs mapped somewhere in registers????
    ArrayList<GICValue> registers;
}
