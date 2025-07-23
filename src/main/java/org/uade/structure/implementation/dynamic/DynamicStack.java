package org.uade.structure.implementation.dynamic;

import org.uade.exception.EmptyStackException;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.dynamic.extras.Nodo;

public class DynamicStack implements StackADT {

    private Nodo top;

    @Override
    public String getElement() {
        if (isEmpty()) {
            throw new EmptyStackException("La pila está vacía");
        }
        return top.getValor();
    }

    @Override
    public void add(String value) {
        Nodo nuevo = new Nodo(value, null);
        nuevo.setSiguiente(top);
        top = nuevo;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new EmptyStackException("La pila está vacía, no se puede eliminar");
        }
        top = top.getSiguiente();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}
