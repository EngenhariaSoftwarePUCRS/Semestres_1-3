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
        int pos = 0, words = 0;
        // repete pra sempre
        while (1 == 1) {
            // se o caracter for um símbolo (espaço)
            while ((str[pos] < 33) || (str[pos] > 126)) {
                // passa para a próxima letra
                pos++;
                // vê se acabou a palavra
                if (pos >= size)
                    // devolve a quantidade de palavras
                    return words;
            }
            // se o caracter for uma letra
            while ((str[pos] > 32) && (str[pos] < 127)) {
                // passa para a próxima letra
                pos++;
                // vê se acabou a palavra
                if (pos >= size)
                    // devolve a quantidade de palavras + 1 (pra compensar a própria)
                    return words + 1;
            }
            // quando alternar de espaço para letra, aumenta uma palavra
            words++;
        }
    }
}