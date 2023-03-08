import java.util.Scanner;

public class Fibbonacci {
    public static void main(String[] args) {
        System.out.print("Digite a quantidade de termos que você quer: ");
        int qtdNumeros = new Scanner(System.in).nextInt();
        int prev = 0;
        int atual = 1;
        for (int i = 0; i < qtdNumeros / 2; i++) {
            System.out.print(prev + " " + atual + " ");
            prev += atual;
            atual += prev;
        }
    }
}