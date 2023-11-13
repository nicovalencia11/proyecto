package Utilidades;

import Estructura.Arista;
import Estructura.Grafo;
import Estructura.Nodo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CrearGrafo {
    public static Grafo crear() {
        String rutaNodos = "src/Grafo/Nodos.txt";
        String rutaAristas = "src/Grafo/Aristas.txt";

        int numNodos = 100;
        int numAristas = numNodos * 3; // Cada nodo debe tener 3 aristas

        List<Nodo> nodos = new ArrayList<>();
        List<Arista> aristas = new ArrayList<>();

        // Crear los nodos
        for (int i = 0; i < numNodos; i++) {
            Nodo nodo = new Nodo(i);
            nodos.add(nodo);
        }

        Random rand = new Random();

        while (aristas.size() < numAristas) {
            Nodo origen = seleccionaNodoAleatorio(nodos, rand);
            Nodo destino = seleccionaNodoAleatorio(nodos, rand);
            if (origen != destino) { // Asegurarse de que el origen y el destino no sean el mismo nodo
                int tam = rand.nextInt(10) + 1; // Distancia aleatoria entre 1 y 10 (puedes ajustar esto)

                Arista arista = new Arista(origen, destino, tam);
                aristas.add(arista);
            }
        }

        Grafo grafo = new Grafo(nodos, aristas);
        // Guardar los nodos en el archivo "Nodos.txt"
        guardarNodosEnArchivo(rutaNodos, nodos);
        // Guardar las aristas en el archivo "Aristas.txt"
        guardarAristasEnArchivo(rutaAristas, aristas);
        return grafo;
    }

    private static Nodo seleccionaNodoAleatorio(List<Nodo> nodos, Random rand) {
        int indice = rand.nextInt(nodos.size());
        return nodos.get(indice);
    }

    private static void guardarNodosEnArchivo(String nombreArchivo, List<Nodo> nodos) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
            for (Nodo nodo : nodos) {
                writer.write(Integer.toString(nodo.getId()));
                writer.newLine(); // Agregar un salto de línea después de cada ID
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void guardarAristasEnArchivo(String nombreArchivo, List<Arista> aristas) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
            for (Arista arista : aristas) {
                writer.write(arista.getOrigen().getId() + " " + arista.getDestino().getId() + " " + arista.getTam());
                writer.newLine(); // Agregar un salto de línea después de cada arista
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
