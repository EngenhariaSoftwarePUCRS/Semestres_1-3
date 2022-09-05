package Semana06;
public class Main {
    public static void main(String[] args) {
        Sorts s = new Sorts();
        int[] v = {4, 5, 32, 325, 23, 25, 6, 87, 4, 7},
            v1 = v.clone(),
            v2 = v.clone(),
            v3 = v.clone(),
            v4 = v.clone(),
            v5 = v.clone();

        s.bubbleSort0(v1);
        s.resetCounters();
        showAll(v1);

        s.bubbleSort1(v2);
        s.resetCounters();
        showAll(v2);

        s.insertSort(v3);
        s.resetCounters();
        showAll(v3);

        s.mergeSort(v4, 0, v4.length);
        s.resetCounters();
        showAll(v4);

        s.quickSort(v5, v5[0], v5[v5.length - 1]);
        s.resetCounters();
        showAll(v5);
    }

    private static void showAll(int[] v) {
        System.out.print("[");
        for (int i = 0; i < v.length - 1; i++) {
            System.out.print(v[i]+", ");
        }
        System.out.println(v[v.length - 1]+"]");
    }
}
