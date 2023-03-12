package Trabalho_02.Parte2_LacosAninhados;

import java.util.Scanner;

public class Ex12_TriangularPattern {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Escreva um valor: ");
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
