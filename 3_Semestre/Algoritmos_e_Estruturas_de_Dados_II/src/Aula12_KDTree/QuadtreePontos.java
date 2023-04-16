package Aula12_KDTree;

import java.util.LinkedList;
import java.util.Queue;

public class QuadtreePontos {
    private Nodo raiz;
    private int pontosInseridos;
    private int minimoX;
    private int minimoY;
    private int maximoX;
    private int maximoY;

    private class Nodo {
        public Ponto ponto;
        public Nodo NE;
        public Nodo SE;
        public Nodo NO;
        public Nodo SO;
        public Nodo pai;

        public Nodo(String rotulo, int x, int y) {
            this.ponto = new Ponto(rotulo, x, y);
        }

        @Override
        public String toString() {
            String str = ponto.rotulo + " = ";
            str += "{";
            if (this.NO == null)
                str += " NO ";
            else
                str += " " + NO.ponto.rotulo + " ";
            str += ",";
            if (this.SO == null)
                str += " SO ";
            else
                str += " " + SO.ponto.rotulo + " ";
            str += ",";
            if (this.SE == null)
                str += " SE ";
            else
                str += " " + SE.ponto.rotulo + " ";
            str += ",";
            if (this.NE == null)
                str += " NE ";
            else
                str += " " + NE.ponto.rotulo + " ";
            str += "}";
            return str;
        }
    }

    public QuadtreePontos() {
        this.raiz = null;
        this.pontosInseridos = 0;
        this.minimoX = 0;
        this.minimoY = 0;
        this.maximoX = 100;
        this.maximoY = 100;
    }

    public void adicionar(String rotulo, int x, int y) {
        Nodo novoNodo = new Nodo(rotulo, x, y);
        this.pontosInseridos++;
        if (this.raiz == null) {
            raiz = novoNodo;
            return;
        }
        Nodo explorador = raiz;
        while (explorador != null) {
            if (novoNodo.ponto.x < explorador.ponto.x && novoNodo.ponto.y >= explorador.ponto.y) {
                if (explorador.NO == null) {
                    explorador.NO = novoNodo;
                    explorador = null;
                } else
                    explorador = explorador.NO;
            } else if (novoNodo.ponto.x < explorador.ponto.x && novoNodo.ponto.y < explorador.ponto.y) {
                if (explorador.SO == null) {
                    explorador.SO = novoNodo;
                    explorador = null;
                } else
                    explorador = explorador.SO;
            } else if (novoNodo.ponto.x >= explorador.ponto.x && novoNodo.ponto.y >= explorador.ponto.y) {
                if (explorador.NE == null) {
                    explorador.NE = novoNodo;
                    explorador = null;
                } else
                    explorador = explorador.NE;
            } else if (novoNodo.ponto.x >= explorador.ponto.x && novoNodo.ponto.y < explorador.ponto.y) {
                if (explorador.SE == null) {
                    explorador.SE = novoNodo;
                    explorador = null;
                } else
                    explorador = explorador.SE;
            }
        }
    }

    public boolean existe(int x, int y) {
        Nodo navegador = this.raiz;
        while (navegador != null) {
            if (x == navegador.ponto.x && y == navegador.ponto.y)
                return true;
            if (x < navegador.ponto.x && y >= navegador.ponto.y)
                navegador = navegador.NO;
            else if (x < navegador.ponto.x && y < navegador.ponto.y)
                navegador = navegador.SO;
            else if (x >= navegador.ponto.x && y < navegador.ponto.y)
                navegador = navegador.SE;
            else if (x >= navegador.ponto.x && y >= navegador.ponto.y)
                navegador = navegador.NE;
        }
        return false;
    }

    public String imprimirQuadtree() {
        StringBuilder sb = new StringBuilder();
        Queue<Nodo> fila = new LinkedList<>();
        fila.add(raiz);
        sb.append(raiz + System.lineSeparator());
        while (!fila.isEmpty()) {
            Nodo n = fila.poll();
            if (n.NO != null) {
                fila.add(n.NO);
                sb.append(n.NO + System.lineSeparator());
            }
            if (n.SO != null) {
                fila.add(n.SO);
                sb.append(n.SO + System.lineSeparator());
            }
            if (n.SE != null) {
                fila.add(n.SE);
                sb.append(n.SE + System.lineSeparator());
            }
            if (n.NE != null) {
                fila.add(n.NE);
                sb.append(n.NE + System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public void limpar() {
        this.pontosInseridos = 0;
        Queue<Nodo> fila = new LinkedList<>();
        fila.add(raiz);
        while (!fila.isEmpty()) {
            Nodo n = fila.poll();
            if (n.NO != null) {
                fila.add(n.NO);
                n.NO = null;
            }
            if (n.SO != null) {
                fila.add(n.SO);
                n.SO = null;
            }

            if (n.SE != null) {
                fila.add(n.SE);
                n.SE = null;
            }

            if (n.NE != null) {
                fila.add(n.NE);
                n.NE = null;
            }
        }
        this.raiz = null;
        System.out.println("Quadtree limpa com sucesso!");
    }

    @Override
    public String toString() {
        return this.imprimirQuadtree();
    }
}
