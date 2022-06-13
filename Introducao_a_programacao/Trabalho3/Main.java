
/**
 O objetivo desse trabalho é criar um jogo que permita a disputa entre dois jogadores (jogador 1 e
jogador 2).
O jogo consiste em adivinhar os números de uma matriz de inteiros n x m. O programa (jogo) deve
começar sorteando os números entre um limite mínimo e máximo, por exemplo, números de 1 a 10.
Os números sorteados deverão compor a matriz n x m definida. Tanto os limites mínimo e máximo
dos números quanto a quantidade de linhas e colunas da matriz podem ser colocadas direto no código
através do uso de constantes (não utilizar variável para essa finalidade).
Uma vez sorteada a matriz o jogo começa a solicitar aos jogadores a escolha de um número e verificar
se existe na matriz. Deve ser solicitado um número de cada vez para cada jogador de forma alternada.
Caso o número exista na matriz o programa exibe a mensagem de que ele acertou um número, caso
contrário de que errou. A cada rodada o jogo mostra o placar com a quantidade de números
descobertos de cada usuário. Cada número descoberto conta um ponto para o usuário que acertou.
O número descoberto deixa de ser verificado nas próximas rodadas.
O jogo termina quando não tiver mais nenhum número a ser descoberto na matriz.
Nesse momento o jogo deve verificar o jogador com mais pontos e mostrar o vencedor. Caso eles
tenham a mesma pontuação o jogo termina em empate.
 */
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] players = getPlayers(input);
        int lineAmount = getLineAmount(input);
        int columnAmount = getColumnAmount(input);
        int lowerBound = getLowerBound(input);
        int upperBound = getUpperBound(input);
        int i;
        int guess;
        int qtdJogadas = 0;
        int[][] matrix = populateMatrix(lineAmount, columnAmount, lowerBound, upperBound);
        int[] valoresMatrix = getValues(matrix, lineAmount, columnAmount);
        int[] scores = new int[players.length];
        boolean acertou;

        while (notEmpty(valoresMatrix)) {
            acertou = false;
            i = qtdJogadas % players.length;
            System.out.printf("%n%s, ", players[i]);
            guess = getGuess(lowerBound, upperBound, input);

            if (guess == -1)
                break;

            for (int valor : valoresMatrix) {
                if (guess == valor) {
                    System.out.println("Parabéns! Você ganhou um ponto.");
                    removeFrom(valoresMatrix, valor, true);
                    scores[i] += 1;
                    acertou = true;
                    break;
                }
            }

            if (!acertou) {
                System.out.println("Infelizmente, não foi dessa vez.");
            }

            qtdJogadas++;
            finalScore(qtdJogadas, players, scores);
        }

        finalScore(players, scores);
        // printMatrix(matrix, lineAmount, columnAmount);
    }

    private static void printMatrix(int[][] matrix, int lineAmount, int columnAmount) {
        for (int i = 0; i < lineAmount; i++) {
            for (int j = 0; j < columnAmount; j++) {
                System.out.printf("[%d]\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static String[] orderPodium(String[] players, int[] scores) {
        int maior;
        int[] orderedScores = new int[scores.length];
        String[] orderedPlayers = new String[players.length];

        for (int i = 0; i < scores.length; i++) {
            maior = -1;
            for (int j = 0; j < scores.length; j++) {
                if (scores[j] >= maior) {
                    maior = scores[j];
                }
            }
            orderedScores[i] = maior;
            orderedPlayers[i] = players[indexOf(maior, scores)];
            removeFrom(scores, maior, false);
        }
        returnTo(scores, orderedScores);

        return orderedPlayers;
    }

    private static int indexOf(int a, int[] array) {
        int i = 0;

        if (array == null)
            return -1;

        while (i < array.length) {
            if (array[i] == a)
                return i;
            else
                i += 1;
        }

        return -1;
    }

    private static void finalScore(String[] players, int[] scores) {
        players = orderPodium(players, scores);

        System.out.println("/======================================\\");
        System.out.println("\tPLACAR FINAL\t");
        for (int i = 0; i < players.length; i++) {
            System.out.printf("| %dº lugar: %s, com %d pontos. %n", i + 1, players[i], scores[i]);
        }
        System.out.println("\\======================================/");
    }

    private static void finalScore(int qtdJogadas, String[] players, int[] scores) {
        System.out.println("Rodada: " + qtdJogadas);
        for (int i = 0; i < players.length; i++) {
            System.out.printf("%s tem %d pontos.%n", players[i], scores[i]);
        }
    }

    private static void returnTo(int[] vector, int[] newVector) {
        for (int i = 0; i < vector.length; i++)
            vector[i] = newVector[i];

    }

    private static void removeFrom(int[] vector, int value, boolean all) {
        for (int i = 0; i < vector.length; i++) {
            if (value == vector[i]) {
                vector[i] = -1;
                if (!all)
                    break;
            }
        }
    }

    private static int getGuess(int lowerBound, int upperBound, Scanner input) {
        int guess;

        do {
            System.out.printf("digite um número entre %d e %d: ", lowerBound, upperBound);
            guess = input.nextInt();
        } while ((guess < lowerBound || guess > upperBound) && (guess != -1));

        return guess;
    }

    private static boolean notEmpty(int[] vetor) {
        for (int i : vetor) {
            if (i != -1)
                return true;
        }
        return false;
    }

    private static int[] getValues(int[][] matrix, int lineAmount, int columnAmount) {
        int k = 0;
        int[] valoresMatrix = new int[lineAmount * columnAmount];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                valoresMatrix[k] = matrix[i][j];
                k++;
            }
        }

        return valoresMatrix;
    }

    private static int getRandom(int lowerBound, int upperBound) {
        Random r = new Random();
        return r.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    private static int[][] populateMatrix(int lineAmount, int columnAmount, int lowerBound, int upperBound) {
        int[][] matrix = new int[lineAmount][columnAmount];

        for (int i = 0; i < lineAmount; i++) {
            for (int j = 0; j < columnAmount; j++) {
                matrix[i][j] = getRandom(lowerBound, upperBound);
            }
        }

        return matrix;
    }

    private static int getUpperBound(Scanner input) {
        System.out.print("Digite o maior valor que você quer na matriz: ");
        return input.nextInt();
    }

    private static int getLowerBound(Scanner input) {
        System.out.print("Digite o menor valor que você quer na matriz: ");
        return input.nextInt();
    }

    private static int getColumnAmount(Scanner input) {
        System.out.print("Digite a quantidade de colunas da matriz: ");
        return input.nextInt();
    }

    private static int getLineAmount(Scanner input) {
        System.out.print("Digite a quantidade de linhas da matriz: ");
        return input.nextInt();
    }

    private static String[] getPlayers(Scanner input) {
        int qtdJogadores;
        String[] players;

        System.out.print("Digite a quantidade de jogadores: ");
        qtdJogadores = input.nextInt();
        players = new String[qtdJogadores];
        int i = 0;
        input.nextLine();
        while (i < qtdJogadores) {
            System.out.printf("Digite o nome do %dº jogador: ", i + 1);
            players[i] = input.nextLine();
            i++;
        }

        return players;
    }
}