package Aula_11;

import java.util.Scanner;

public class ContaCaracteres {
    public static void main(String[] args) {
        String palavra;
        int qtdPalavras;
        int qtdCaracteres;

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Escreva uma palavra/frase: ");
            palavra = input.nextLine();
            qtdPalavras = (palavra.length()) - (palavra.replaceAll(" ", "").length()) + 1;
            qtdCaracteres = palavra.replaceAll(" ", "").length();

            System.out.println("Quantidade de caracteres: " + qtdCaracteres);
            System.out.println("Quantidade de palavras: " + qtdPalavras);
        }
    }
}
