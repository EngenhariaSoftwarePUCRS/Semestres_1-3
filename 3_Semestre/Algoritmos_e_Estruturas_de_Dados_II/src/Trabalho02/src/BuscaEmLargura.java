// import java.util.Queue;
// import java.util.concurrent.ConcurrentLinkedQueue;

// public class BuscaEmLargura {
// private boolean[] visitados;
// private int[] antecessor;
// private int[] distancia;
// private Queue<Integer> fila;

// public BuscaEmLargura(Grafo g, int verticeOrigem) {
// visitados = new boolean[g.getNumeroVertices()];
// antecessor = new int[g.getNumeroVertices()];
// distancia = new int[g.getNumeroVertices()];
// fila = new ConcurrentLinkedQueue<>();

// for (int i = 0; i < g.getNumeroVertices(); i++) {
// visitados[i] = false;
// antecessor[i] = -1;
// distancia[i] = Integer.MAX_VALUE;
// }

// visitados[verticeOrigem] = true;
// distancia[verticeOrigem] = 0;
// fila.add(verticeOrigem);

// while (!fila.isEmpty()) {
// int verticeAtual = fila.remove();

// for (Aresta a : g.getAdjacencia(verticeAtual)) {
// int verticeAdjacente = a.w;
// if (!visitados[verticeAdjacente]) {
// visitados[verticeAdjacente] = true;
// antecessor[verticeAdjacente] = verticeAtual;
// distancia[verticeAdjacente] = distancia[verticeAtual] + 1;
// fila.add(verticeAdjacente);
// }
// }
// }
// }

// public void imprimirResultado() {
// for (int i = 0; i < visitados.length; i++) {
// System.out.print(visitados[i] + " ");
// System.out.print(antecessor[i] + " ");
// System.out.print(distancia[i] + " ");
// }
// }
// }