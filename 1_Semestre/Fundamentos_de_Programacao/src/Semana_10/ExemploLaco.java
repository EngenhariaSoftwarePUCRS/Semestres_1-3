package Semana_10;

import java.util.Scanner;

public class ExemploLaco {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numero = 1, soma = 0;

        while (numero > 0) {
            System.out.print("Digite um número diferente de zero: ");
            numero = input.nextInt();
            soma += numero;
        }

        System.out.printf("A soma é: %d%n", soma);

        doWhile();
    }

    public static void doWhile() {
        Scanner input = new Scanner(System.in);
        int numero = 0, soma = 0;

        do {
            System.out.print("Digite um número diferente de zero: ");
            numero = input.nextInt();
            soma += numero;
        } while (numero != 0);

        System.out.printf("A soma é: %d%n", soma);
    }
}
