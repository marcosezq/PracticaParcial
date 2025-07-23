package org.uade.structure.implementation.dynamic;

import org.uade.exception.EmptySetException;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.dynamic.extras.Nodo;

import java.util.Random;

public class DynamicSet implements SetADT {
    private Nodo head;
    private int size;

    @Override
    public boolean exist(String value) {
        Nodo aux = head;
        while (aux != null) {
            if (aux.getValor().equals(value)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String choose() {
        if (isEmpty()) {
            throw new EmptySetException("El conjunto está vacío, no se puede elegir un elemento");
        }
        Random rand = new Random();
        int index = rand.nextInt(size);
        Nodo aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.getSiguiente();
        }
        return aux.getValor();
    }

    @Override
    public void add(String value) {
        if (!exist(value)) {
            Nodo nuevo = new Nodo(value, head);
            head = nuevo;
            size++;
        }
    }

    @Override
    public void remove(String element) {
        if (isEmpty()) {
            throw new EmptySetException("No se puede eliminar, el conjunto está vacío");
        }

        if (head.getValor().equals(element)) {
            head = head.getSiguiente();
            size--;
            return;
        }

        Nodo aux = head;
        while (aux.getSiguiente() != null) {
            Nodo next = aux.getSiguiente();
            if (next.getValor().equals(element)) {
                aux.setSiguiente(next.getSiguiente());
                size--;
                return;
            }
            aux = aux.getSiguiente();
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
