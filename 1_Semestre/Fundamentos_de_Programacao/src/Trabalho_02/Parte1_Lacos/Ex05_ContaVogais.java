package Trabalho_02.Parte1_Lacos;

// 5.Escreva um programa que lê uma palavra e imprime o número de vogais da mesma.
//    Por exemplo, se o usuário digitar "Internacional", o programa imprime:  6 vogais

import java.util.Scanner;

public class Ex05_ContaVogais {
    final static char[] VOGAIS = {
            'A', 'E', 'I', 'O', 'U',
            'Á', 'É', 'Í', 'Ó', 'Ú',
            'Ã', 'Õ',
            'Â', 'Ê', 'Î', 'Ô', 'Û',
            'À', 'È', 'Ì', 'Ò', 'Ù',
            'a', 'e', 'i', 'o', 'u',
            'á', 'é', 'í', 'ó', 'ú',
            'ã', 'õ',
            'â', 'ê', 'î', 'ô', 'û',
            'à', 'è', 'ì', 'ò', 'ù'
    };

    public static void main(String[] args) {
        String palavra;
        int qtdVogais = 0;
        char caracter;
        Scanner input = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        palavra = input.nextLine();

        for (int i = 0; i < palavra.length(); i++) {
            caracter = palavra.charAt(i);
            if (contains(VOGAIS, caracter))
                qtdVogais++;
        }
        System.out.printf("Há %d vogais na palavra %n", qtdVogais);
    }

    private static boolean contains(char[] vetor, char caracter) {
        for (int i = 0; i < vetor.length; i++)
            if (vetor[i] == caracter)
                return true;

        return false;
    }
}
