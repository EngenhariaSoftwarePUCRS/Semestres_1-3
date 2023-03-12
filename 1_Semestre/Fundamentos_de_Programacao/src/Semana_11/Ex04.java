package Semana_11;

// 4) O que o programa abaixo imprime?

public class Ex04 {
    private static int mystery(int x) {
        int y = x * x;
        return y;
    }

    public static void main(String[] args) {
        int a = 4;
        System.out.println(mystery(a + 1));
    }
}
