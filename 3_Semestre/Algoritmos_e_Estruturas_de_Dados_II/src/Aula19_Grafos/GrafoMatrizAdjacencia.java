package Aula19_Grafos;

public class GrafoMatrizAdjacencia extends Grafo<boolean[][]> {
    private boolean[][] matrizAdjacencia;

    public GrafoMatrizAdjacencia(int numeroVertices) {
        super(numeroVertices);
        this.matrizAdjacencia = new boolean[numeroVertices][numeroVertices];
    }

    @Override
    public void adicionarAresta(int v, int w) {
        this.matrizAdjacencia[v][w] = true;
        this.matrizAdjacencia[w][v] = true;
        this.numeroArestas++;
    }

    @Override
    public void removerAresta(int v, int w) {
        this.matrizAdjacencia[v][w] = false;
        this.matrizAdjacencia[w][v] = false;
        this.numeroArestas--;
    }

    @Override
    public void imprimir() {
        for (int i = 0; i < this.numeroVertices; i++) {
            for (int j = 0; j < this.numeroVertices; j++) {
                System.out.print(this.matrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }
    }
}
