package Aula05;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] meuVetor = geraVetor(10000, 5000);
        binarySearch(meuVetor, 40);
    }

    static int binarySearch(int[] v, int value) {
        int low = 0;
        int high = v.length - 1;
        int p = low + ((high - low) / 2);
        while (low <= high) {
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

    public static void bubbleSortV1(int[] v) {
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v.length - 1; j++) {
                if (v[j] > v[j + 1])
                    troca(v, j, j + 1);
            }
        }
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

    private static void troca(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
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