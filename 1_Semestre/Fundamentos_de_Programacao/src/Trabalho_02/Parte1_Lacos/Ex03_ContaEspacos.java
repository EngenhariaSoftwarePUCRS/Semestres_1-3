package Trabalho_02.Parte1_Lacos;

// 3.Escreva um programa que leia uma frase de um usuário e retorna quantos espaços em branco existem nessa frase.

import java.util.Scanner;

public class Ex03_ContaEspacos {
    public static void main(String[] args) {
        String frase;
        char caracter;
        int qtdEspacos = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        frase = input.nextLine();

        frase = frase.toUpperCase();
        for (int i = 0; i < frase.length(); i++) {
            caracter = frase.charAt(i);
            if (caracter == ' ')
                qtdEspacos++;
        }
        System.out.printf("Há %d espaços na frase %n", qtdEspacos);
    }
}
