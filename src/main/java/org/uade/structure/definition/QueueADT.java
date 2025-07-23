package org.uade.structure.definition;

// Esta interfaz representa el TDA Cola.
public interface QueueADT {

    /**
     * Descripción: Devuelve el primer elemento de la estructura.
     * Precondición: La estructura debe tener elementos.
     */
    String getElement();

    /**
     * Descripción: Agrega un elemento al final de la estructura.
     * Precondición: La estructura no debe sobrepasar la capacidad.
     */
    void add(String value);

    /**
     * Descripción: Elimina el primer elemento que existe.
     * Precondición: La estructura debe tener elementos.
     */
    void remove();

    /**
     * Descripción: Verifica si la cola está vacía.
     * Precondición: No tiene.
     */
    boolean isEmpty();
}
