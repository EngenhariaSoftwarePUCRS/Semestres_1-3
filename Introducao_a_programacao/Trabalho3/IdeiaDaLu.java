/**
 * IdeiaDaLu
 */
import java.util.Random;
import java.util.Scanner;
public class IdeiaDaLu {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix = generateMatrix(matrix);
        boolean Break;
        int score = 0;
        do {
            printMatrix(matrix);
            System.out.println("Guess: ");
            int guess = new Scanner(System.in).nextInt();
            for (int i = 0; i < matrix.length; i++) {
                Break = false;
                for (int j = 0; j < matrix.length; j++) {
                    if (guess == matrix[i][j]) {
                        System.out.println("Achou");
                        score++;
                        matrix[i][j] = -1;
                        Break = true;
                        break;
                    }
                }
                if (Break)
                    break;
            }
        } while (score < 9);
    }
    
    private static int getRandom(int lowerBound, int upperBound) {
        Random r = new Random();
        int random = r.nextInt(upperBound - lowerBound+1) + lowerBound;
        return random;
    }

    private static int[][] generateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = getRandom(0, 9);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("[%d]\t", matrix[i][j]);
            }
            System.out.println();
        }
    }
}