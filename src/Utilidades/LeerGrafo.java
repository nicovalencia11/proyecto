package Utilidades;

import Estructura.Arista;
import Estructura.Grafo;
import Estructura.Nodo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerGrafo {
    public static Grafo leer(){
        String rutaNodos = "src/Grafo/Nodos.txt";
        String rutaAristas = "src/Grafo/Aristas.txt";
        List<Nodo> nodos = cargarNodosDesdeArchivo(rutaNodos);
        List<Arista> aristas = cargarAristasDesdeArchivo(rutaAristas);

        if (nodos.isEmpty() || aristas.isEmpty()) {
            System.out.println("No se pudieron cargar nodos o aristas desde los archivos.");
        }

        Grafo grafo = new Grafo(nodos, aristas);
        return grafo;
    }

    private static List<Nodo> cargarNodosDesdeArchivo(String nombreArchivo) {
        List<Nodo> nodos = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                int id = Integer.parseInt(linea);
                Nodo nodo = new Nodo(id);
                nodos.add(nodo);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nodos;
    }

    private static List<Arista> cargarAristasDesdeArchivo(String nombreArchivo) {
        List<Arista> aristas = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(" ");
                if (partes.length == 3) {
                    int idOrigen = Integer.parseInt(partes[0]);
                    int idDestino = Integer.parseInt(partes[1]);
                    int tam = Integer.parseInt(partes[2]);

                    Nodo origen = new Nodo(idOrigen);
                    Nodo destino = new Nodo(idDestino);

                    Arista arista = new Arista(origen, destino, tam);
                    aristas.add(arista);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aristas;
    }
}
