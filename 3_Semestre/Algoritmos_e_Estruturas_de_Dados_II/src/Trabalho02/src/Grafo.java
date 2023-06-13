package Trabalho02.src;

import java.util.ArrayList;

public class Grafo {
    private ArrayList<Integer>[] listaAdjacencia;
    private int numeroVertices;
    private int numeroArestas;

    public Grafo(int numeroVertices) {
        this.numeroVertices = numeroVertices;
        this.numeroArestas = 0;
        listaAdjacencia = new ArrayList[numeroVertices];
        for (int i = 0; i < numeroVertices; i++)
            listaAdjacencia[i] = new ArrayList<>();
    }

    public void adicionarAresta(int v, int w) {
        if (existeAresta(v, w)) return;
        listaAdjacencia[v].add(w);
        listaAdjacencia[w].add(v);
        numeroArestas++;
    }

    public boolean existeAresta(int v, int w) {
        boolean vw = listaAdjacencia[v].indexOf(w) >= 0;
        boolean wv = listaAdjacencia[w].indexOf(v) >= 0;
        return vw || wv;
    }

    public void removerAresta(int v, int w) {
        int vw = listaAdjacencia[v].indexOf(w);
        listaAdjacencia[v].remove(vw);
        int wv = listaAdjacencia[w].indexOf(v);
        listaAdjacencia[w].remove(wv);
    }

    public ArrayList<Integer> adjacentes(int v) {
        return listaAdjacencia[v];
    }

    public int getNumeroVertices() {
        return this.numeroVertices;
    }

    public int getNumeroArestas() {
        return this.numeroArestas;
    }

    public String toDot() {
        String resultado = "graph G { " + System.lineSeparator();
        for (int i = 0; i < numeroVertices; i++) {
            resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        }
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = 0; j < listaAdjacencia[i].size(); j++) {
                resultado += "\t" + i + "--" + listaAdjacencia[i].get(j) + ";" + System.lineSeparator();
            }
        }
        resultado += "}";
        return resultado;
    }

    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i < numeroVertices; i++) {
            ret += i + " {";
            for (int j = 0; j < listaAdjacencia[i].size(); j++) {
                ret += " " + listaAdjacencia[i].get(j);
            }
            ret = ret + " } " + System.lineSeparator();
        }
        return ret;
    }
}
