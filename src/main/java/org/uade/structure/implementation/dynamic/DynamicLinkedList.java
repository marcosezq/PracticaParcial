package org.uade.structure.implementation.dynamic;

import org.uade.exception.EmptyListException;
import org.uade.exception.InvalidIndexException;
import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.dynamic.extras.Nodo;

public class DynamicLinkedList implements LinkedListADT {

    private Nodo head;
    private int size;

    @Override
    public void add(String value) {
        Nodo nuevo = new Nodo(value, null);
        if (head == null) {
            head = nuevo;
        } else {
            Nodo aux = head;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        size++;
    }

    @Override
    public void insert(int index, String value) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException("El índice se encuentra fuera de rango");
        }

        Nodo nuevo = new Nodo(value, null);

        if (index == 0) {
            nuevo.setSiguiente(head);
            head = nuevo;
        } else {
            Nodo aux = head;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (isEmpty()) {
            throw new EmptyListException("La lista está vacía");
        }

        if (index < 0 || index >= size) {
            throw new InvalidIndexException("El índice se encuentra fuera de rango");
        }

        if (index == 0) {
            head = head.getSiguiente();
        } else {
            Nodo aux = head;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getSiguiente();
            }
            Nodo eliminado = aux.getSiguiente();
            aux.setSiguiente(eliminado.getSiguiente());
        }
        size--;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException("El índice se encuentra fuera de rango");
        }

        Nodo aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.getSiguiente();
        }

        return aux.getValor();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
