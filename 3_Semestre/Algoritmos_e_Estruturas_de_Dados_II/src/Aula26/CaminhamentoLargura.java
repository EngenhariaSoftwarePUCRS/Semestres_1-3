package Aula26;

import java.util.LinkedList;
import java.util.Queue;

import aula26_grafos_dijkstra.GrafoDirigidoValorado;

public class CaminhamentoLargura {
    public boolean[] percorrido;
    public int[] antecessor;
    public int[] distancia;

    public static void main(String[] args) {
        GrafoDirigidoValorado g = new GrafoDirigidoValorado(5);
        g.adicionarAresta(0, 1, 50);
        g.adicionarAresta(0, 3, 500);
        g.adicionarAresta(1, 2, 100);
        g.adicionarAresta(2, 3, 10);
        g.adicionarAresta(2, 4, 20);
        g.adicionarAresta(3, 4, 700);

        new CaminhamentoLargura(g, 0);
    }
    
    public CaminhamentoLargura(GrafoDirigidoValorado g, int origem) {
        percorrido = new boolean[g.getNumeroVertices()];
        antecessor = new int[g.getNumeroVertices()];
        distancia = new int[g.getNumeroVertices()];
        for (int i = 0; i < g.getNumeroVertices(); i++) {
            percorrido[i] = false;
            antecessor[i] = -1;
            distancia[i] = Integer.MAX_VALUE;
        }
        percorrido[origem] = true;
        antecessor[origem] = origem;
        distancia[origem] = 0;
        Queue<Integer> fila = new LinkedList<Integer>();
        fila.add(origem);
        while (!fila.isEmpty()) {
            Integer v = fila.remove();
            for (GrafoDirigidoValorado.ArestaDirigida aresta : g.getListaAdjacencia(v)) {
                int destino = aresta.destino;
                if (!percorrido[destino]) {
                    percorrido[destino] = true;
                    antecessor[destino] = v;
                    distancia[destino] = distancia[v] + aresta.peso;
                    fila.add(destino);
                }
            }
        }
        imprimirResultado(g);
    }

    public void imprimirResultado(GrafoDirigidoValorado g) {
        System.out.println("vertice,antecessor,percorrido,distancia");
        for (int i = 0; i < g.getNumeroVertices(); i++) {
            System.out.println(i + "," + antecessor[i] + "," + percorrido[i] + "," + distancia[i]);
        }
    }
}
