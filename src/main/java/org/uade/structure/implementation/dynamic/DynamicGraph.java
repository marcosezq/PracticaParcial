package org.uade.structure.implementation.dynamic;

import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.dynamic.extras.NodoArista;
import org.uade.structure.implementation.dynamic.extras.NodoGrafo;

public class DynamicGraph implements GraphADT {

    private NodoGrafo head;

    @Override
    public SetADT getVertxs() {
        SetADT result = new DynamicSet();
        NodoGrafo aux = head;
        while (aux != null) {
            result.add(aux.getNodo());
            aux = aux.getSigNodo();
        }
        return result;
    }

    @Override
    public void addVertx(String vertex) {
        NodoGrafo aux = head;
        while (aux != null) {
            if (aux.getNodo().equals(vertex)) {
                return;
            }
            aux = aux.getSigNodo();
        }
        head = new NodoGrafo(vertex, null, head);
    }

    @Override
    public void removeVertx(String vertex) {
        if (isEmpty()) return;

        if (head.getNodo() == vertex) {
            head = head.getSigNodo();
        } else {
            NodoGrafo aux = head;
            while (aux.getSigNodo() != null && aux.getSigNodo().getNodo() != vertex) {
                aux = aux.getSigNodo();
            }
            if (aux.getSigNodo() == null) return;
            aux.setSigNodo(aux.getSigNodo().getSigNodo());
        }

        NodoGrafo v = head;
        while (v != null) {
            removeEdge(v.getNodo(), vertex);
            v = v.getSigNodo();
        }
    }

    @Override
    public void addEdge(String vertxOne, String vertxTwo, String weight) {
        NodoGrafo origen = head;
        NodoGrafo destino = head;

        while (origen != null && origen.getNodo() != vertxOne) {
            origen = origen.getSigNodo();
        }
        while (destino != null && destino.getNodo() != vertxTwo) {
            destino = destino.getSigNodo();
        }

        if (origen == null || destino == null) return;

        if (existsEdge(vertxOne, vertxTwo)) {
            NodoArista arista = origen.getArista();
            while (arista != null) {
                if (arista.getNodoDestino().getNodo() == vertxTwo) {
                    arista.setEtiqueta(weight);
                    return;
                }
                arista = arista.getSigArista();
            }
        } else {
            origen.setArista(new NodoArista(weight, destino, origen.getArista()));
        }
    }

    @Override
    public void removeEdge(String vertxOne, String vertxTwo) {
        NodoGrafo origen = head;
        while (origen != null && origen.getNodo() != vertxOne) {
            origen = origen.getSigNodo();
        }

        if (origen == null || origen.getArista() == null) return;

        NodoArista arista = origen.getArista();
        if (arista.getNodoDestino().getNodo() == vertxTwo) {
            origen.setArista(arista.getSigArista());
        } else {
            NodoArista prev = arista;
            while (prev.getSigArista() != null) {
                if (prev.getSigArista().getNodoDestino().getNodo() == vertxTwo) {
                    prev.setSigArista(prev.getSigArista().getSigArista());
                    return;
                }
                prev = prev.getSigArista();
            }
        }
    }

    @Override
    public boolean existsEdge(String vertxOne, String vertxTwo) {
        NodoGrafo origen = head;
        while (origen != null && origen.getNodo() != vertxOne) {
            origen = origen.getSigNodo();
        }

        if (origen == null) return false;

        NodoArista arista = origen.getArista();
        while (arista != null) {
            if (arista.getNodoDestino().getNodo() == vertxTwo) {
                return true;
            }
            arista = arista.getSigArista();
        }
        return false;
    }

    @Override
    public String edgeWeight(String vertxOne, String vertxTwo) {
        NodoGrafo origen = head;
        while (origen != null && !origen.getNodo().equals(vertxOne)) {
            origen = origen.getSigNodo();
        }

        if (origen == null) return null;

        NodoArista arista = origen.getArista();
        while (arista != null) {
            if (arista.getNodoDestino().getNodo().equals(vertxTwo)) {
                return arista.getEtiqueta();
            }
            arista = arista.getSigArista();
        }

        return null;
    }


    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
