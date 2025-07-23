package org.uade.structure.implementation.dynamic;

import org.uade.exception.EmptyDictionaryException;
import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.implementation.dynamic.extras.NodoDictionary;

public class DynamicSimpleDictionary implements SimpleDictionaryADT {

    private NodoDictionary head;
    private int size;

    @Override
    public void add(String key, String value) {
        NodoDictionary aux = head;
        while (aux != null) {
            if (aux.getKey().equals(key)) {
                aux.setValor(value);
                return;
            }
            aux = aux.getSiguiente();
        }

        head = new NodoDictionary(key, value, head);
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

        NodoDictionary aux = head;
        while (aux.getSiguiente() != null) {
            NodoDictionary next = aux.getSiguiente();
            if (next.getKey().equals(key)) {
                aux.setSiguiente(next.getSiguiente());
                size--;
                return;
            }
            aux = aux.getSiguiente();
        }
    }

    @Override
    public String get(String key) {
        if (isEmpty()) {
            throw new EmptyDictionaryException("El diccionario está vacío, no se puede obtener el elemento");
        }

        NodoDictionary aux = head;
        while (aux != null) {
            if (aux.getKey().equals(key)) {
                return aux.getValor();
            }
            aux = aux.getSiguiente();
        }

        throw new EmptyDictionaryException("La clave " + key + " no fue encontrada en el diccionario");
    }

    @Override
    public SetADT getKeys() {
        SetADT keys = new DynamicSet(); // Asegurate de usar la versión que recibe String
        NodoDictionary aux = head;
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
}
