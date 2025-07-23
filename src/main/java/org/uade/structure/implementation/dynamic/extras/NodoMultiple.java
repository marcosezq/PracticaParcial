package org.uade.structure.implementation.dynamic.extras;

import org.uade.structure.definition.LinkedListADT;

public class NodoMultiple {
    private String key;
    private LinkedListADT values;
    private NodoMultiple next;

    public NodoMultiple(String key, LinkedListADT values, NodoMultiple next) {
        this.key = key;
        this.values = values;
        this.next = next;
    }

    public String getKey() {
        return key;
    }

    public LinkedListADT getValor() {
        return values;
    }

    public NodoMultiple getSiguiente() {
        return next;
    }

    public void setSiguiente(NodoMultiple next) {
        this.next = next;
    }
}
