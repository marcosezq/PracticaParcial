package org.uade.structure.implementation.fixed;

import org.uade.exception.EmptyQueueException;
import org.uade.structure.definition.QueueADT;

public class StaticQueue implements QueueADT {

    private final String[] data = new String[100];
    private int primero = 0;
    private int ultimo = -1;
    private int size = 0;

    @Override
    public String getElement() {
        if (isEmpty()) {
            throw new EmptyQueueException("La cola está vacía, no se puede traer");
        }
        return data[primero];
    }

    @Override
    public void add(String value) {
        if (size == data.length) {
            throw new RuntimeException("La cola está llena");
        }
        ultimo = (ultimo + 1) % data.length;
        data[ultimo] = value;
        size++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new EmptyQueueException("La cola está vacía, no se puede eliminar");
        }
        primero = (primero + 1) % data.length;
        size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
