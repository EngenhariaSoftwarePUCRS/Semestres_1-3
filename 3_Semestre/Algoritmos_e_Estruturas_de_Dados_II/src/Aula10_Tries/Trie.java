package Aula10_Tries;

public class Trie {
    private static final int TAMANHO_ALFABETO = 26;        //apenas letras maiusculas

    private class Nodo {
        private char valor;
        private int nivel;
        private Nodo[] proximo;

        public Nodo() {
            this.proximo = new Nodo[TAMANHO_ALFABETO];
            this.nivel = 0;
        }
    }

    private Nodo raiz;
    private int quantidade;

    public Trie() {
        this.quantidade = 0;
        this.raiz = new Nodo();
    }

    public void adicionar(String chave) {
        Nodo aux = this.raiz;
        int nivel = this.raiz.nivel;
        for (int i = 0; i < chave.length(); i++) {
            int posicaoNoArray = chave.charAt(i) - 65;
            if (aux.proximo[posicaoNoArray] == null) {
                Nodo novoNodo = new Nodo();
                novoNodo.valor = chave.charAt(i);
                novoNodo.nivel = nivel;
                aux.proximo[posicaoNoArray] = novoNodo;
            }
            nivel++;
            aux = aux.proximo[posicaoNoArray];
        }
    }

    public boolean buscar(String chave) {
        Nodo aux = this.raiz;
        for (int i = 0; i < chave.length(); i++) {
            int posicaoNoArray = chave.charAt(i) - 65;
            if (aux.proximo[posicaoNoArray] == null)
                return false;
            aux = aux.proximo[posicaoNoArray];
        }
        return true;
    }

    public void imprimir() {
        Nodo aux = this.raiz;
        // TODO: Implement
    }
}
