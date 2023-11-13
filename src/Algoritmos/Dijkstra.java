package Algoritmos;

import java.util.*;
import Estructura.Arista;
import Estructura.Nodo;
import Estructura.Grafo;

public class Dijkstra {
    public static List<Nodo> calcularCaminoMasCorto(Grafo grafo, Nodo nodoInicial, Nodo nodoDestino) {
        Map<Nodo, Integer> distanciaMinima = new HashMap<>();
        Map<Nodo, Nodo> nodoAnterior = new HashMap<>();
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(distanciaMinima::get));

        // Inicializar distancias y cola de prioridad
        for (Nodo nodo : grafo.getNodos()) {
            distanciaMinima.put(nodo, Integer.MAX_VALUE);
            nodoAnterior.put(nodo, null);
        }
        distanciaMinima.put(nodoInicial, 0);
        colaPrioridad.add(nodoInicial);

        while (!colaPrioridad.isEmpty()) {
            Nodo nodoActual = colaPrioridad.poll();

            if (nodoActual.equals(nodoDestino)) {
                // Construir el camino más corto
                List<Nodo> camino = new ArrayList<>();
                Nodo nodo = nodoDestino;
                while (nodo != null) {
                    camino.add(nodo);
                    nodo = nodoAnterior.get(nodo);
                }
                Collections.reverse(camino);
                return camino;
            }

            for (Arista arista : grafo.getAristasSalientes(nodoActual)) {
                Nodo vecino = arista.getDestino();
                int distanciaHastaVecino = distanciaMinima.get(nodoActual) + arista.getTam();

                if (distanciaHastaVecino < distanciaMinima.get(vecino)) {
                    distanciaMinima.put(vecino, distanciaHastaVecino);
                    nodoAnterior.put(vecino, nodoActual);
                    colaPrioridad.add(vecino);
                }
            }
        }

        // No se encontró un camino
        return Collections.emptyList();
    }
}
