package Aula19_Grafos;

public class App {
    public static void main(String[] args) {
        GrafoMatrizAdjacencia grafo = new GrafoMatrizAdjacencia(5);
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 4);
        grafo.adicionarAresta(2, 0);
        grafo.adicionarAresta(4, 2);
        System.out.println("Oi");
    }
}
