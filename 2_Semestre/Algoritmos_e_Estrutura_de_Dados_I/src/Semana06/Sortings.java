package Semana06;

public class Sortings {
    public static void main(String[] args) {
        Sorts s = new Sorts();
        int[] v = s.geraVetor(10000, 10000),
                v1 = v.clone(),
                v2 = v.clone(),
                v3 = v.clone(),
                v4 = v.clone(),
                v5 = v.clone();

        System.out.println("\nbubbleSort0");
        s.bubbleSort1(v1);
        System.out.println("Iteracoes: " + s.getIteracoes());
        System.out.println("ClockSec: " + s.getClockSec());
        System.out.println("Tamanho: " + v.length);
        s.resetCounters();

        System.out.println("\nbubbleSort1");
        s.bubbleSort2(v2);
        System.out.println("Instrucoes: " + s.getInstrucoes());
        System.out.println("Iteracoes: " + s.getIteracoes());
        System.out.println("ClockSec: " + s.getClockSec());
        System.out.println("Tamanho: " + v.length);
        s.resetCounters();

        System.out.println("\ninsertSort");
        s.insertSort(v3);
        System.out.println("Instrucoes: " + s.getInstrucoes());
        System.out.println("Iteracoes: " + s.getIteracoes());
        System.out.println("ClockSec: " + s.getClockSec());
        System.out.println("Tamanho: " + v.length);
        s.resetCounters();

        System.out.println("\nmergeSort");
        s.mergeSort(v4, 0, v4.length - 1);
        System.out.println("Instrucoes: " + s.getInstrucoes());
        System.out.println("Iteracoes: " + s.getIteracoes());
        System.out.println("ClockSec: " + s.getClockSec());
        System.out.println("Tamanho: " + v.length);
        s.resetCounters();

        System.out.println("\nquickSort");
        s.quickSort(v5, 0, v5.length - 1);
        System.out.println("Instrucoes: " + s.getInstrucoes());
        System.out.println("Iteracoes: " + s.getIteracoes());
        System.out.println("ClockSec: " + s.getClockSec());
        System.out.println("Tamanho: " + v.length);
        s.resetCounters();
    }
}
