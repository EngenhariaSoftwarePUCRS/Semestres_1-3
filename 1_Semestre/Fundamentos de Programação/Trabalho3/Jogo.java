import java.util.Scanner;

public class Jogo {

    public Jogo() {

        Scanner input = new Scanner(System.in);
        Difficulty difficulty = new Difficulty();
        Matriz matrix = difficulty.level();
        Players players = new Players(askForPlayers(input));

        int i;
        int j = 0;
        int guess;
        int qtdJogadas = 0;
        int[] tentativas = new int[(int)Math.pow(matrix.getMatrixValues().length, 2)];
        tentativas = populateVector(tentativas, tentativas.length);
        boolean acertou;

        while (notEmpty(matrix.getMatrixValues())) {
            acertou = false;
            i = qtdJogadas % players.getPlayersAmount();
            qtdJogadas++;
            System.out.printf("%n%s, ", players.getPlayers()[i]);
            //guess = matrix.getRandom(matrix.getLowerBound(), matrix.getUpperBound());
            guess = getGuess(matrix.getLowerBound(), matrix.getUpperBound(), input);
            tentativas[qtdJogadas-1] = guess;

            if (guess == -1)
                break;

            for (int valor : matrix.getMatrixValues()) {
                if (guess == valor) {
                    System.out.println("Parabéns! Você ganhou um ponto.");
                    removeFrom(matrix.getMatrixValues(), valor, true);
                    players.setScore(i, players.getScore(i) + 1);
                    acertou = true;
                    break;
                }
            }

            if (!acertou) {
                System.out.println("Infelizmente, não foi dessa vez.");
            }

            if (qtdJogadas % players.getPlayersAmount() == 0) {
                j++;
                printVector(tentativas);
                finalScore(j, players.getPlayers(), players.getScore());
            }
        }

        finalScore(players.getPlayers(), players.getScore());

        System.out.println("\n\n\nA matriz era: ");
        printMatrix(matrix.getMatrix(), matrix.getLineAmount(),
                matrix.getColumnAmount());
    }

    private static int[] populateVector(int[] vector, int length) {
        for (int i = 0; i < length; i++) {
            vector[i] = -1;
        }
        return vector;
    }

    private static void printVector(int[] vector) {
        for (int i : vector) {
            if (i != -1)
                System.out.printf("Valores tentados: [%d]%n", i);
        }
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

        System.out.println("\n/======================================\\");
        System.out.println("|\tPLACAR FINAL\t");
        for (int i = 0; i < players.length; i++) {
            System.out.printf("| %dº lugar: %s, com %d pontos. %n", i + 1, players[i], scores[i]);
        }
        System.out.println("\\======================================/");
    }

    private static void finalScore(int qtdJogadas, String[] players, int[] scores) {
        System.out.println("\nRodada: " + qtdJogadas);
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

    private static String[] askForPlayers(Scanner input) {
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