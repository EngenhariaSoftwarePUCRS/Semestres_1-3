package Trabalho_02.Parte2_LacosAninhados;

public class Ex07_Somas {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++)
                System.out.println(i + j);
            System.out.println();
        }
        System.out.println("O laço acima mostra a soma dos números 0, 1 e 2 com os números de 0-3");
    }
}
