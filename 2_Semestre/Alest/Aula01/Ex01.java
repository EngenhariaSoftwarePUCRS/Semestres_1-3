/*
    1. Construa um método que:
    a. Receba um inteiro n e retorne um String com
    todos os inteiros de 0 até n;
    b. Receba um inteiro n e retorne um array com
    todos os inteiros de 0 até n;
    c. Receba um número e retorne true se este
    número for primo, false caso contrário;
    d. Receba dois inteiros e retorne um array com
    todos os primos entre estes números.
*/

public class Ex01 {
    public static void main(String[] args) {

        // Letra A:
        for (int i = 0; i < 13; i++) {
            System.out.println(letraA(i));
        }

        // Letra B:
        int[] inteiros = letraB(13);
        for (int i : inteiros) {
            System.out.printf("[%d] ", i);
        }
        System.out.println();
        
        // Letra C:
        for (int i = 0; i < 13; i++) {
            System.out.println(i + " é primo? -> " + letraC(i));
        }

        // Letra D:
        int[] primos = letraD(1, 13);
        for (int p : primos) {
            if (p != 0)
                System.out.printf("[%d] ", p);
        }
    }

    public static String letraA(int n) {
        String resultado = "";

        for (int i = 0; i <= n; i++) {
            resultado += i;
        }

        return resultado;
    }

    public static int[] letraB(int n) {
        int maior = n > 0 ? n : 0;
        int inicial = maior == n ? 0 : n;
        int[] resultado = new int[n + 1];

        int i = 0;
        for (int j = inicial; j <= maior; j++) {
            resultado[i] = j;
            i++;
        }

        return resultado;
    }

    public static boolean letraC(int n) {
        return ePrimo(n);
    }

    public static int[] letraD(int a, int b) {
        int menor = a, maior = b;
        int[] resultado;

        if (a > b) {
            maior = a;
            menor = b;
        }

        resultado = new int[maior];

        int i = 0;
        while (menor <= maior) {
            if (ePrimo(menor))
                resultado[i] = menor;
           i++;
            menor++;
        }

        return resultado;
    }

    private static boolean ePrimo(int n) {
        int divisores = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                divisores++;
        }
        if (divisores == 2) return true;
        return false;
    }
}