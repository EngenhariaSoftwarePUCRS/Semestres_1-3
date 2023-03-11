import java.util.Scanner;
public class Ex1
{
    public static void main(String args[])
    {
        int a, b, soma = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o primeiro valor:");
        a = in.nextInt();
        System.out.println("Digite o segundo valor:");
        b = in.nextInt();

        if(a<=b) {
            while(a<=b) {
                soma = soma + a;
                a++;
            }
        } else {
            while(a>=b) {
                soma = soma + a;
                a--;
            }
        }
        System.out.println("Valor da soma entre esses numeros é: " + soma);
    }
}