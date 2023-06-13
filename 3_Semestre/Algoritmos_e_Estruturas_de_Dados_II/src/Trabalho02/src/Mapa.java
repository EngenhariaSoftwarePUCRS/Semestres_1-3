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

    public Mapa(String fileName, int harbourAmount) {
        String filePath = "src/Trabalho02/mapas/" + fileName + ".txt";
        harbours = new int[harbourAmount];
        readFile(filePath);
        linkEdges();
        navigate();
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
                        this.harbours[vertice - 1] = counter;
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

    private void navigate() {
        int[] distances = new int[harbours.length];
        for (int harbour = 0; harbour < harbours.length - 1; harbour++) {
            Dijkstra dijkstra = new Dijkstra(grafo, harbour);
            distances[harbour] = dijkstra.getDistancia(harbour + 1);
            dijkstra.imprimirResultado();
        }
    }
}
