/**
12.	Escreva um programa que recebe um valor n e imprime na tela:
   1
   2  2
   3  3  3
   4  4  4  4
   ...
   n  n  n  n  n
 */
import java.util.Scanner;
public class Ex12
{
    public static void main() {
        Scanner input = new Scanner(System.in);
        System.out.print("Escreva um valor: ");
        int n = input.nextInt();
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
