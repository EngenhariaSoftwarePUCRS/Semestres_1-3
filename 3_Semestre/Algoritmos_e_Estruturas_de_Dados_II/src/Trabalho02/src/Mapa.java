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
            Scanner sc = new Scanner(new File("src/Trabalho02/mapas/mapa1.txt"));
            String linhaUm = sc.nextLine();
            String[] arrayLinhaUm = (linhaUm.split(" "));
        
            int numeroDeColunas = Integer.parseInt(arrayLinhaUm[1]);
            int numeroDeLinhas = Integer.parseInt(arrayLinhaUm[0]);
        
            for (int i = 0; i < arrayLinhaUm.length; i++) {
                System.out.println(arrayLinhaUm[i]);
            }
        
            char[][] texto = new char[numeroDeLinhas][numeroDeColunas];
            vertices = new Vertice[numeroDeLinhas * numeroDeColunas];
            grafo = new Grafo(numeroDeLinhas * numeroDeColunas);
        
            int contador = 0;
        
            while (sc.hasNextLine()) {
                for (int i = 0; i < texto.length; i++) {
                    String linha = sc.nextLine();
                    for (int j = 0; j < texto[i].length; j++) {
                        texto[i][j] = linha.charAt(j);
                        Vertice v = new Vertice(contador, i, j, texto[i][j]);
                        contador++;
                        try {
                            int vertice = Integer.parseInt(String.valueOf(texto[i][j]));
                            this.pontos1a9[vertice - 1] = v;
                        } catch (NumberFormatException nfe) {
                            continue;
                        }
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
