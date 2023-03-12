package Aula06;

public class QuickSort {
    public static void main(String[] args) {
        int[] v = { 6, 1, 12, 40, 1, 29, 2, 3, 17, 5 };
        quicksort(v, 0, 9);
    }

    static void quicksort(int[] v, int low, int high) {
        int pivot;
        if ((high - low) > 0) {
            pivot = partition(v, low, high);
            quicksort(v, low, pivot - 1);
            quicksort(v, pivot + 1, high);
        }
    }

    static int partition(int[] v, int low, int high) {
        int i, p, firsthigh;
        firsthigh = low;
        p = high;
        for (i = low; i < high; i++)
            if (v[i] < v[p]) {
                swap(v, i, firsthigh);
                firsthigh = firsthigh + 1;
            }
        swap(v, p, firsthigh);
        return firsthigh;
    }

    static void swap(int[] v, int p, int firsthigh) {
        int aux = v[p];
        v[p] = firsthigh;
        firsthigh = aux;
    }

}