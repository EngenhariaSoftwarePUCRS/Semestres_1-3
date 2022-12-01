package Trabalho02;

import java.util.List;

public interface IArvoreRubroNegra {
    /** Adiciona elementos na árvore */
    void add(int elemento);

    /** @return o pai de um elemento */
    int getParent(int elemento);

    /** @return se um elemento está armazenado na árvore ou não */
    boolean contains(int elemento);

    /** @return qual é a altura da árvore */
    int height();

    /** @return se a árvore está balanceada ou não */
    boolean isBalanced();

    /** @return quantos elementos tem na árvore */
    int size();

    /** @return se a árvore está vazia ou não */
    boolean isEmpty();

    /** @return os elementos da árvore em uma lista usando pré-ordem */
    List<Integer> positionsPre();

    /** @return os elementos da árvore em uma lista usando caminhamento central */
    List<Integer> positionsCentral();

    /** @return os elementos da árvore em uma lista usando pós-ordem */
    List<Integer> positionsPos();

    /**
     * @return os elementos da árvore em uma lista usando caminhamento horizontal
     */
    List<Integer> positionsWidth();
}