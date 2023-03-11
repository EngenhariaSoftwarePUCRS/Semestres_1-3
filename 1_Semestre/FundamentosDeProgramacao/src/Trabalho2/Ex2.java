import java.util.Scanner;
public class Ex2
{
    public static void main(String args[])
    {
        int a, b, soma = 0, qtdNumeros = 0;
        double media;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o primeiro valor:");
        a = in.nextInt();
        System.out.println("Digite o segundo valor:");
        b = in.nextInt();

        if(a<=b) {
            while(a<=b) {
                soma = soma + a;
                a++;
                qtdNumeros++;
            }
        } else {
            while(a>=b) {
                soma = soma + a;
                a--;
                qtdNumeros++;
            }
        }
        media = (double)soma / qtdNumeros;
        System.out.println("A média entre esses numeros é: " + media);
    }
}