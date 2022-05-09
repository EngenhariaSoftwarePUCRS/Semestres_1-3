/*4.Escreva um programa que lê um conjunto de números em ponto flutuante e imprime:
    A média dos valores
    O menor valor.
    O maior valor.
    A diferença entre o maior e o menor número digitado.*/

import java.util.Scanner;
public class Ex4
{
    public static void main() {
        double numeroLido, menorValor, maiorValor;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite valores diferentes de 0: ");
        numeroLido = input.nextDouble();
        menorValor = numeroLido;
        maiorValor = numeroLido;
        
        while (numeroLido != 0) {
            System.out.print("Digite um valor: ");
            numeroLido = input.nextDouble();
            
            if (numeroLido > maiorValor) {
                maiorValor = numeroLido;
            }
            if (numeroLido < menorValor) {
                menorValor = numeroLido;
            }
        }
        
        System.out.println("Menor valor: "+menorValor);
        System.out.println("Maior valor: "+maiorValor);
        System.out.println("Diferença: "+(maiorValor - menorValor));
    }
}
