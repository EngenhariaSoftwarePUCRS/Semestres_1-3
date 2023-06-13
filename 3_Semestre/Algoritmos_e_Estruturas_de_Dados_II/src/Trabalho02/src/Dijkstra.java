package Trabalho02.src;

import aula26_grafos_dijkstra.FilaPrioridadeMinima;

public class Dijkstra {
    public int[] antecessor;
    public int[] distancia;
    public boolean[] percorrido;
    private Grafo grafo;
    
    public Dijkstra(Grafo g, int origem) {
        this.grafo = g;
        antecessor = new int[grafo.getNumeroVertices()];
        distancia = new int[grafo.getNumeroVertices()];
        percorrido = new boolean[grafo.getNumeroVertices()];
        for (int i = 0; i < grafo.getNumeroVertices(); i++) {
            antecessor[i] = -1;
            distancia[i] = Integer.MAX_VALUE;
            percorrido[i] = false;
        }

        FilaPrioridadeMinima filaMin = new FilaPrioridadeMinima();
        filaMin.enfileirar(origem, 0);
        distancia[origem] = 0;

        while (!filaMin.estaVazia()) {
            int vertice = filaMin.desenfileirar();
            percorrido[vertice] = true;
            for (int aresta : g.adjacentes(vertice)) {
                int destino = aresta;
                int distanciaDestino = distancia[vertice] + 1;
                if (distanciaDestino < distancia[destino]) {
                    antecessor[destino] = vertice;
                    distancia[destino] = distanciaDestino;
                    if (!filaMin.existe(destino)) filaMin.enfileirar(destino, distanciaDestino);
                    else filaMin.atualizarDistanca(destino, distanciaDestino);
                }
            }
        }
    }

    public int getDistancia(int destino) {
        return distancia[destino];
    }

    public boolean isUnreachable(int destino) {
        return distancia[destino] == Integer.MAX_VALUE;
    }

    public void imprimirResultado() {
        System.out.println("vertice,antecessor,distancia,percorrido");
        for (int i = 0; i < grafo.getNumeroVertices(); i++)
            System.out.println(i + "," + antecessor[i] + "," + distancia[i] + "," + percorrido[i]);
    }
}
