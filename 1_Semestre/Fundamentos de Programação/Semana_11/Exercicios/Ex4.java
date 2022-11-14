package Exercicios;
/*
    4- Escreva um método que retorna a quantidade de palavras em uma String.
*/
import java.util.Scanner;
public class Ex4 {
    public static void main() {
        Scanner input = new Scanner(System.in);
        String string;
        int qtdPalavras;
        
        System.out.print("Escreva qualquer coisa: ");
        string = input.nextLine();
        qtdPalavras = contaPalavras(string);
        
        System.out.printf("%n%s%nÉ composto de %d palavras", string, qtdPalavras);
    }
    
    private static int contaPalavras(String string) {
        int qtdPalavras = 0;
        char caracter;
        string = string.trim()+" ";
        for (int i = 0; i < string.length(); i++) {
            caracter = string.charAt(i);
            if (caracter == 32 && string.length() > 1) {
                qtdPalavras++;
            }
        }
        return qtdPalavras;
    }
}