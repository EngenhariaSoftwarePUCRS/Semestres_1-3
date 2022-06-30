package Exercicios;
/*
    2- Escreva uma método que retorna o caractere do meio de uma String passada como parâmetro.
    Se a String tem tamanho par, então existem dois caracteres no meio, o método deve retornar o caractere da esquerda.
*/
import java.util.Scanner;
public class Ex2 {
    public static void main() {
        Scanner input = new Scanner(System.in);
        String palavra = input.nextLine();
        System.out.println(miolo(palavra));
    }
    
    private static String miolo(String string) {
        int tamanho = string.length();
        if (tamanho % 2 == 0) {
            return string.substring(tamanho/2-1, tamanho/2);
        }
        return string.substring(tamanho/2, tamanho/2+1);
    }
}