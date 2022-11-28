package Trabalho02;

import java.util.List;

public class ArvoreRubroNegra implements IArvoreRubroNegra {
    private Node raiz;

    private class Node {
        private Node pai;
        private int elemento;
        private Node esq;
        private Node dir;
        private boolean red;

        public Node(int elemento, boolean red) {
            this.pai = null;
            this.elemento = elemento;
            this.esq = null;
            this.dir = null;
            this.red = red;
        }

        public Node getPai() {
            return pai;
        }

        public void setPai(Node pai) {
            this.pai = pai;
        }

        public int getElemento() {
            return elemento;
        }

        public void setElemento(int elemento) {
            this.elemento = elemento;
        }

        public Node getEsq() {
            return esq;
        }

        public void setEsq(Node esq) {
            this.esq = esq;
        }

        public Node getDir() {
            return dir;
        }

        public void setDir(Node dir) {
            this.dir = dir;
        }

        public boolean isRed() {
            return red;
        }

        public void setRed(boolean red) {
            this.red = red;
        }
    }

    @Override
    public void add(int elemento) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean contains(int elemento) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getParent(int elemento) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int height() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isBalanced() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Integer> positionsCentral() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Integer> positionsPos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Integer> positionsPre() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Integer> positionsWidth() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

}