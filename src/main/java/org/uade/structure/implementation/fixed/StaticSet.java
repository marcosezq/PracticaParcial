package org.uade.structure.implementation.fixed;

import org.uade.structure.definition.SetADT;

public class StaticSet implements SetADT {
    private final String[] data = new String[100];
    private int size = 0;

    @Override
    public boolean exist(String value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String choose() {
        if (isEmpty()) {
            throw new RuntimeException("El conjunto está vacío, no se puede elegir un elemento");
        }
        return data[0]; // o podrías usar Math.random() para elegir uno aleatorio
    }

    @Override
    public void add(String value) {
        if (!exist(value)) {
            if (size == data.length) {
                throw new RuntimeException("El conjunto está lleno, no se pueden agregar más elementos");
            }
            data[size++] = value;
        }
    }

    @Override
    public void remove(String element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                data[i] = data[size - 1]; // reemplaza con el último para mantener continuidad
                size--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
