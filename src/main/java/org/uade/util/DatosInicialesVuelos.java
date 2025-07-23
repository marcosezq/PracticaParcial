package org.uade.util;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.implementation.dynamic.*;
import org.uade.structure.definition.GraphADT;

public class DatosInicialesVuelos {

    private static void agregarAeropuerto(GraphADT grafo, DynamicLinkedList lista,
                                          String codigo, String descripcion, String pais) {
        grafo.addVertx(codigo);
        lista.add("Código: " + codigo + ", Descripción: " + descripcion + ", País: " + pais);
    }

    public static void cargarAeropuertos(GraphADT grafo, DynamicLinkedList aeropuertos) {
        agregarAeropuerto(grafo, aeropuertos, "ATL", "Hartsfield-Jackson Atlanta Intl.", "EE.UU.");
        agregarAeropuerto(grafo, aeropuertos, "PEK", "Beijing Capital Intl.", "China");
        agregarAeropuerto(grafo, aeropuertos, "LHR", "London Heathrow", "Reino Unido");
        agregarAeropuerto(grafo, aeropuertos, "CDG", "Charles de Gaulle", "Francia");
        agregarAeropuerto(grafo, aeropuertos, "HND", "Tokyo Haneda", "Japón");
        agregarAeropuerto(grafo, aeropuertos, "DXB", "Dubai Intl.", "Emiratos Árabes Unidos");
        agregarAeropuerto(grafo, aeropuertos, "LAX", "Los Angeles Intl.", "EE.UU.");
        agregarAeropuerto(grafo, aeropuertos, "SIN", "Singapore Changi", "Singapur");
        agregarAeropuerto(grafo, aeropuertos, "FRA", "Frankfurt am Main", "Alemania");
        agregarAeropuerto(grafo, aeropuertos, "AMS", "Amsterdam Schiphol", "Países Bajos");
        agregarAeropuerto(grafo, aeropuertos, "GRU", "São Paulo/Guarulhos", "Brasil");
        agregarAeropuerto(grafo, aeropuertos, "SYD", "Sydney Kingsford Smith", "Australia");
        agregarAeropuerto(grafo, aeropuertos, "JFK", "John F. Kennedy", "EE.UU.");
        agregarAeropuerto(grafo, aeropuertos, "EZE", "Ministro Pistarini Intl.", "Argentina");
        agregarAeropuerto(grafo, aeropuertos, "MEX", "Benito Juárez Intl.", "México");
    }

    public static void cargarConexiones(GraphADT grafo) {
        agregarConexion(grafo, "EZE", "JFK"); // Argentina -> EE.UU. (Internacional)
        agregarConexion(grafo, "JFK", "LHR"); // EE.UU. -> Reino Unido (Internacional)
        agregarConexion(grafo, "LHR", "CDG"); // Reino Unido -> Francia (Internacional)
        agregarConexion(grafo, "ATL", "LAX"); // EE.UU. (Nacional)
        agregarConexion(grafo, "LAX", "SYD"); // EE.UU. -> Australia (Internacional)
        agregarConexion(grafo, "SYD", "SIN"); // Australia -> Singapur (Internacional)
        agregarConexion(grafo, "SIN", "PEK"); // Singapur -> China (Internacional)
        agregarConexion(grafo, "PEK", "HND"); // China -> Japón (Internacional)
        agregarConexion(grafo, "GRU", "EZE"); // Brasil -> Argentina (Internacional)
        agregarConexion(grafo, "MEX", "ATL"); // México -> EE.UU. (Internacional)
        agregarConexion(grafo, "DXB", "FRA"); // EAU -> Alemania (Internacional)
        agregarConexion(grafo, "AMS", "FRA"); // Países Bajos -> Alemania (Internacional)
        agregarConexion(grafo, "CDG", "AMS"); // Francia -> Países Bajos (Internacional)
    }

    private static void agregarConexion(GraphADT grafo, String origen, String destino) {
        if (!grafo.existsEdge(origen, destino)) {
            grafo.addEdge(origen, destino, "1"); // el peso no importa mucho acá
        }
    }


    public static DynamicMultipleDictionary cargarFlotaAviones() {
        DynamicMultipleDictionary flota = new DynamicMultipleDictionary();

        for (int i = 1; i <= 10; i++) {
            String matricula = "AV" + String.format("%03d", i);
            flota.add(matricula, "Tipo" + ((i % 3) + 1));   // Tipo1, Tipo2, Tipo3
            flota.add(matricula, "true");                  // Disponible
            flota.add(matricula, "0");                     // Asignaciones
        }

        return flota;
    }

    public static PriorityQueueADT cargarVuelos() {
        PriorityQueueADT cola = new DynamicPriorityQueue();
        for (int i = 1; i <= 50; i++) {
            String tipo;
            int prioridad;

            if (i % 3 == 0) {
                tipo = "internacional";
                prioridad = 1;
            } else if (i % 3 == 1) {
                tipo = "carga";
                prioridad = 2;
            } else {
                tipo = "nacional";
                prioridad = 3;
            }

            String vuelo = "Vuelo:V" + i + ",Tipo:" + tipo;
            cola.add(vuelo, prioridad);
        }
        return cola;
    }
}
