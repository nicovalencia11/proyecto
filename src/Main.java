import Algoritmos.Dijkstra;
import Estructura.Grafo;
import Estructura.Nodo;
import Utilidades.CrearGrafo;
import Utilidades.LeerGrafo;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = CrearGrafo.crear();
        //Grafo grafo = LeerGrafo.leer();

        Nodo nodoInicial = grafo.getNodos().get(0);
        Nodo nodoDestino = grafo.getNodos().get(20); // Cambia esto al nodo de destino que desees

        List<Nodo> caminoMasCorto = Dijkstra.calcularCaminoMasCorto(grafo, nodoInicial, nodoDestino);

        if (caminoMasCorto.isEmpty()) {
            System.out.println("No se encontró un camino desde " + nodoInicial.getId() + " a " + nodoDestino.getId());
        } else {
            System.out.print("Camino más corto desde " + nodoInicial.getId() + " a " + nodoDestino.getId() + ": ");
            for (Nodo nodo : caminoMasCorto) {
                System.out.print(nodo.getId() + " ");
            }
            System.out.println(); // Agregar un salto de línea al final
        }
    }
}
