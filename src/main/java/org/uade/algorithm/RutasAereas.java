package org.uade.algorithm;

import org.uade.exception.EmptyDictionaryException;
import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.dynamic.*;
import org.uade.util.LinkedListUtil;
import org.uade.util.SetUtil;

import java.util.Scanner;

public class RutasAereas {

    private static final GraphADT grafo = new DynamicGraph();
    private static final LinkedListADT aeropuertos = new DynamicLinkedList();
    private static final DynamicMultipleDictionary flotaAviones = new DynamicMultipleDictionary();
    private static final DynamicMultipleDictionary asignaciones = new DynamicMultipleDictionary();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcionPrincipal;

        do {
            System.out.println("\n========= SISTEMA DE GESTIÓN AEROPORTUARIA =========");
            System.out.println("1. Planificación de Rutas");
            System.out.println("2. Gestión de Flota");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcionPrincipal = validarOpcion(1, 3, sc);

            switch (opcionPrincipal) {
                case 1 -> menuRutas(sc);
                case 2 -> menuFlota(sc);
                case 3 -> System.out.println("Saliendo del sistema...");
            }

        } while (opcionPrincipal != 3);
        sc.close();
    }

    private static void menuRutas(Scanner sc) {
        int opcion;
        do {
            System.out.println("\n========= PLANIFICACIÓN DE RUTAS =========");
            System.out.println("1. Registrar nuevo aeropuerto");
            System.out.println("2. Registrar conexión (ruta) entre aeropuertos");
            System.out.println("3. Mostrar rutas posibles entre dos aeropuertos");
            System.out.println("4. Mostrar aeropuertos desconectados");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = validarOpcion(1, 5, sc);

            switch (opcion) {
                case 1 -> registrarAeropuerto(sc);
                case 2 -> registrarConexion(sc);
                case 3 -> buscarRutas(sc);
                case 4 -> mostrarAeropuertosDesconectados();
            }
        } while (opcion != 5);
    }

    private static void menuFlota(Scanner sc) {
        int opcion;
        do {
            System.out.println("\n========= GESTIÓN DE FLOTA =========");
            System.out.println("1. Registrar nuevo avión");
            System.out.println("2. Asignar avión a vuelo");
            System.out.println("3. Actualizar disponibilidad de avión");
            System.out.println("4. Mostrar aviones con más asignaciones");
            System.out.println("5. Mostrar aviones asignados a un vuelo");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = validarOpcion(1, 6, sc);

            switch (opcion) {
                case 1 -> registrarAvion(sc);
                case 2 -> asignarAvionAVuelo(sc);
                case 3 -> actualizarDisponibilidad(sc);
                case 4 -> mostrarAvionesConMasAsignaciones();
                case 5 -> mostrarAvionesAsignados(sc);
            }
        } while (opcion != 6);
    }

    private static int validarOpcion(int min, int max, Scanner sc) {
        int op;
        while (true) {
            try {
                op = Integer.parseInt(sc.nextLine());
                if (op >= min && op <= max) return op;
            } catch (NumberFormatException ignored) {}
            System.out.print("Opción inválida. Intente nuevamente: ");
        }
    }

    // === FUNCIONALIDADES DE RUTAS AÉREAS ===

    private static void registrarAeropuerto(Scanner sc) {
        System.out.print("Ingrese el código del aeropuerto: ");
        String codigo = sc.nextLine().trim();
        System.out.print("Ingrese la descripción: ");
        String descripcion = sc.nextLine().trim();

        if (!grafo.getVertxs().exist(codigo)) {
            grafo.addVertx(codigo);
            aeropuertos.add("Código: " + codigo + ", Descripción: " + descripcion);
            System.out.println("Aeropuerto registrado.");
        } else {
            System.out.println("Ya existe un aeropuerto con ese código.");
        }
    }

    private static void registrarConexion(Scanner sc) {
        System.out.print("Código aeropuerto origen: ");
        String origen = sc.nextLine().trim();
        System.out.print("Código aeropuerto destino: ");
        String destino = sc.nextLine().trim();

        if (!grafo.existsEdge(origen, destino)) {
            grafo.addEdge(origen, destino, "1");
            System.out.println("Ruta registrada exitosamente.");
        } else {
            System.out.println("Ya existe una ruta entre esos aeropuertos.");
        }
    }

    private static void buscarRutas(Scanner sc) {
        System.out.print("Código aeropuerto origen: ");
        String origen = sc.nextLine().trim();
        System.out.print("Código aeropuerto destino: ");
        String destino = sc.nextLine().trim();
        System.out.print("Cantidad máxima de escalas: ");
        int maxEscalas = Integer.parseInt(sc.nextLine());

        System.out.println("Buscando rutas posibles...\n");

        LinkedListADT caminos = new DynamicLinkedList();
        LinkedListADT caminoActual = new DynamicLinkedList();

        buscarRutasDFS(origen, destino, maxEscalas + 1, caminoActual, caminos);

        if (caminos.isEmpty()) {
            System.out.println("No se encontraron rutas.");
        } else {
            LinkedListUtil.print(caminos);
        }
    }

    private static boolean contiene(LinkedListADT lista, String valor) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(valor)) {
                return true;
            }
        }
        return false;
    }

    private static void buscarRutasDFS(String actual, String destino, int restantes,
                                       LinkedListADT caminoActual, LinkedListADT resultados) {
        if (restantes < 0) return;

        caminoActual.add(actual);

        if (actual.equals(destino) && caminoActual.size() > 1) {
            resultados.add(LinkedListUtil.copy(caminoActual).toString());
        } else {
            SetADT vertices = grafo.getVertxs();
            while (!vertices.isEmpty()) {
                String siguiente = vertices.choose();
                if (grafo.existsEdge(actual, siguiente) && !contiene(caminoActual, siguiente)) {
                    buscarRutasDFS(siguiente, destino, restantes - 1, caminoActual, resultados);
                }
                vertices.remove(siguiente);
            }
        }

        caminoActual.remove(caminoActual.size() - 1);
    }

    private static void mostrarAeropuertosDesconectados() {
        LinkedListADT desconectados = new DynamicLinkedList();

        for (int i = 0; i < aeropuertos.size(); i++) {
            String registro = (String) aeropuertos.get(i);
            String codigo = registro.split(",")[0].split(":")[1].trim();

            boolean tieneConexiones = false;
            SetADT vertices = SetUtil.copy(grafo.getVertxs());

            while (!vertices.isEmpty()) {
                String otro = vertices.choose();
                if (grafo.existsEdge(codigo, otro)) {
                    tieneConexiones = true;
                    break;
                }
                vertices.remove(otro);
            }

            if (!tieneConexiones) {
                desconectados.add(registro);
            }
        }

        if (desconectados.isEmpty()) {
            System.out.println("Todos los aeropuertos tienen al menos una conexión.");
        } else {
            System.out.println("Aeropuertos desconectados:");
            LinkedListUtil.print(desconectados);
        }
    }

    // === FUNCIONALIDADES DE GESTIÓN DE FLOTA ===

    private static void registrarAvion(Scanner sc) {
        System.out.print("Ingrese la matrícula del avión: ");
        String matricula = sc.nextLine().trim();

        try {
            flotaAviones.get(matricula);
            System.out.println("Ya existe un avión con esa matrícula.");
        } catch (EmptyDictionaryException e) {
            System.out.print("Ingrese el tipo de avión: ");
            String tipo = sc.nextLine().trim();
            flotaAviones.add(matricula, tipo);
            flotaAviones.add(matricula, "true");
            flotaAviones.add(matricula, "0");
            System.out.println("Avión registrado exitosamente.");
        }
    }

    private static void asignarAvionAVuelo(Scanner sc) {
        System.out.print("Ingrese el ID del vuelo: ");
        String idVuelo = sc.nextLine().trim();
        System.out.print("Ingrese la matrícula del avión: ");
        String matricula = sc.nextLine().trim();

        try {
            String[] datos = flotaAviones.get(matricula);
            if (datos[1].equals("true")) {
                asignaciones.add(idVuelo, matricula);
                flotaAviones.remove(matricula);
                flotaAviones.add(matricula, datos[0]);
                flotaAviones.add(matricula, "false");
                int cant = Integer.parseInt(datos[2]) + 1;
                flotaAviones.add(matricula, String.valueOf(cant));
                System.out.println("Avión asignado al vuelo correctamente.");
            } else {
                System.out.println("Ese avión no está disponible.");
            }
        } catch (EmptyDictionaryException e) {
            System.out.println("No se encontró un avión con esa matrícula.");
        }
    }

    private static void actualizarDisponibilidad(Scanner sc) {
        System.out.print("Ingrese la matrícula del avión: ");
        String matricula = sc.nextLine().trim();
        System.out.print("¿Está disponible? (true/false): ");
        String disponible = sc.nextLine().trim();

        try {
            String[] datos = flotaAviones.get(matricula);
            flotaAviones.remove(matricula);
            flotaAviones.add(matricula, datos[0]);
            flotaAviones.add(matricula, disponible);
            flotaAviones.add(matricula, datos[2]);
            System.out.println("Disponibilidad actualizada.");
        } catch (EmptyDictionaryException e) {
            System.out.println("No se encontró un avión con esa matrícula.");
        }
    }

    private static void mostrarAvionesConMasAsignaciones() {
        SetADT claves = flotaAviones.getKeys();
        int max = 0;

        while (!claves.isEmpty()) {
            String mat = claves.choose();
            try {
                String[] datos = flotaAviones.get(mat);
                int cant = Integer.parseInt(datos[2]);
                if (cant > max) max = cant;
            } catch (EmptyDictionaryException ignored) {}
            claves.remove(mat);
        }

        claves = flotaAviones.getKeys();
        System.out.println("Aviones con más asignaciones (" + max + "):");
        while (!claves.isEmpty()) {
            String mat = claves.choose();
            try {
                String[] datos = flotaAviones.get(mat);
                if (Integer.parseInt(datos[2]) == max) {
                    System.out.println("- Matrícula: " + mat + ", Tipo: " + datos[0]);
                }
            } catch (EmptyDictionaryException ignored) {}
            claves.remove(mat);
        }
    }

    private static void mostrarAvionesAsignados(Scanner sc) {
        System.out.print("Ingrese el ID del vuelo: ");
        String idVuelo = sc.nextLine().trim();
        try {
            String[] asignados = asignaciones.get(idVuelo);
            System.out.println("Aviones asignados al vuelo " + idVuelo + ":");
            for (String m : asignados) {
                System.out.println("- Matrícula: " + m);
            }
        } catch (EmptyDictionaryException e) {
            System.out.println("No hay aviones asignados a este vuelo.");
        }
    }
}
