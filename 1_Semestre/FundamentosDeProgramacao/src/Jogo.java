import java.util.Random;
import java.util.Scanner;
public class Jogo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] players = {"Player 1", "Player 2"};
        int lineAmount = 3;
        int columnAmount = 3;
        int lowerBound = 0;
        int upperBound = 9;
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
            if (i % qtdJogadas == 0) {
                finalScore(qtdJogadas, players, scores);
            }
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
    private static void finalScore(String[] players, int[] scores) {
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
}