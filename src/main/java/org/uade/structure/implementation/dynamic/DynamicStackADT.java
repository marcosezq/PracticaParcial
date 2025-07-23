package org.uade.structure.implementation.dynamic;

import org.uade.exception.GeneralException;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.dynamic.extras.Nodo;

public class DynamicStackADT implements StackADT {

    private Nodo cima;

    @Override
    public String getElement() {
        if (cima == null){
            throw new GeneralException("La  Pila esta vacia");
        }
        return cima.getValor();
    }

    @Override
    public void add(String value) {
        Nodo nuevoNodo= new Nodo(value,null);
        nuevoNodo.setSiguiente(cima);
        cima=nuevoNodo;

    }

    @Override
    public void remove() {
        if (cima != null) {
            cima = cima.getSiguiente();
        }
    }

    @Override
    public boolean isEmpty() {
        return cima==null;
    }
}
