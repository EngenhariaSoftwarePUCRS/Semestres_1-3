package Aula19_Grafos;

public interface IGrafo<T> {
    private int numeroVertices;
    private int numeroArestas;
    private T listaAdjacencia;

    public Grafo(int numeroVertices);

    public void adicionarAresta(int v, int w);

    public void removerAresta(int v, int w);

    public void imprimir();

    public int getNumeroVertices();

    public int getNumeroArestas();

    public T getListaAdjacencia();
}
