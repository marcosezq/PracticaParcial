package org.uade.util;

import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.implementation.dynamic.DynamicQueue;
import org.uade.structure.implementation.dynamic.DynamicSimpleDictionary;

public class SimpleDictionaryUtil {

    public static void print(SimpleDictionaryADT dictionary) {
        SetADT keys = dictionary.getKeys();
        while (!keys.isEmpty()) {
            String key = keys.choose();
            System.out.println(key + "\t" + dictionary.get(key));
            keys.remove(key);
        }
    }

    public static SimpleDictionaryADT copy(SimpleDictionaryADT dictionary) {
        SimpleDictionaryADT aux = new DynamicSimpleDictionary();

        SetADT keys = dictionary.getKeys();
        SetADT tempKeys = SetUtil.copy(keys);

        while (!tempKeys.isEmpty()) {
            String key = tempKeys.choose();
            tempKeys.remove(key);
            String value = dictionary.get(key);
            aux.add(key, value);
        }

        return aux;
    }



}
