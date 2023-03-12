package Semana_11;

// Escreva um método que retorna a quantidade de vogais de uma String passada como argumento.

import java.util.Scanner;

public class Ex10_ContaVogais {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String palavra;
        int qtdVogais;

        System.out.print("Escreva qualquer coisa: ");
        palavra = input.nextLine();
        qtdVogais = contaVogais(palavra);

        System.out.printf("%s possui %d vogais", palavra, qtdVogais);
    }

    private static int contaVogais(String string) {
        int qtdVogais = 0;
        char letra;
        string = string.trim().toUpperCase();
        for (int i = 0; i < string.length(); i++) {
            letra = string.charAt(i);
            if (letra == 65 ||
                    letra == 69 ||
                    letra == 73 ||
                    letra == 79 ||
                    letra == 85 ||
                    letra == 193 ||
                    letra == 233 ||
                    letra == 243) {
                qtdVogais++;
            }
        }
        return qtdVogais;
    }
}