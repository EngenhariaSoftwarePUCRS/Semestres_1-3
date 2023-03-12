package Trabalho_02.Parte2_LacosAninhados;

public class Ex08_StaticPattern {
    public static void main(String[] args) {
        int largura = 4, altura = 4;
        for (int i = 0; i < largura; i++) {
            for (int j = 0; j < altura; j++)
                System.out.print("[]");
            System.out.println();
        }
    }
}
