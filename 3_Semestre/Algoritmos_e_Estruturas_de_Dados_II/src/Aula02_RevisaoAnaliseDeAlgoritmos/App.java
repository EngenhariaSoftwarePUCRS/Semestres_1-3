package Aula02_RevisaoAnaliseDeAlgoritmos;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    // Exercício 1
    // FA é mais complexo que FB?

    int FA(int n) {
        int r;
        r = n * 2;
        r = (int) Math.pow(r, n);
        return r;
    }

    int FB(int n) {
        int r = 1;
        for (int i = 0; i < n; i++)
            r = n * 2;
        return r;
    }

    // Exercício 2
    // Parte I: 4 operações
    int j = 0;
    int i = 3;
    int r = j + i;

    // Parte II: 4n operações
    int FX(int n) {
        int j, i, r = 0;
        for (int a = 0; a < n; a++) {
            j = 0;
            i = 3;
            r = j + i;
        }
        return r;
    }
}
