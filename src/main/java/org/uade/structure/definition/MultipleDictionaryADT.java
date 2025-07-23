package org.uade.structure.definition;

// Esta interfaz representa el TDA Diccionario Multiple.
public interface MultipleDictionaryADT {

    /**
     * Descripcion: Agrega un elemento a la estructura. Precondición: No tiene, acepta valores duplicados.
     */
    void add(String key, String value);

    /**
     * Descripcion: Elimina el elemento de la estructura, si no existe no hace nada. Precondición: La estructura debe
     * tener elementos.
     */
    void remove(String key);

    /**
     * Descripcion: Devuelve el valor de una clave. Precondición: La estructura debe tener elementos y la clave debe
     * existir.
     */
    String[] get(String key);

    /**
     * Descripcion: Retorna el conjunto de claves. Precondición: No tiene.
     */
    SetADT getKeys();

    /**
     * Descripcion: Debe comprobar si la estructura tiene o no valores. Precondición: No tiene.
     */
    boolean isEmpty();

    /**
     * Descripcion: Elimina el elemento de la estructura, si no existe no hace nada. Precondición: La estructura debe
     * tener elementos y deben existir.
     */
    void remove(String key, String value);
}