package Semana_11;

// Escreva um método que recebe um número inteiro positivo e determina se o mesmo é primo ou não.
// Use um valor booleano true como retorno quando o número for primo e false caso contrário.
// Lembre-se que todos números primos são positivos e que o número 1 não é primo.

import java.util.Scanner;

public class Ex12_Primalidade {
    public static void main(String[] args) {
        int n;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Digite um número inteiro: ");
            n = input.nextInt();

            if (n != 0) {
                if (ePrimo(n)) {
                    System.out.println(n + " é primo");
                } else {
                    System.out.println(n + " não é primo");
                }
            } else {
                do {
                    System.out.print("Digite um número inteiro (não nulo): ");
                    n = input.nextInt();
                } while (n == 0);
                if (ePrimo(n)) {
                    System.out.println(n + " é primo");
                } else {
                    System.out.println(n + " não é primo");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            System.out.println("(Apenas números inteiros são aceitos.)");
        }
    }

    private static boolean ePrimo(int n) {
        boolean divisivelPorUm = true;
        return divisivelPorUm && divisivelApenasPorEleMesmo(n);
    }

    private static boolean divisivelApenasPorEleMesmo(int n) {
        int qtdDivisores = 0;

        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    qtdDivisores++;
                }
            }
        } else {
            for (int j = -1; j >= n; j--) {
                if (n % j == 0) {
                    qtdDivisores++;
                }
            }
        }

        return qtdDivisores == 2;
    }
}