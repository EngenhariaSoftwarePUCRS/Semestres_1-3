package Semana_11;

// 5) O que o programa abaixo imprime?

public class Ex05 {
    private static int mystery(int n) {
        n++;
        n++;
        return n;
    }

    public static void main(String[] args) {
        int a = 5;
        System.out.println(mystery(a));
    }
}
