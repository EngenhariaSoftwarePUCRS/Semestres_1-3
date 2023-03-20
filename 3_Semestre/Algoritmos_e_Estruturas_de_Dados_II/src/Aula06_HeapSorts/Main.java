package Aula06_HeapSorts;

import aula05_filasdeprioridade_heap.HeapMaximo;

public class Main {
    public static void main(String[] args) {
        HeapMaximo heap = new HeapMaximo(10);
        heap.inserir(10);
        heap.inserir(20);
        heap.inserir(15);
        heap.inserir(5);
        heap.inserir(30);
        heap.inserir(120);
        heap.inserir(1);
        heap.inserir(2);
        heap.inserir(3);

        // for (int i : heap.ordernarHeapSort()) {
        // System.out.println(i);
        // }
    }
}
