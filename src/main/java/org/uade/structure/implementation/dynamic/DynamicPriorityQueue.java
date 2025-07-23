package org.uade.structure.implementation.dynamic;

import org.uade.exception.GeneralException;
import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.implementation.dynamic.extras.NodoPrioridad;

public class DynamicPriorityQueue implements PriorityQueueADT {
    NodoPrioridad primero;

    @Override
    public String getElement() {
        if (isEmpty()) {
            throw new GeneralException("La cola de prioridad está vacía");
        }
        return primero.getValor();
    }

    @Override
    public int getPriority() {
        if (isEmpty()) {
            throw new GeneralException("La cola con prioridad está vacía");
        }
        return primero.getPrioridad();
    }

    @Override
    public void add(String value, int priority) {
        NodoPrioridad nuevo= new NodoPrioridad(value,priority,null);
        if (isEmpty()|| priority< primero.getPrioridad() ) {
            nuevo.setSiguiente(primero);
            primero = nuevo;
        }else{
            NodoPrioridad actual=primero;
            NodoPrioridad siguiente=actual.getSiguiente();
            while(siguiente!=null && siguiente.getPrioridad()<=priority) {
                actual=siguiente;
                siguiente=actual.getSiguiente();
            }
            nuevo.setSiguiente(siguiente);
            actual.setSiguiente(nuevo);

        }
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new GeneralException("La cola de prioridad está vacía, no se puede eliminar");
        }
        primero = primero.getSiguiente();
    }

    @Override
    public boolean isEmpty() {
        return primero == null;
    }
}
