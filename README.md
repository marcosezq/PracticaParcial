# ✈️ Sistema de Operaciones para Aerolíneas

Este proyecto es una simulación de un sistema de gestión para una aerolínea, desarrollado como parte del **Trabajo Práctico II** de la materia **Programación II - UADE**. Se utilizan estructuras de datos dinámicas implementadas manualmente, respetando los requerimientos de la cátedra.

## 📌 Objetivo

El sistema permite planificar rutas entre aeropuertos, asignar aviones a vuelos, gestionar prioridades de vuelos y analizar las conexiones. Además, simula operaciones como la reprogramación de vuelos o la modificación de rutas.

---

## 🧩 Módulos implementados

### 1. **Planificación de Rutas**
- Carga inicial de 15 aeropuertos.
- Registro de nuevas conexiones entre aeropuertos (sin rutas repetidas).
- Consulta de rutas posibles entre dos aeropuertos (con límite de escalas).
- Detección de aeropuertos desconectados.

### 2. **Gestión de Flota**
- Registro de 10 aviones con matrícula y tipo.
- Asignación de aviones a vuelos por identificador.
- Actualización del estado de disponibilidad.
- Identificación de los aviones con más asignaciones.

### 3. **Prioridad de Vuelos**
- Clasificación de vuelos en:
    - Nacionales
    - Internacionales
    - De carga
- Asignación de prioridades para gestionar el orden.
- Permite reordenar prioridades por condiciones externas (ej: clima).

### 4. **Análisis de Conexiones**
- Listado de aeropuertos registrados.
- Identificación de:
    - Aeropuertos con más conexiones.
    - Aeropuertos con más vuelos salientes y entrantes.

### 5. **Simulación y Reportes**
- Alta de nuevos vuelos, rutas o aviones durante la ejecución.
- Cancelación o reprogramación de vuelos.
- Reportes sobre:
    - Utilización promedio de flota.
    - Conexiones más y menos utilizadas.

---

## 🗂️ Estructuras utilizadas

- `DynamicGraph`: Grafo dirigido implementado con listas enlazadas para representar aeropuertos y conexiones.
- `DynamicPriorityQueue`: Cola con prioridad personalizada para gestión de vuelos.
- `DynamicMultipleDictionary`: Diccionario múltiple para asignación de aviones a vuelos.
- `DynamicLinkedList`, `DynamicSet`: Utilizadas para representar listas auxiliares de datos como aeropuertos, vuelos, claves, etc.

---

## 🧪 Datos Iniciales

- **Aeropuertos:** 15 (ej: EZE, JFK, LHR, etc.)
- **Aviones:** 10 con matrícula y tipo.
- **Vuelos planificados:** 50 (nacionales, internacionales y de carga).

Los datos iniciales se cargan automáticamente mediante las clases `DatosInicialesVuelos` y `DatosInicialesAeropuertos`.

---

## ▶️ Ejecución

1. Iniciar la clase principal `RutasAereas`.
2. Utilizar el menú interactivo para acceder a cada módulo.
3. Ingresar los datos por teclado según lo solicitado.

---

## 🛠️ Requisitos técnicos

- JDK 17+
- Implementación **sin uso de colecciones estándar (ArrayList, HashMap, etc.)**
- IDE sugerido: IntelliJ IDEA o Eclipse

---

## 👨‍💻 Autor

**Marcos Fernández**  
Estudiante de Ingeniería Informática - UADE  
Trabajo desarrollado para la materia Programación II

