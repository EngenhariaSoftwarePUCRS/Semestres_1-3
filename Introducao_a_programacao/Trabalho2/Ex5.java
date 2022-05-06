/*5.Escreva um programa que lê uma palavra e imprime o número de vogais da mesma.
    Por exemplo, se o usuário digitar "Internacional", o programa imprime:  6 vogais*/

import java.util.Scanner;
public class Ex5
{
    public static void main() {
        String palavra;
        int qtdVogais = 0;
        char caracter;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite uma palavra: ");
        palavra = input.nextLine();
        
        palavra = palavra.toUpperCase();
        for (int i = 0; i < palavra.length(); i++) {
            caracter = palavra.charAt(i);
            if (caracter == 65 || caracter == 69 || caracter == 73 || caracter == 79 || caracter == 85 || caracter == 193 || caracter == 233 || caracter == 243) {
                qtdVogais++;
            }
        }
        System.out.printf("Há %d vogais na palavra %n", qtdVogais);
    }
}
