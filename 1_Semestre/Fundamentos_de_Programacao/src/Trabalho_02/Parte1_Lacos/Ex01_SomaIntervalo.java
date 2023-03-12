package Trabalho_02.Parte1_Lacos;

// 1.Escreva um programa que recebe dois números a e b e acha a soma de todos os números entre a e b.
//    Faça seu programa funcionar até mesmo se a for maior do que b.

import java.util.Scanner;

public class Ex01_SomaIntervalo {
    public static void main(String[] args) {
        int a, b, qtdValores, soma = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Digite a: ");
        a = input.nextInt();
        System.out.print("Digite b: ");
        b = input.nextInt();

        if (a >= b) {
            qtdValores = a - b + 1;
            while (a >= b) {
                soma += b;
                b++;
            }
        } else {
            qtdValores = b - a + 1;
            while (b >= a) {
                soma += a;
                a++;
            }
        }

        System.out.printf("A soma entre os %d valores é: %d", qtdValores, soma);
    }
}