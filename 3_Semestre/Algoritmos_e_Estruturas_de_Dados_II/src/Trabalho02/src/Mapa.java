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
        harbours = new int[harbourAmount + 1];
        System.out.println("\nCarregando mapa...");
        readFile(filePath);
        System.out.println("Mapa carregado com sucesso!");
        System.out.println("\nEstabelecendo conexões...");
        linkEdges();
        System.out.println("Conexões estabelecidas com sucesso!");
        System.out.println("\nCalculando distâncias...");
        navigate();
        System.out.println("Distâncias calculadas com sucesso!\n");
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

    private void navigate() {
        int[] distances = new int[harbours.length + 1];
        for (int harbourNumber = 1; harbourNumber < harbours.length - 1; harbourNumber++) {
            Dijkstra dijkstra = new Dijkstra(grafo, harbours[harbourNumber]);
            distances[harbourNumber + 1] = dijkstra.getDistancia(harbours[harbourNumber + 1]);
        }

        System.out.println("Distâncias: ");
        for (int i = 0; i < distances.length; i++)
            System.out.println("Distância do porto " + (i + 1) + ": " + distances[i]);
    }
}
