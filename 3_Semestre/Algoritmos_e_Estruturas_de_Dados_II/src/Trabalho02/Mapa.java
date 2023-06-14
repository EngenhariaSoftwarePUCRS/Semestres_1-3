package Trabalho02;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mapa {
    private int lineAmount;
    private int columnAmount;
    private Grafo grafo;
    private char[][] worldMap;
    private int[] harbours;
    private int[] distances;
    private int furthest;

    public Mapa(String fileName, int harbourAmount) {
        String filePath = "src/Trabalho02/mapas/" + fileName + ".txt";
        harbours = new int[harbourAmount + 1];
        distances = new int[harbours.length];

        System.out.print("Carregando mapa...");
        readFile(filePath);
        Util.clear("Carregando mapa...");
        System.out.println("Mapa carregado com sucesso!");

        System.out.print("Estabelecendo conexões...");
        linkEdges();
        Util.clear("Estabelecendo conexões...");
        System.out.println("Conexões estabelecidas com sucesso!");

        System.out.print("Calculando distâncias...");
        navigate(1, 2);
        Dijkstra dijkstra = new Dijkstra(grafo, harbours[furthest]);
        distances[1] = dijkstra.getDistancia(harbours[1]);
        Util.clear("Calculando distâncias...");
        System.out.println("Distâncias calculadas com sucesso!\n");

        getDistances();
    }

    /*
     * Construtor para testes
     * @param fileName Nome do arquivo de mapa
     * @param harbourAmount Quantidade de portos
     * @param test Flag para indicar que o construtor é para testes (sempre true)
     * @return void
     */
    public Mapa(String fileName, int harbourAmount, boolean test) {
        String filePath = "src/Trabalho02/mapas/" + fileName + ".txt";
        harbours = new int[harbourAmount + 1];
        distances = new int[harbours.length];
        readFile(filePath);
        linkEdges();
        navigate(1, 2);
        Dijkstra dijkstra = new Dijkstra(grafo, harbours[furthest]);
        distances[1] = dijkstra.getDistancia(harbours[1]);
    }

    private void readFile(String filePath) {
        try {
            Scanner sc = new Scanner(new File(filePath));
            String[] header = sc.nextLine().split(" ");
        
            lineAmount = Integer.parseInt(header[0]);
            columnAmount = Integer.parseInt(header[1]);
        
            worldMap = new char[lineAmount][columnAmount];
            grafo = new Grafo(lineAmount * columnAmount);
        
            int counter = 0;
            for (int i = 0; sc.hasNextLine(); i++) {
                String line = sc.nextLine();
                for (int j = 0; j < columnAmount; j++) {
                    char value = line.charAt(j);
                    worldMap[i][j] = value;
                    try {
                        int vertice = Integer.parseInt(String.valueOf(worldMap[i][j]));
                        this.harbours[vertice] = counter;
                    } catch (NumberFormatException nfe) {
                    }
                    counter++;
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Arquivo não encontrado!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void linkEdges() {
        for (int i = 0; i < lineAmount; i++)
            for (int j = 0; j < columnAmount; j++) {
                if (worldMap[i][j] == '*') continue;

                // Olha pra cima
                if (i > 0 && worldMap[i - 1][j] != '*') {
                    grafo.adicionarAresta(
                        (i * columnAmount) + j,
                        ((i - 1) * columnAmount) + j
                    );
                }
                // Olha pra baixo
                if (i < lineAmount - 1 && worldMap[i + 1][j] != '*') {
                    grafo.adicionarAresta(
                        (i * columnAmount) + j,
                        ((i + 1) * columnAmount) + j
                    );
                }
                // Olha pra esquerda
                if (j > 0 && worldMap[i][j - 1] != '*') {
                    grafo.adicionarAresta(
                        (i * columnAmount) + j,
                        (i * columnAmount) + (j - 1)
                    );
                }
                // Olha pra direita
                if (j < columnAmount - 1 && worldMap[i][j + 1] != '*') {
                    grafo.adicionarAresta(
                        (i * columnAmount) + j,
                        (i * columnAmount) + (j + 1)
                    );
                }
            }
    }

    private void navigate(int origin, int destination) {
        int limit = harbours.length - 1;
        if (origin == limit || destination > limit) return;

        Dijkstra dijkstra = new Dijkstra(grafo, harbours[origin]);
        distances[destination] = dijkstra.getDistancia(harbours[destination]);
        
        if (dijkstra.isUnreachable(harbours[destination])) {
            navigate(origin, destination + 1);
        } else {
            furthest = destination;
            navigate(destination, destination + 1);
        }
    }

    public String getDistances() {
        String result = "\tDistâncias: \n";
        for (int i = 2; i < distances.length; i++) {
            if (distances[i] == Integer.MAX_VALUE)
                result += "\t\tNão é possível chegar ao porto " + i + "\n";
            else
                result += "\t\tDistância para o porto " + i + ": " + distances[i] + "\n";
        }
        result += "\t\tDistância para o porto " + 1 + ": " + distances[1] + "\n";
        result += "\tDistância total: " + getAccumulatedDistance() + "\n";
        return result;
    }

    private int getAccumulatedDistance() {
        int sum = 0;
        for (int i = 1; i < distances.length; i++)
            if (distances[i] != Integer.MAX_VALUE)
                sum += distances[i];
        return sum;
    }
}
