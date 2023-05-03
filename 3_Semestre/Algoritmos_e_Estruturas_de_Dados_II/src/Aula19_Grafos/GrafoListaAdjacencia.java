package Aula19_Grafos;

import java.util.ArrayList;

public class GrafoListaAdjacencia extends Grafo<ArrayList<Integer>[]> {
    private ArrayList<Integer>[] listaAdjacencia;

    public GrafoListaAdjacencia(int numeroVertices) {
        super(numeroVertices);
        this.listaAdjacencia = new ArrayList[numeroVertices];
        for (int i = 0; i < numeroVertices; i++) {
            this.listaAdjacencia[i] = new ArrayList<Integer>();
        }
    }

    @Override
    public void adicionarAresta(int v, int w) {
        this.listaAdjacencia[v].add(w);
        this.listaAdjacencia[w].add(v);
        this.numeroArestas++;
    }

    @Override
    public void removerAresta(int v, int w) {
        this.listaAdjacencia[v].remove(w);
        this.listaAdjacencia[w].remove(v);
        this.numeroArestas--;
    }

    @Override
    public void imprimir() {
        for (int i = 0; i < this.numeroVertices; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < this.listaAdjacencia[i].size(); j++) {
                System.out.print(this.listaAdjacencia[i].get(j) + " ");
            }
            System.out.println();
        }
    }
}
