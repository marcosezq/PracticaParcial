package org.uade.structure.implementation.dynamic;

import org.uade.exception.EmptyQueueException;
import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.dynamic.extras.Nodo;

public class DynamicQueue implements QueueADT {

    private Nodo primero;
    private Nodo ultimo;

    @Override
    public String getElement() {
        if (isEmpty()) {
            throw new EmptyQueueException("La cola está vacía, no se puede obtener el primer elemento");
        }
        return primero.getValor();
    }

    @Override
    public void add(String value) {
        Nodo nuevo = new Nodo(value, null);
        if (isEmpty()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new EmptyQueueException("La cola está vacía, no se puede eliminar");
        }
        primero = primero.getSiguiente();
        if (primero == null) {
            ultimo = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return primero == null;
    }
}
