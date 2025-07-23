package org.uade.structure.implementation.fixed;

import org.uade.structure.definition.StackADT;
import org.uade.exception.EmptyStackException;

public class StaticStack implements StackADT {

    private final String[] data = new String[100];
    private int top = -1;

    @Override
    public String getElement() {
        if (isEmpty()) {
            throw new EmptyStackException("La pila está vacía");
        }
        return data[top];
    }

    @Override
    public void add(String value) {
        if (top == data.length - 1) {
            throw new RuntimeException("La pila está llena");
        }
        top++;
        data[top] = value;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new EmptyStackException("La pila está vacía, no se puede eliminar");
        }
        top--;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}
