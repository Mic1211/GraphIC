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
public interface RunnableNode {
    public ArrayList<GICValue> execute(ArrayList<GICValue> inputs);
}
