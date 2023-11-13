package Estructura;

import Estructura.Nodo;

public class Arista {
    private Nodo origen;
    private Nodo destino;
    int tam;

    public Arista(Nodo origen, Nodo destino, int tam) {
        this.origen = origen;
        this.destino = destino;
        this.tam = tam;
    }

    public Nodo getOrigen() {
        return origen;
    }

    public Nodo getDestino() {
        return destino;
    }

    public int getTam() {
        return tam;
    }
}
