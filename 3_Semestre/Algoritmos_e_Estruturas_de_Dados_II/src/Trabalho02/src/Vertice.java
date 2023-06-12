package Trabalho02.src;

public class Vertice {
    private int indice;
    private int linha;
    private int coluna;
    private char caracter;

    public Vertice(int indice, int linha, int coluna, char caracter) {
        this.indice = indice;
        this.linha = linha;
        this.coluna = coluna;
        this.caracter = caracter;
    }

    public int getIndice() {
        return indice;
    }

    @Override
    public String toString() {
        return "Vertice [caracter=" + caracter + ", coluna=" + coluna + ", indice=" + indice + ", linha=" + linha + "]";
    }
}
