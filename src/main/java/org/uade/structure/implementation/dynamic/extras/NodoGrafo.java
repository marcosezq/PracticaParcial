package org.uade.structure.implementation.dynamic.extras;

public class NodoGrafo {
    private String nodo;
    private NodoArista arista;
    private NodoGrafo sigNodo;

    public NodoGrafo(String nodo, NodoArista arista, NodoGrafo sigNodo) {
        this.nodo = nodo;
        this.arista = arista;
        this.sigNodo = sigNodo;
    }

    public String getNodo() {
        return nodo;
    }

    public NodoArista getArista() {
        return arista;
    }

    public void setArista(NodoArista arista) {
        this.arista = arista;
    }

    public NodoGrafo getSigNodo() {
        return sigNodo;
    }

    public void setSigNodo(NodoGrafo sigNodo) {
        this.sigNodo = sigNodo;
    }
}