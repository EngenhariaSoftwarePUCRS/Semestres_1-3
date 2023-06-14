package Trabalho02;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Map {
    private int[] harbours;
    private int[] distances;
    private int furthest;

    public Map(String fileName, int harbourAmount) {
        String filePath = "src/Trabalho02/mapas/" + fileName + ".txt";
        harbours = new int[harbourAmount + 1];
        distances = new int[harbours.length];
        
        try {
            Scanner fileScanner = new Scanner(new File(filePath));
            String loadingMessage = "Carregando mapa...";
            System.out.print(loadingMessage);
            HashMap<String, Integer> dimensions = getMapDimensions(fileScanner);
            char[][] worldMap = fillMap(fileScanner, dimensions);
            Util.clear(loadingMessage);
            System.out.println("Mapa carregado com sucesso!");

            loadingMessage = "Estabelecendo conexões...";
            System.out.print(loadingMessage);
            Graph graph = linkEdges(worldMap, dimensions);
            Util.clear(loadingMessage);
            System.out.println("Conexões estabelecidas com sucesso!");

            loadingMessage = "Calculando distâncias...";
            System.out.print(loadingMessage);
            Dijkstra dijkstra = new Dijkstra(graph);
            distances[1] = dijkstra.getDistance(harbours[furthest], harbours[1]);
            Util.clear(loadingMessage);
            System.out.println("Distâncias calculadas com sucesso!\n");
            System.out.println(getDistances());
        } catch (FileNotFoundException fnfe) {
            System.out.println("Arquivo não encontrado!");
        } catch (Exception e) {
            System.out.println("Houve um erro inesperado : (");
        }
    }

    /*
     * Construtor para testes
     * @param fileName Nome do arquivo de mapa
     * @param harbourAmount Quantidade de portos
     * @param test Flag para indicar que o construtor é para testes ("sempre" true)
     */
    public Map(String fileName, int harbourAmount, boolean test) {
        String filePath = "src/Trabalho02/mapas/" + fileName + ".txt";
        harbours = new int[harbourAmount + 1];
        distances = new int[harbours.length];
        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);
            HashMap<String, Integer> dimensions = getMapDimensions(fileScanner);
            char[][] worldMap = fillMap(fileScanner, dimensions);
            Graph graph = linkEdges(worldMap, dimensions);
            Dijkstra dijkstra = new Dijkstra(graph);
            navigate(dijkstra, 1, 2);
            distances[1] = dijkstra.getDistance(harbours[furthest], harbours[1]);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Arquivo não encontrado!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private HashMap<String, Integer> getMapDimensions(Scanner fileScanner) {
        HashMap<String, Integer> dimensions = new HashMap<>();
        String[] header = fileScanner.nextLine().split(" ");
        dimensions.put("lines", Integer.parseInt(header[0]));
        dimensions.put("columns", Integer.parseInt(header[1]));
        return dimensions;
    }

    private char[][] fillMap(Scanner fileScanner, HashMap<String, Integer> dimensions) {
        char[][] map;
        int lineAmount = dimensions.get("lines");
        int columnAmount = dimensions.get("columns");

        try {
            map = new char[lineAmount][columnAmount];
        
            int counter = 0;
            for (int i = 0; fileScanner.hasNextLine(); i++) {
                String line = fileScanner.nextLine();
                for (int j = 0; j < columnAmount; j++) {
                    char value = line.charAt(j);
                    map[i][j] = value;
                    try {
                        int vertice = Integer.parseInt(String.valueOf(map[i][j]));
                        this.harbours[vertice] = counter;
                    } catch (NumberFormatException nfe) {
                    }
                    counter++;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler o arquivo!");
        } finally {
            fileScanner.close();
        }

        return map;
    }

    private Graph linkEdges(char[][] worldMap, HashMap<String, Integer> dimensions) {
        int lineAmount = dimensions.get("lines");
        int columnAmount = dimensions.get("columns");
        Graph graph = new Graph(lineAmount * columnAmount);

        for (int i = 0; i < lineAmount; i++)
            for (int j = 0; j < columnAmount; j++) {
                if (worldMap[i][j] == '*') continue;
                int origin = (i * columnAmount) + j;

                // Olha pra cima
                if (i > 0 && worldMap[i - 1][j] != '*') {
                    graph.insertEdge(origin,
                        ((i - 1) * columnAmount) + j
                    );
                }
                // Olha pra baixo
                if (i < lineAmount - 1 && worldMap[i + 1][j] != '*') {
                    graph.insertEdge(origin,
                        ((i + 1) * columnAmount) + j
                    );
                }
                // Olha pra esquerda
                if (j > 0 && worldMap[i][j - 1] != '*') {
                    graph.insertEdge(origin,
                        (i * columnAmount) + (j - 1)
                    );
                }
                // Olha pra direita
                if (j < columnAmount - 1 && worldMap[i][j + 1] != '*') {
                    graph.insertEdge(origin,
                        (i * columnAmount) + (j + 1)
                    );
                }
            }

        return graph;
    }

    private void navigate(Dijkstra dijkstra, int origin, int destination) {
        int limit = harbours.length - 1;
        if (origin == limit || destination > limit) return;

        distances[destination] = dijkstra.getDistance(harbours[origin], harbours[destination]);

        if (dijkstra.isUnreachable(harbours[destination])) {
            navigate(dijkstra, origin, destination + 1);
        } else {
            furthest = destination;
            navigate(dijkstra, destination, destination + 1);
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
