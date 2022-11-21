package Semana07;

public class ColecaoEncadeada {
    private class Node {
        private Node refNext;
        private String item;

        public Node(String e) { setElement(e); }
        public void setElement(String e) { item = e; }
        public String getElement() { return item; }
        public void setNext(Node n) { refNext = n; }
        public Node getNext() { return refNext; }
    }
    
    private Node refHead = null;
    // private Node refTail = null;
    private int qtdElem = 0;
    public int size() { return qtdElem; }
    
    public void addFirst(String d) {
        Node novo = new Node(d);

        novo.setNext(refHead);
        refHead = novo;
        qtdElem++;
    }

    public String get(int pos){
        String res = null;
        Node aux;
        int i;
        
        if ((pos >= 0) && (pos < qtdElem)) {
            if(refHead != null) {
                aux = refHead;
                for(i = 1 ; i <= pos; i++)
                    aux = aux.getNext();
            
                res = aux.getElement();
            }
        } else 
            throw(new IndexOutOfBoundsException());
        
        return res;
    }

    public boolean addLast(String item) {
        return false;
    }
    
    public String toString() {
        String s = "";
        
        for(int i = 0; i < qtdElem; i++)
            s = s + get(i) + " ";
        
        return s;
    }
}
