package org.uade.structure.implementation.dynamic.extras;

public class NodoPriority {
    private int value;
    private int priority;
    private NodoPriority next;

    public NodoPriority(int value, int priority, NodoPriority next) {
        this.value = value;
        this.priority = priority;
        this.next = next;
    }
    public int getValor() {
        return value;
    }
    public int getPrioridad() {
        return priority;
    }
    public NodoPriority getSiguiente() {
        return next;
    }
    public void setSiguiente(NodoPriority next) {
        this.next = next;
    }

}
