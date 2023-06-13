package Trabalho02.src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mapa {
    private Grafo grafo;
    private Vertice[] vertices;
    private Vertice[] pontos1a9 = new Vertice[9];
    private char[][] matrizMapa;

    public Mapa() {
        try {
            Scanner sc = new Scanner(new File("src/Trabalho02/mapas/mapinha.txt"));
            String linhaUm = sc.nextLine();
            String[] arrayLinhaUm = (linhaUm.split(" "));
        
            int numeroDeColunas = Integer.parseInt(arrayLinhaUm[1]);
            int numeroDeLinhas = Integer.parseInt(arrayLinhaUm[0]);
        
            matrizMapa = new char[numeroDeLinhas][numeroDeColunas];
            vertices = new Vertice[numeroDeLinhas * numeroDeColunas];
            grafo = new Grafo(numeroDeLinhas * numeroDeColunas);
        
            int contador = 0;
            while (sc.hasNextLine()) {
                for (int i = 0; i < matrizMapa.length; i++) {
                    String linha = sc.nextLine();
                    for (int j = 0; j < matrizMapa[i].length; j++) {
                        matrizMapa[i][j] = linha.charAt(j);
                        Vertice v = new Vertice(contador, i, j, matrizMapa[i][j]);
                        vertices[contador] = v;
                        contador++;
                        try {
                            int vertice = Integer.parseInt(String.valueOf(matrizMapa[i][j]));
                            this.pontos1a9[vertice - 1] = v;
                        } catch (NumberFormatException nfe) {
                            continue;
                        }
                    }
                }
            }

            for (int i = 0; i < numeroDeLinhas; i++) {
                for (int j = 0; j < numeroDeColunas; j++) {
                    if (matrizMapa[i][j] == '*') continue;

                    // Olha pra cima
                    if (i > 0 && matrizMapa[i - 1][j] != '*') {
                        grafo.adicionarAresta(
                            vertices[(i * numeroDeColunas) + j].getIndice(),
                            vertices[((i - 1) * numeroDeColunas) + j].getIndice()
                        );
                    }
                    // Olha pra baixo
                    if (i < numeroDeLinhas - 1 && matrizMapa[i + 1][j] != '*') {
                        grafo.adicionarAresta(
                            vertices[(i * numeroDeColunas) + j].getIndice(),
                            vertices[((i + 1) * numeroDeColunas) + j].getIndice()
                        );
                    }
                    // Olha pra esquerda
                    if (j > 0 && matrizMapa[i][j - 1] != '*') {
                        grafo.adicionarAresta(
                            vertices[(i * numeroDeColunas) + j].getIndice(),
                            vertices[(i * numeroDeColunas) + (j - 1)].getIndice()
                        );
                    }
                    // Olha pra direita
                    if (j < numeroDeColunas - 1 && matrizMapa[i][j + 1] != '*') {
                        grafo.adicionarAresta(
                            vertices[(i * numeroDeColunas) + j].getIndice(),
                            vertices[(i * numeroDeColunas) + (j + 1)].getIndice()
                        );
                    }
                }
            }

            int origem = pontos1a9[0].getIndice();
            Dijkstra dijkstra = new Dijkstra(grafo, origem);
            dijkstra.imprimirResultado(grafo);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Arquivo não encontrado!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
