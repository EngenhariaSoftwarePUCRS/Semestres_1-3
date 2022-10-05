public class List<E> implements ListTAD<E> {
    private E element;
    private Node refHead;

    private class Node {
        private E element;
        private Node next;

        public Node() {
            element = null;
            next = null;
        }

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    @Override
    public void add(E element) {
        Node aux = refHead;
        while (aux.getNext() != null)
            aux = aux.getNext();
        aux.setNext(new Node(element));
    }

    @Override
    public void add(int index, E element) {
    }

    @Override
    public E remove(int pos) {
        return null;
    }

    @Override
    public E remove(E element) {
        return null;
    }

    @Override
    public E get(int pos) {
        return null;
    }

    @Override
    public void set(int index, E element) {
    }

    @Override
    public E search(E element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int count(E element) {
        return 0;
    }

    @Override
    public void clean() {
    }

    @Override
    public void addFirst(E element) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addLast(E element) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public E removeFirst() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E removeLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E getFirst() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E getLast() {
        // TODO Auto-generated method stub
        return null;
    }
}
