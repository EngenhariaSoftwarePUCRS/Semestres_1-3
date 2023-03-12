package Trabalho_02.Parte2_LacosAninhados;

public class Ex10_TabelaMultiplicacao {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (i * j < 10)
                    System.out.print(0);
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }
}
