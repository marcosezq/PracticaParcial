package org.uade.util;

import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.dynamic.DynamicGraph;

public class GraphUtil {
    public static void print(GraphADT graph) {
        GraphADT copy = copy(graph);
        SetADT vertices = copy.getVertxs();

        while (!vertices.isEmpty()) {
            String vertex = vertices.choose();

            System.out.print("Vértice " + vertex + " tiene las siguientes aristas: ");

            SetADT allVertices = copy.getVertxs();
            boolean hasEdges = false;

            while (!allVertices.isEmpty()) {
                String otherVertex = allVertices.choose();
                if (copy.existsEdge(vertex, otherVertex)) {
                    System.out.print(otherVertex + " ");
                    hasEdges = true;
                }
                allVertices.remove(otherVertex);
            }

            if (!hasEdges) {
                System.out.print("ninguna");
            }

            System.out.println();
            vertices.remove(vertex);
        }
    }

    public static GraphADT copy(GraphADT graph) {
        GraphADT aux = new DynamicGraph();

        SetADT vertices = SetUtil.copy(graph.getVertxs());
        while (!vertices.isEmpty()) {
            String vertex = vertices.choose();
            aux.addVertx(vertex);
            vertices.remove(vertex);
        }

        vertices = graph.getVertxs();
        while (!vertices.isEmpty()) {
            String vertex = vertices.choose();
            SetADT adjacentVertices = graph.getVertxs();

            while (!adjacentVertices.isEmpty()) {
                String adjacentVertex = adjacentVertices.choose();
                if (graph.existsEdge(vertex, adjacentVertex)) {
                    String weight = graph.edgeWeight(vertex, adjacentVertex);
                    aux.addEdge(vertex, adjacentVertex, weight);
                }
                adjacentVertices.remove(adjacentVertex);
            }
            vertices.remove(vertex);
        }

        return aux;
    }

}
