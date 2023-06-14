package Trabalho02;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Integer>[] adjecencyList;
    private int verticesAmount;
    private int edgesAmount;

    public Graph(int verticesAmount) {
        this.verticesAmount = verticesAmount;
        this.edgesAmount = 0;
        adjecencyList = new ArrayList[verticesAmount];
        for (int i = 0; i < verticesAmount; i++)
            adjecencyList[i] = new ArrayList<>();
    }

    public void insertEdge(int v, int w) {
        if (existsEdge(v, w)) return;
        adjecencyList[v].add(w);
        adjecencyList[w].add(v);
        edgesAmount++;
    }

    public boolean existsEdge(int v, int w) {
        boolean vw = adjecencyList[v].indexOf(w) >= 0;
        boolean wv = adjecencyList[w].indexOf(v) >= 0;
        return vw || wv;
    }

    public void removeEdge(int v, int w) {
        int vw = adjecencyList[v].indexOf(w);
        adjecencyList[v].remove(vw);
        int wv = adjecencyList[w].indexOf(v);
        adjecencyList[w].remove(wv);
    }

    public ArrayList<Integer> getAdjecencyListForVertex(int vertex) {
        return adjecencyList[vertex];
    }

    public int getVerticesAmount() {
        return this.verticesAmount;
    }

    public int getEdgesAmount() {
        return this.edgesAmount;
    }

    public String toDot() {
        String resultado = "graph G { " + System.lineSeparator();
        for (int i = 0; i < verticesAmount; i++) {
            resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        }
        for (int i = 0; i < verticesAmount; i++) {
            for (int j = 0; j < adjecencyList[i].size(); j++) {
                resultado += "\t" + i + "--" + adjecencyList[i].get(j) + ";" + System.lineSeparator();
            }
        }
        resultado += "}";
        return resultado;
    }

    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i < verticesAmount; i++) {
            ret += i + " {";
            for (int j = 0; j < adjecencyList[i].size(); j++) {
                ret += " " + adjecencyList[i].get(j);
            }
            ret = ret + " } " + System.lineSeparator();
        }
        return ret;
    }
}
