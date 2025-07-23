package org.uade.util;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.dynamic.DynamicLinkedList;

public class LinkedListUtil {
    public static void print(LinkedListADT lista) {
        if (lista.isEmpty()==true){
            System.out.println("[]");
        }else {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i));
            }

        }

    }

    public static LinkedListADT copy(LinkedListADT original) {
        DynamicLinkedList copia = new DynamicLinkedList();

        for (int i = 0; i < original.size(); i++) {
            String valor = original.get(i);
            copia.add(valor);
        }

        return copia;
    }
}
