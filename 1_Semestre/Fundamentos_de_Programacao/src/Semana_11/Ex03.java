package Semana_11;

// 3) O que o programa abaixo imprime?

public class Ex03 {
    private static double mystery(int x, int y) {
        double z = x + y;
        z = z / 2.0;
        return z;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        System.out.println(mystery(a, b));
    }
}
