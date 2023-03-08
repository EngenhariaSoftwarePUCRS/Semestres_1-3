package Exercicios;
/*
    8 - Escreva um método que receba um número inteiro e devolva o valor do fatorial desse número.
    Obs.: Não usar nenhuma biblioteca externa para calcular o fatorial.
*/
import java.util.Scanner;
public class Ex8 {
    public static void main() {
        int n, nFatorial;
        
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Digite um número inteiro positivo: ");
            n = input.nextInt();
            
            if (n < 0) {
                System.out.println("Apenas valores positivos. Favor reinicie o programa.");
            } else {
                nFatorial = fatorial(n);
                System.out.printf("%d! = %d", n, nFatorial);
            }
        } catch (Exception e) {
            System.out.println("Erro: "+e);
            System.out.println("(Apenas números inteiros são aceitos.)");
        }
    }
    
    private static int fatorial(int n) {
        int fatorial = n;
        for (int i = n - 1; i > 1; i--)
            fatorial *= i;
        if (n == 0)
            return 1;
        return fatorial;
    }
}