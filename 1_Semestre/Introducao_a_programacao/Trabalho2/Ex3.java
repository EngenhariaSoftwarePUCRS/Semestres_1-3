/*3.Escreva um programa que leia uma frase de um usuário e retorna quantos espaços em branco existem nessa frase.*/

import java.util.Scanner;
public class Ex3
{
    public static void main() {
        String frase;
        char caracter;
        int qtdEspacos = 0;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite uma frase: ");
        frase = input.nextLine();
        
        frase = frase.toUpperCase();
        for (int i = 0; i < frase.length(); i++) {
            caracter = frase.charAt(i);
            if (caracter == 32) {
                qtdEspacos++;
            }
        }
        System.out.printf("Há %d espaços na frase %n", qtdEspacos);
    }
}
