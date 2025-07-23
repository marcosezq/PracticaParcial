package org.uade.structure.implementation.dynamic.extras;

public class NodoPrioridad {
    private String valor;
    private int prioridad;
    private NodoPrioridad siguiente;

    public NodoPrioridad(String valor, int prioridad, NodoPrioridad siguiente) {
        this.valor = valor;
        this.prioridad = prioridad;
        this.siguiente = siguiente;
    }

    public String getValor() {
        return valor;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public NodoPrioridad getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPrioridad siguiente) {
        this.siguiente = siguiente;
    }
}

