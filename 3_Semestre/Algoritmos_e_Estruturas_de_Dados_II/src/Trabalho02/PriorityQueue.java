package Trabalho02;

import java.util.ArrayList;

public class PriorityQueue {
    private class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    private ArrayList<Node> itens = new ArrayList<>();

    public PriorityQueue() {
        this.itens = new ArrayList<>();
    }

    public void push(int vertex, int distance) {
        Node n = new Node(vertex, distance);
        itens.add(n);
    }

    private Node getNode(int vertex) {
        for (Node n : itens)
            if (n.vertex == vertex) return n;
        return null;
    }

    public boolean exists(int vertex) {
        return getNode(vertex)!=null;
    }

    public boolean isEmpty() {
        return itens.isEmpty();
    }

    public void updateDistance(int vertex, int distance) {
        Node n = getNode(vertex);
        if(n == null) return;
        n.distance = distance;
    }

    public int pop() {
        if (itens.isEmpty()) return -1;
        Node shortest = new Node(-1, Integer.MAX_VALUE);

        for (int i = 0; i < itens.size(); i++) {
            Node n = itens.get(i);
            if(n.distance < shortest.distance)
                shortest = n;
        }

        int vertex = shortest.vertex;
        itens.remove(shortest);
        return vertex;
    }
}
