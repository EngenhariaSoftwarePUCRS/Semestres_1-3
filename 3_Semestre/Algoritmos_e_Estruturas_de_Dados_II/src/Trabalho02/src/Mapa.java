package Trabalho02.src;
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
    private int further;
    private long startTime;

    public Mapa(String fileName, int harbourAmount) {
        String filePath = "src/Trabalho02/mapas/" + fileName + ".txt";
        harbours = new int[harbourAmount + 1];
        distances = new int[harbours.length];

        startTime = System.currentTimeMillis();

        System.out.println("\nCarregando mapa...");
        readFile(filePath);
        System.out.println("Mapa carregado com sucesso!");

        System.out.println("\nEstabelecendo conexões...");
        linkEdges();
        System.out.println("Conexões estabelecidas com sucesso!");

        System.out.println("\nCalculando distâncias...");
        navigate(1, 2);
        Dijkstra dijkstra = new Dijkstra(grafo, harbours[further]);
        distances[1] = dijkstra.getDistancia(harbours[1]);
        System.out.println("Distâncias calculadas com sucesso!\n");

        showDistances();

        long endTime = System.currentTimeMillis();
        System.out.println("\nTempo de execução: " + (endTime - startTime) + "ms");
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
            further = destination;
            navigate(destination, destination + 1);
        }
    }

    private void showDistances() {
        System.out.println("Distâncias: ");
        for (int i = 2; i < distances.length; i++) {
            if (distances[i] == Integer.MAX_VALUE)
                System.out.println("Não é possível chegar ao porto " + i);
            else
                System.out.println("Distância pro porto " + (i) + ": " + distances[i]);
        }
        System.out.println("Distância pro porto " + (1) + ": " + distances[1]);
        System.out.println("Distância total: " + getDistances());
    }

    private int getDistances() {
        int sum = 0;
        for (int i = 1; i < distances.length; i++)
            if (distances[i] != Integer.MAX_VALUE)
                sum += distances[i];
        return sum;
    }
}
