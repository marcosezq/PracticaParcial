package org.uade.structure.implementation.dynamic.extras;

public class NodoDictionary {

    private String key;
    private String valor;
    private NodoDictionary next;

    public NodoDictionary(String key, String valor, NodoDictionary next) {
        this.key = key;
        this.valor = valor;
        this.next = next;
    }

    public String getKey() {
        return key;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public NodoDictionary getSiguiente() {
        return next;
    }

    public void setSiguiente(NodoDictionary next) {
        this.next = next;
    }
}
