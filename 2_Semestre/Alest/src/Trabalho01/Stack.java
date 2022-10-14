package Trabalho01;

import java.util.ArrayList;

public class Stack<T> {
    private ListTAD<T> stack = new ListSimpleLinked<>();

    public void push(T e) {
        stack.addFirst(e);
    }

    public T pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException("Pilha Vazia");
        T aux = stack.getFirst();
        stack.removeFirst();
        return aux;
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public T top() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException("Pilha Vazia");
        return stack.getFirst();
    }

    public class EmptyStackException extends RuntimeException {
        public EmptyStackException(String message) {
            super(message);
        }
    }
}
