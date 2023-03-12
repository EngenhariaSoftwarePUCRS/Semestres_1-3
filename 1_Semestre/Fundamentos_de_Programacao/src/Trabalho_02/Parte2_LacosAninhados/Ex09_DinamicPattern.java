package Trabalho_02.Parte2_LacosAninhados;

import java.util.Scanner;

public class Ex09_DinamicPattern {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int height, width;
        String caracter;
        System.out.print("Digite a altura do quadrilátero: ");
        height = input.nextInt();
        System.out.print("Digite a largura do quadrilátero: ");
        width = input.nextInt();
        input.nextLine();
        System.out.print("Digite o caracter que vai preencher o quadrilátero: ");
        caracter = input.nextLine();
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++)
                System.out.print(caracter);
            System.out.println();
        }
    }
}
