/*2.Escreva um programa que recebe dois números a e b e acha a média de todos os números entre a e b.
    Faça seu programa funcionar até mesmo se a for maior do que b.*/

import java.util.Scanner;
public class Ex2
{
    public static void main() {
        int a, b, soma = 0, qtdValores = 1;
        double media;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite a: ");
        a = input.nextInt();
        System.out.print("Digite b: ");
        b = input.nextInt();
        
        if(a >= b) {
            qtdValores = a - b + 1;
            while (a > b) {
                soma += b;
                b++;
            }
        } else {
            qtdValores = b - a + 1;
            while (b >= a) {
                soma += a;
                a++;
            }
        }
        
        media = soma / qtdValores;
        
        System.out.printf("A média entre os %d valores é: %.2f", qtdValores, media);
    }
}
