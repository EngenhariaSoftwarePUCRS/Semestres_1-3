import java.util.Scanner;

/*
 * Escreva um programa que conta o numero de palavras ar-
mazenadas em uma string e apresenta o total no terminal. Como sugestao,
utilize a funcao abaixo como referencia para sua implementacao, a ser cha-
mada a partir do programa principal. Utilize duas strings na demonstracao
do funcionamento.
 */
public class Problema1 {
    public static void main(String[] args) {
        System.out.print("Sentence: ");
        String strStr = new Scanner(System.in).nextLine();
        char[] str = new char[strStr.length()];
        for (int i = 0; i < strStr.length(); i++)
            str[i] = strStr.charAt(i);
        System.out.println("Contains: " + count_words(str, str.length) + " words.");
    }

    static int count_words(char[] str, int size) {
        int i = 0, words = 0;
        while (1 == 1) {
            while ((str[i] < 33) || (str[i] > 126)) {
                i++;
                if (i >= size)
                    return words;
            }
            while ((str[i] > 32) && (str[i] < 127)) {
                i++;
                if (i >= size)
                    return words + 1;
            }
            words++;
        }
    }
}