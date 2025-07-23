package org.uade.structure.implementation.dynamic.extras;

public class Nodo {

    public String value;
    private Nodo next;

    public Nodo(String value, Nodo next) {
        this.value = value;
        this.next = next;
    }

    public String getValor() {

        return value;
    }

    public Nodo getSiguiente() {

        return next;
    }

    public void setSiguiente(Nodo next) {

        this.next = next;
    }
}