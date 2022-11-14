package Exercicios;
/*
    9 - Escreva um método que recebe uma string como parâmetro e devolve a string invertida.
    Exemplo: inverter("computador"); //deve retornar rodatupmoc
*/
import java.util.Scanner;
public class Ex9 {
    public static void main() {
        Scanner input = new Scanner(System.in);
        String palavra, novaPalavra;
        
        System.out.print("Escreva qualquer coisa: ");
        palavra = input.nextLine();
        novaPalavra = inverte(palavra);
        
        System.out.println(novaPalavra);
    }
    
    private static String inverte(String string) {
        String reversedString = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            reversedString += (string.charAt(i));
        }
        return reversedString;
    }
}