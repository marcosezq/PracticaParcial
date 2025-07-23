package org.uade.util;

import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.dynamic.DynamicSet;

public class SetUtil {

    public static SetADT copy(SetADT original) {
        SetADT aux=new DynamicSet();
        SetADT copy=new DynamicSet();

        while(!original.isEmpty()){
            String elemento= original.choose();
            aux.add(elemento);
            copy.add(elemento);
            original.remove(elemento);
        }

        while(!aux.isEmpty()){
            String elemento= aux.choose();
            original.add(elemento);
            aux.remove(elemento);
        }

        return copy;
    }

    public static void print(SetADT set){
        SetADT aux= SetUtil.copy(set);
        while(!aux.isEmpty()){
            String elemento= aux.choose();
            System.out.print(elemento+" ");
            aux.remove(elemento);

        }


    }

}
