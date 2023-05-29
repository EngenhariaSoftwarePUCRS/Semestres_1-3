package TrabalhoExtra;

import java.util.ArrayList;

public class GrafoValorado {
    class Aresta {
        public int v;
        public int w;
        public int peso;
        public Aresta(int v, int w, int peso) {
            this.v = v;
            this.w = w;
            this.peso = peso;
        }
    }

    private ArrayList<Aresta> listaAdjacencia[];
    private int numeroVertices;
    private int numeroArestas;

    public GrafoValorado(int numeroVertices) {
        this.numeroVertices = numeroVertices;
        this.listaAdjacencia = new ArrayList[this.numeroVertices];
        for (int i = 0; i < this.numeroVertices; i++)
            this.listaAdjacencia[i] = new ArrayList<Aresta>();
    }

    public int getNumeroVertices() {
        return numeroVertices;
    }

    public int getNumeroArestas() {
        return numeroArestas;
    }

    public ArrayList<Aresta> getAdjacencia(int vertice) {
        return listaAdjacencia[vertice];
    }

    public void adicionarAresta(int v, int w, int peso) {
        Aresta e1 = new Aresta(v, w, peso);
        listaAdjacencia[v].add(e1);

        Aresta e2 = new Aresta(w, v, peso);
        listaAdjacencia[w].add(e2);

        numeroArestas++;
    }

    public void removerAresta(int v, int w) {
        listaAdjacencia[v].remove(w);
        listaAdjacencia[w].remove(v);
        numeroArestas--;
    }

    public int grau(int vertice) {
        return listaAdjacencia[vertice].size();
    }

    public String toDot() {
        String resultado = "graph G { " + System.lineSeparator();
        for (int i = 0; i < numeroVertices; i++) {
            resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        }
        boolean[][] jaImpresso = new boolean[numeroVertices][numeroVertices];
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = 0; j < listaAdjacencia[i].size(); j++) {
                if(!jaImpresso[i][j]) {
                    resultado += "\t" + listaAdjacencia[i].get(j).v + "--" + listaAdjacencia[i].get(j).w + "  [label=" + listaAdjacencia[i].get(j).peso + "]" + ";" + System.lineSeparator();
                    jaImpresso[listaAdjacencia[i].get(j).v][listaAdjacencia[i].get(j).w] = true;
                    jaImpresso[listaAdjacencia[i].get(j).w][listaAdjacencia[i].get(j).v] = true;
                }
            }
        }
        resultado += "}";
        return resultado;
    }

    public static void main(String[] args) {
        GrafoValorado g = new GrafoValorado(4);
        g.adicionarAresta(0, 1, 33);
        g.adicionarAresta(0,2, 10);
        g.adicionarAresta(1,2, 99);
        g.adicionarAresta(0, 3, 200);

        BuscaEmLargura bel = new BuscaEmLargura(g, 0);
        bel.imprimirResultado(); 

        System.out.println(g.toDot());
    }
}
