package Aula05;

import java.util.Random;

public class Main {

    private static int contador = 0;

    public static void main(String[] args) {
        System.out.println("Com pesquisa direta: ");
        int[] meuVetorDezMil = bubbleSortV1(geraVetor(10000, 10000));
        // int[] meuVetorUmMilhao = bubbleSortV1(geraVetor(1000000, 1000000));
        System.out.println("Posição do número 100 no vetor: " + pesqDireta(meuVetorDezMil, 20));
        System.out.println("Quantidade de iterações em vetor de 10.000 posições: " + contador);
        contador = 0;
        // System.out.println("Posição do número 100 no vetor: " + pesqDireta(meuVetorUmMilhao, 100));
        // System.out.println("Quantidade de iterações em vetor de 1.000.000 posições: " + contador);
        // contador = 0;

        System.out.println("===============================================================");

        System.out.println("Com pesquisa binária: ");
        System.out.println("Posição do número 100 no vetor: " + binarySearch(meuVetorDezMil, 20));
        System.out.println("Quantidade de iterações em vetor de 10.000 posições: " + contador);
        contador = 0;
        // System.out.println("Posição do número 100 no vetor: " + binarySearch(meuVetorUmMilhao, 100));
        // System.out.println("Quantidade de iterações em vetor de 1.000.000 posições: " + contador);
        // contador = 0;
    }

    static int pesqDireta(int[] vet, int valor) {
        int res = -1, i;
        for (i = 0; ((i < vet.length) && (vet[i] != valor)); i++) {
            if (i < vet.length)
                res = i;
            contador++;
        }
        return res;
    }

    static int binarySearch(int[] v, int value) {
        int low = 0;
        int high = v.length - 1;
        int p = low + ((high - low) / 2);
        while (low <= high) {
            contador++;
            if (v[p] > value)
                high = p - 1;
            else if (v[p] < value)
                low = p + 1;
            else
                return p;
            p = low + ((high - low) / 2);
        }
        return -1;
    }

    public static int[] bubbleSortV1(int[] v) {
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v.length - 1; j++) {
                if (v[j] > v[j + 1])
                    v = troca(v, j, j + 1);
            }
        }
        return v;
    }

    public static void bubbleSortV2(int[] v) {
        boolean trocou = true;
        while (trocou) {
            trocou = false;
            for (int i = 0; i < v.length - 1; i++) {
                if (v[i] > v[i + 1]) {
                    troca(v, i, i + 1);
                    trocou = true;
                }
            }
        }
    }

    private static int[] troca(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
        return v;
    }

    public static int[] geraVetor(int nroElem, int lim) {
        int dummy;
        int[] res = null;
        int cont = 0;
        Random rnd = new Random(System.nanoTime() * System.currentTimeMillis());

        if (nroElem >= 0) {

            res = new int[nroElem];

            while (cont < nroElem) {
                dummy = rnd.nextInt(lim) + 1;
                dummy = rnd.nextInt(lim) + 1;
                res[cont++] = rnd.nextInt(lim) + 1;
            }
        }
        return res;
    }
}