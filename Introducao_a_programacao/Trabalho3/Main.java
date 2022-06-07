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
        int lineAmount = getLineAmount(input);
        int columnAmount = getColumnAmount(input);
        int lowerBound = getLowerBound(input);
        int upperBound = getUpperBound(input);
        int guess;
        int score = 0;
        int[][] matrix;
        int[] valoresMatrix;

        matrix = populateMatrix(lineAmount, columnAmount, lowerBound, upperBound);
        valoresMatrix = getValues(matrix, lineAmount, columnAmount);

        printMatrix(matrix, lineAmount, columnAmount);
        do {
            guess = getGuess(lowerBound, upperBound, input);
            boolean Break = false;
            for (int i = 0; i < lineAmount; i++) {
                for (int j = 0; j < columnAmount; j++) {
                    if (guess == matrix[i][j]) {
                        System.out.println("Parabéns! Você ganhou um ponto. ");
                        score++;
                        matrix[i][j] = -1;
                        Break = true;
                        break;
                    }
                    if (Break)
                        break;
                }
            }
        } while (score < 9);
    }

    private static int getGuess(int lowerBound, int upperBound, Scanner input) {
        int guess;
        do {
            System.out.printf("Digite um número entre %d e %d: ", lowerBound, upperBound);
            guess = input.nextInt();
        } while (guess < lowerBound || guess > upperBound);
        return guess;
    }

    private static int[] getValues(int[][] matrix, int lineAmount, int columnAmount) {
        int[] valoresMatrix = new int[lineAmount*columnAmount];
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                valoresMatrix[k] = matrix[i][j];
                k++;
            }
        }
        return valoresMatrix;
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

    private static void printMatrix(int[][] matrix, int lineAmount, int columnAmount) {
        for (int i = 0; i < lineAmount; i++) {
            for (int j = 0; j < columnAmount; j++) {
                System.out.printf("[%d]\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int getRandom(int lowerBound, int upperBound) {
        Random r = new Random();
        int random = r.nextInt(upperBound - lowerBound+1) + lowerBound;
        return random;
    }

    private static int getLineAmount(Scanner input) {
        System.out.print("Digite a quantidade de linhas da matriz: ");
        return input.nextInt();
    }

    private static int getColumnAmount(Scanner input) {
        System.out.print("Digite a quantidade de colunas da matriz: ");
        return input.nextInt();
    }

    private static int getLowerBound(Scanner input) {
        System.out.print("Digite o menor valor que você quer na matriz: ");
        return input.nextInt();
    }

    private static int getUpperBound(Scanner input) {
        System.out.print("Digite o maior valor que você quer na matriz: ");
        return input.nextInt();
    }
}