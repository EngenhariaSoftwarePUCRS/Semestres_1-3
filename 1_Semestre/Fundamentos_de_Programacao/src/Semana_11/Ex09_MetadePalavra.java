package Semana_11;

// Escreva uma método que retorna o caractere do meio de uma String passada como parâmetro.
// Se a String tem tamanho par, então existem dois caracteres no meio, o método deve retornar o caractere da esquerda.

import java.util.Scanner;

public class Ex09_MetadePalavra {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        String palavra = input.nextLine();
        System.out.println(miolo(palavra));
    }

    private static String miolo(String string) {
        int tamanho = string.length();
        if (tamanho % 2 == 0) {
            return string.substring(tamanho / 2 - 1, tamanho / 2);
        }
        return string.substring(tamanho / 2, tamanho / 2 + 1);
    }
}