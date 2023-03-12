package Semana_11;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        // a)
        System.out.println(maior(1, 2));

        // b)
        for (double a = 1; a <= 3; a++) {
            for (double b = 1; b <= 3; b++) {
                for (double c = 1; c <= 3; c++) {
                    System.out.printf("a: %.0f, b: %.0f, c: %.0f %n", a, b, c);
                    System.out.println(menor(a, b, c));
                    System.out.println("-----------------");
                }
            }
        }

        // c)
        Scanner input = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        int n = input.nextInt();

        if (n != 0) {
            if (ePrimo(n)) {
                System.out.println(n + " é primo");
            } else {
                System.out.printf("O número (%d) inserido não é primo. %n", n);
            }
        } else {
            do {
                System.out.print("Digite um número inteiro (não nulo): ");
                n = input.nextInt();
            } while (n == 0);
            if (ePrimo(n)) {
                System.out.println(n + " é primo");
            } else {
                System.out.printf("O número (%d) inserido não é primo. %n", n);
            }
        }

        // d)
        System.out.println(stringsContida("Primeira", "está contida?"));

        // e)
        System.out.println(saldoFinal(1000, 0.05, 1));

        // g)
        System.out.println(geraNumeroAleatorio(10));
    }

    // a) Calcula o maior de dois inteiros.
    private static int maior(int a, int b) {
        if (a >= b)
            return a;
        else
            return b;
    }

    // b) Calcula o menor entre três números em ponto-flutuante.
    private static double menor(double x, double y, double z) {
        if (x <= y && x <= z)
            return x;
        else if (y <= x && y <= z)
            return y;
        else
            return z;
    }

    // c) Determina se um número inteiro é primo,
    // retornando true neste caso e false caso contrário.
    private static boolean ePrimo(int n) {
        boolean divisivelPorUm = true;
        return divisivelPorUm && divisivelApenasPorEleMesmo(n);
    }

    private static boolean divisivelApenasPorEleMesmo(int n) {
        int qtdDivisores = 0;
        if (n > 0) {
            for (int i = 1; i <= n; i++)
                if (n % i == 0)
                    qtdDivisores++;
        } else {
            for (int j = -1; j >= n; j--)
                if (n % j == 0)
                    qtdDivisores++;
        }

        return qtdDivisores == 2;
    }

    // d) Determina se uma string está contida dentro de uma outra string.
    private static boolean stringsContida(String primeira, String segunda) {
        return segunda.contains(primeira) || primeira.contains(segunda);
    }

    // e) Calcula o saldo final de uma conta a partir do saldo inicial, do
    // rendimento anual e da quantidade de anos de investimento.
    private static double saldoFinal(double saldoInicial, double rendimentoAnual, int anos) {
        double saldoFinal = saldoInicial;

        for (int i = 0; i < anos; i++)
            saldoFinal += saldoFinal * rendimentoAnual;

        return saldoFinal;
    }

    // g) Gera um número inteiro aleatório entre 1 e n.
    private static int geraNumeroAleatorio(int n) {
        return (int) (Math.random() * n) + 1;
    }

}
