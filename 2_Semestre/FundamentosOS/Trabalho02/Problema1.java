/*
 * Escreva um programa que conta o numero de palavras ar-
mazenadas em uma string e apresenta o total no terminal. Como sugestao,
utilize a funcao abaixo como referencia para sua implementacao, a ser cha-
mada a partir do programa principal. Utilize duas strings na demonstracao
do funcionamento.
 */

public class Problema1 {
    public static void main(String[] args) {
        String frase = "Tenho 4 palavras.";
        char[] str = new char[frase.length()];
        for (int i = 0; i < frase.length(); i++)
            str[i] = frase.charAt(i);
        int qtdPalavrasFrase = countWords(str, str.length);
        System.out.println("Quantidade de palavras na frase: " + qtdPalavrasFrase);
    }

    static int countWords(char[] str, int size) {
        int pos = 0;
        int words = 0;
        while (true) {
            while ((str[pos] < 33) || (str[pos] > 126)) {
                pos++;
                if (pos >= size)
                    return words;
            }
            while ((str[pos] > 32) && (str[pos] < 127)) {
                pos++;
                if (pos >= size)
                    return words + 1;
            }
            words++;
        }
    }
}