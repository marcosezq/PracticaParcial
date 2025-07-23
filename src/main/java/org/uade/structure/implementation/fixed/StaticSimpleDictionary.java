package org.uade.structure.implementation.fixed;

import org.uade.exception.EmptyDictionaryException;
import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;

public class StaticSimpleDictionary implements SimpleDictionaryADT {

    private final String[] keys = new String[100];
    private final String[] values = new String[100];
    private int size = 0;

    @Override
    public void add(String key, String value) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        if (size == keys.length) {
            throw new RuntimeException("El diccionario está lleno");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public void remove(String key) {
        if (isEmpty()) {
            throw new EmptyDictionaryException("El diccionario está vacío, no se puede eliminar");
        }
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                // Reemplazo por el último
                keys[i] = keys[size - 1];
                values[i] = values[size - 1];
                size--;
                return;
            }
        }
        throw new EmptyDictionaryException("Clave no encontrada para eliminar: " + key);
    }

    @Override
    public String get(String key) {
        if (isEmpty()) {
            throw new EmptyDictionaryException("El diccionario está vacío");
        }
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        throw new EmptyDictionaryException("Clave no encontrada: " + key);
    }

    @Override
    public SetADT getKeys() {
        SetADT set = new StaticSet(); // Ya lo adaptamos a String
        for (int i = 0; i < size; i++) {
            set.add(keys[i]);
        }
        return set;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
