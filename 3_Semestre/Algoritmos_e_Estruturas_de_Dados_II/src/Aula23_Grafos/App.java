package Aula23_Grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import aula19_grafos_implementacao.lista_adjacencia.GrafoListaAdjacencia;

public class App {
    public static void main(String[] args) {
        final int NUMERO_PESSOAS = 10;

        Map<String, Integer> pessoas = new HashMap<String, Integer>(NUMERO_PESSOAS);
            pessoas.put("mariana", 0);
            pessoas.put("lucas", 1);
            pessoas.put("alexandre", 2);
            pessoas.put("leonardo", 3);
            pessoas.put("rafaella", 4);
            pessoas.put("tito", 5);
            pessoas.put("teresa", 6);
            pessoas.put("joana", 7);
            pessoas.put("tales", 8);
            pessoas.put("anita", 9);
        
        GrafoListaAdjacencia grafo = new GrafoListaAdjacencia(NUMERO_PESSOAS);
        
        try {
            Scanner reader = new Scanner(new File("src/Aula23_Grafos/amizades_10.txt"));
            while (reader.hasNextLine()) {
                String[] linha = reader.nextLine().split(" -- ");
                int pessoa1 = pessoas.get(linha[0]);
                int pessoa2 = pessoas.get(linha[1]);
                grafo.adicionarAresta(pessoa1, pessoa2);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Arquivo não encontrado!");
        }

        int choice;
        Scanner reader = new Scanner(System.in);
        do {
            showMenu();
            choice = reader.nextInt();
            switch (choice) {
                case 1:
                    int maiorQuantidadeDeAmigos = -1;
                    List<Integer> maisAmigos = new ArrayList<Integer>(NUMERO_PESSOAS);

                    for (int pessoa = 0; pessoa < NUMERO_PESSOAS; pessoa++)
                        if (grafo.adjacentes(pessoa).size() > maiorQuantidadeDeAmigos)
                            maiorQuantidadeDeAmigos = grafo.adjacentes(pessoa).size();
            
                    for (int pessoa = 0; pessoa < NUMERO_PESSOAS; pessoa++)
                        if (grafo.adjacentes(pessoa).size() == maiorQuantidadeDeAmigos)
                            maisAmigos.add(pessoa);
                            
                    maisAmigos.stream()
                        .map(pessoa -> pessoa + " - " + pessoas.entrySet()
                                .stream()
                                .filter(entry -> entry.getValue() == pessoa)
                                .findFirst()
                                .get()
                                .getKey()
                            )
                        .forEach(System.out::println);
            
                    break;
                case 2:
                    int menorQuantidadeDeAmigos = NUMERO_PESSOAS + 1;
                    List<Integer> menosAmigos = new ArrayList<Integer>(NUMERO_PESSOAS);

                    for (int pessoa = NUMERO_PESSOAS - 1; pessoa >= 0; pessoa--)
                        if (grafo.adjacentes(pessoa).size() < menorQuantidadeDeAmigos)
                            menorQuantidadeDeAmigos = grafo.adjacentes(pessoa).size();
            
                    for (int pessoa = NUMERO_PESSOAS - 1; pessoa >= 0; pessoa--)
                        if (grafo.adjacentes(pessoa).size() == menorQuantidadeDeAmigos)
                            menosAmigos.add(pessoa);

                    menosAmigos.stream()
                        .map(pessoa -> pessoa + " - " + pessoas.entrySet()
                                .stream()
                                .filter(entry -> entry.getValue() == pessoa)
                                .findFirst()
                                .get()
                                .getKey()
                            )
                        .forEach(System.out::println);

                    break;
                case 3:
                    System.out.print("Digite o nome da pessoa: ");
                    String nome = reader.next().toLowerCase();
                    while (!pessoas.containsKey(nome)) {
                        System.out.println("Pessoa não encontrada!");
                        System.out.print("Digite o nome da pessoa: ");
                        nome = reader.next().toLowerCase();
                    }
                    int pessoa = pessoas.get(nome);
                    System.out.println("Amigos de " + nome + ":");
                    grafo.adjacentes(pessoa)
                            .stream()
                            .map(amigo -> amigo + " - " + pessoas.entrySet()
                                .stream()
                                .filter(entry -> entry.getValue() == amigo)
                                .findFirst()
                                .get()
                                .getKey()
                            )
                        .forEach(System.out::println);
                    // System.out.println("Distância: " + grafo.distancia?(pessoa));
                    // TODO
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (choice != 4 && choice >= 1 && choice <= 4);
        reader.close();
    }

    private static void showMenu() {
        System.out.println("=============== MENU ===============");
        System.out.println("1 - Listar pessoas com mais amigos");
        System.out.println("2 - Listar pessoas com menos amigos");
        System.out.println("3 - Listar amigos de X (e distância)");
        System.out.println("4 - Sair");
        System.out.println("====================================");
    }
}
