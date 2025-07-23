package org.uade.structure.implementation.dynamic.extras;

public class NodoArista {
    private String etiqueta;
    private NodoGrafo nodoDestino;
    private NodoArista sigArista;

    public NodoArista(String etiqueta, NodoGrafo nodoDestino, NodoArista sigArista) {
        this.etiqueta = etiqueta;
        this.nodoDestino = nodoDestino;
        this.sigArista = sigArista;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public NodoGrafo getNodoDestino() {
        return nodoDestino;
    }

    public NodoArista getSigArista() {
        return sigArista;
    }

    public void setSigArista(NodoArista sigArista) {
        this.sigArista = sigArista;
    }
}
