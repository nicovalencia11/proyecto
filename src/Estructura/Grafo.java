package Estructura;
import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private List<Nodo> nodos;
    private List<Arista> aristas;

    public Grafo(List<Nodo> nodos, List<Arista> aristas) {
        this.nodos = nodos;
        this.aristas = aristas;
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public List<Arista> getAristasSalientes(Nodo nodo) {
        List<Arista> aristasSalientes = new ArrayList<>();

        for (Arista arista : aristas) {
            if (arista.getOrigen().equals(nodo)) {
                aristasSalientes.add(arista);
            }
        }

        return aristasSalientes;
    }
}
