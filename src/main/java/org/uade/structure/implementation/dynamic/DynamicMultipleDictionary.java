package org.uade.structure.implementation.dynamic;

import org.uade.exception.EmptyDictionaryException;
import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.dynamic.extras.NodoMultiple;

public class DynamicMultipleDictionary implements MultipleDictionaryADT {
    private NodoMultiple head;
    private int size;

    @Override
    public void add(String key, String value) {
        NodoMultiple aux = head;
        while (aux != null) {
            if (aux.getKey().equals(key)) {
                aux.getValor().add(value);
                size++;
                return;
            }
            aux = aux.getSiguiente();
        }

        LinkedListADT lista = new DynamicLinkedList(); // Asume que acepta String
        lista.add(value);
        head = new NodoMultiple(key, lista, head);
        size++;
    }

    @Override
    public void remove(String key) {
        if (isEmpty()) {
            throw new EmptyDictionaryException("El diccionario está vacío, no se puede eliminar");
        }

        if (head.getKey().equals(key)) {
            head = head.getSiguiente();
            size--;
            return;
        }

        NodoMultiple aux = head;
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getKey().equals(key)) {
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                size--;
                return;
            }
            aux = aux.getSiguiente();
        }
    }

    @Override
    public String[] get(String key) {
        if (isEmpty()) {
            throw new EmptyDictionaryException("El diccionario está vacío, no se puede obtener el elemento");
        }

        NodoMultiple aux = head;
        while (aux != null) {
            if (aux.getKey().equals(key)) {
                LinkedListADT lista = aux.getValor();
                String[] result = new String[lista.size()];
                for (int i = 0; i < lista.size(); i++) {
                    result[i] = lista.get(i);
                }
                return result;
            }
            aux = aux.getSiguiente();
        }

        throw new EmptyDictionaryException("La clave " + key + " no fue encontrada en el diccionario");
    }

    @Override
    public SetADT getKeys() {
        SetADT keys = new DynamicSet(); // Asegurate que acepte String
        NodoMultiple aux = head;
        while (aux != null) {
            keys.add(aux.getKey());
            aux = aux.getSiguiente();
        }
        return keys;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void remove(String key, String value) {
        NodoMultiple aux = head;
        while (aux != null) {
            if (aux.getKey().equals(key)) {
                LinkedListADT lista = aux.getValor();
                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).equals(value)) {
                        lista.remove(i);
                        size--;
                        return;
                    }
                }
            }
            aux = aux.getSiguiente();
        }
    }
}
