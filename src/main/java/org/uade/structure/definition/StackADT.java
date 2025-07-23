package org.uade.structure.definition;

// Esta interfaz representa el TDA Pila.
public interface StackADT {

    /**
     * Descripción: Devuelve el último elemento de la estructura.
     * Precondición: La estructura debe tener elementos.
     */
    String getElement();

    /**
     * Descripción: Agrega un elemento a la pila.
     * Precondición: La estructura no debe sobrepasar la capacidad.
     */
    void add(String value);

    /**
     * Descripción: Elimina el último elemento que existe (desapila).
     * Precondición: La estructura debe tener elementos.
     */
    void remove();

    /**
     * Descripción: Verifica si la pila está vacía.
     * Precondición: No tiene.
     */
    boolean isEmpty();
}
