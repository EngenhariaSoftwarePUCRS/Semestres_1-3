package Trabalho02;

public class Dijkstra {
    public int[] predecessor;
    public int[] distances;
    public boolean[] visited;
    private Graph graph;
    
    public Dijkstra(Graph graph) {
        this.graph = graph;
        int verticesAmount = graph.getVerticesAmount();
        predecessor = new int[verticesAmount];
        distances = new int[verticesAmount];
        visited = new boolean[verticesAmount];
        this.clear();
    }

    public int getDistance(int origin, int destination) {
        this.clear();

        PriorityQueue visitingQueue = new PriorityQueue();
        visitingQueue.push(origin, 0);
        this.distances[origin] = 0;

        while (!visitingQueue.isEmpty()) {
            int vertex = visitingQueue.pop();
            this.visited[vertex] = true;
            for (int destinationVertex : graph.getAdjecencyListForVertex(vertex)) {
                int destinationDistance = this.distances[vertex] + 1;
                if (destinationDistance < this.distances[destinationVertex]) {
                    predecessor[destinationVertex] = vertex;
                    this.distances[destinationVertex] = destinationDistance;
                    if (!visitingQueue.exists(destinationVertex)) visitingQueue.push(destinationVertex, destinationDistance);
                    else visitingQueue.updateDistance(destinationVertex, destinationDistance);
                }
            }
        }

        return distances[destination];
    }

    public boolean isUnreachable(int destino) {
        return distances[destino] == Integer.MAX_VALUE;
    }

    private void clear() {
        for (int i = 0; i < graph.getVerticesAmount(); i++) {
            this.predecessor[i] = -1;
            this.distances[i] = Integer.MAX_VALUE;
            this.visited[i] = false;
        }
    }

    @Override
    public String toString() {
        String result = "vertice,antecessor,distancia,percorrido\n";
        for (int i = 0; i < graph.getVerticesAmount(); i++)
            result += (i + "," + predecessor[i] + "," + distances[i] + "," + visited[i] + "\n");
        return result;
    }
}
