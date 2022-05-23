package Exercicios;
/*
    1- Escreva um método que recebe três números e determina a média aritmética entre três números.
*/
import java.util.Scanner;
public class Ex1 {
    public static void main() {
        double media;
        int[] valores = new int[3];
        Scanner input = new Scanner(System.in);        
    
        System.out.println("Digite três valores inteiros para calcular a média: ");
        for (int i = 0; i < valores.length; i++) {
            valores[i] = input.nextInt();
        }
    
        System.out.println("A média dos valores somados é: "+media(valores));
    }
    
    private static double media(int[] valores) {
        double soma = 0;
        int qtdValores = valores.length;
        for (int i = 0; i < qtdValores; i++) {
            soma += valores[i];
        }
        double media = soma
                        /
                    qtdValores;
        return media;
    }
}