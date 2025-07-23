package org.uade.util;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.dynamic.DynamicStack;

public class StackUtil {
    public static StackADT copy(StackADT stack){
        StackADT temp= new DynamicStack();
        StackADT result= new DynamicStack();

        while(!stack.isEmpty()){
            temp.add(stack.getElement());
            stack.remove();
        }

        while (!temp.isEmpty()){
            stack.add(temp.getElement());
            result.add(temp.getElement());
            temp.remove();
        }
         return result;
    }

    public static void print(StackADT stack){
        StackADT aux= copy(stack);
        while(!aux.isEmpty()){
            System.out.println(aux.getElement());
            aux.remove();
        }

    }

}
