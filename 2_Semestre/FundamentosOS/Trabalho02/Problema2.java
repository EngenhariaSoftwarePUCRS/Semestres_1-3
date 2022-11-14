/*
 * Considere uma sequencia de n numeros inteiros. Para esta
sequencia, determine um segmento de soma maxima e o valor dessa soma.
Por exemplo, para a sequencia de valores 5, 2, -2, -7, 3, 14, 10, -3, 9, -6, 4,
1, o segmento esta entre o ́ındices 4 e 8 e a soma dos valores desse segmento
e 33. Utilize dois vetores de numeros na demonstracao do funcionamento da
sua solucao.
 */

public class Problema2 {
    public static void main(String[] args) {
        int[] sequence = { 5, 2, -2, -7, 3, 14, 10, -3, 9, -6, 4, 1 };
        int[] segmento = { 4, 8 };
        int soma = soma(sequence, segmento);
        System.out.println("Soma: " + soma);
    }

    static int soma(int[] sequence, int[] segment) {
        int soma = 0;

        int i = segment[0];
        while (i <= segment[1]) {
            soma += sequence[i];
            i++;
        }

        return soma;
    }
}