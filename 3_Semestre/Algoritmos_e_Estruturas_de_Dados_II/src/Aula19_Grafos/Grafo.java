package Aula19_Grafos;

public abstract class Grafo<T> implements Grafo<T> {
    private int numeroVertices;
    private int numeroArestas;
    private T listaAdjacencia;

    public Grafo(int numeroVertices) {
        this.numeroVertices = numeroVertices;
        this.numeroArestas = 0;
    }

    public void adicionarAresta(int v, int w) {
        this.numeroArestas++;
    }

    public void removerAresta(int v, int w) {
        this.numeroArestas--;
    }

    public void imprimir() {
        // TODO
    }

    public int getNumeroVertices() {
        return this.numeroVertices;
    }

    public int getNumeroArestas() {
        return this.numeroArestas;
    }

    public T getListaAdjacencia() {
        return this.listaAdjacencia;
    }
}
