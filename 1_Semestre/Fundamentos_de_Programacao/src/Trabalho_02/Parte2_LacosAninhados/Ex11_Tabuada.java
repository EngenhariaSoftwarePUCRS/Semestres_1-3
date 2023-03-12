package Trabalho_02.Parte2_LacosAninhados;

public class Ex11_Tabuada {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++)
                System.out.printf("%d x %d = %d%n", i, j, i * j);
            System.out.println();
        }
    }
}
