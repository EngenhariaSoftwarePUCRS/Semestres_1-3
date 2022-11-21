package Semana10.Fila;

import java.io.Serializable;

import Semana10.ListSimpleLinked;
import Semana10.ListTAD;

public class Queue<T extends Comparable<T>> implements QueueTAD<T>, Serializable {
    private ListTAD<T> lst = new ListSimpleLinked<T>();

    public void enqueue(T dado) {
        lst.addLast(dado);
    }

    public T dequeue() {
        return lst.removeFirst();
    }

    public T getHead() {
        return lst.getFirst();
    }

    public boolean isEmpty() {
        return lst.isEmpty();
    }

    public int size() {
        return lst.size();
    }
}
