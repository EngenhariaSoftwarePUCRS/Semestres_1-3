package Exercicios;
/*
    6 - Escreva um método que computa o somatório dos dígitos de um número.
*/
import java.util.Scanner;
public class Ex6 {
    public static void main() {
        Scanner input = new Scanner(System.in);
        int numero, somatorio;
        System.out.println("Digite um número para somarem-se os dígitos: ");
        numero = input.nextInt();
        somatorio = somaDigitos(numero, 0);
        System.out.printf("A soma dos dígitos de %d é: %d", numero, somatorio);
    }
    
    private static int somaDigitos(int numero, int soma) {
        int digito = numero % 10, resto = numero / 10;
        if (digito != numero) {
            soma += digito;
            return somaDigitos(resto, soma);
        }
        soma += digito;
        return soma;
    }
}