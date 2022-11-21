package Semana10.Fila;
public interface QueueTAD<E> {
    public class EmptyQueueException extends RuntimeException {
        public EmptyQueueException(String s) { super(s); }
    }
    public int size();
    public boolean isEmpty();
    public E getHead() throws EmptyQueueException;
    public void enqueue(E element);
    public E dequeue() throws EmptyQueueException;
}