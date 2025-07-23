package org.uade.util;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.dynamic.DynamicMultipleDictionary;

import java.util.Arrays;

public class MultipleDictionaryUtil {
    public static void print(MultipleDictionaryADT dictionary) {
        MultipleDictionaryADT copy = copy(dictionary);

        if (copy.isEmpty()) {
            System.out.println("El diccionario está vacío.");
            return;
        }

        SetADT keys = copy.getKeys();
        System.out.println("Contenido del diccionario:");

        while (!keys.isEmpty()) {
            String key = keys.choose();
            String[] values = dictionary.get(key);
            System.out.print("Clave " + key + ": ");

            if (values.length == 0) {
                System.out.println("Sin valores.");
            } else {
                System.out.println(Arrays.toString(values));
            }

            keys.remove(key);
        }

    }

    public static MultipleDictionaryADT copy(MultipleDictionaryADT dictionary) {

        MultipleDictionaryADT copy = new DynamicMultipleDictionary();
        SetADT keys = dictionary.getKeys();

        while (!keys.isEmpty()) {
            String key = keys.choose();
            String[] values = dictionary.get(key);

            for (String value : values) {
                copy.add(key, value);
            }

            keys.remove(key);
        }

        return copy;
    }

}
