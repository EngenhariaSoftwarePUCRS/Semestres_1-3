import java.util.Scanner;
public class Ex4
{
    public static void main(String args[])
    {
        double valor, soma, maior, menor;
        int continua = 0, qtdNumeros = 1;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite um valor");
        menor = in.nextDouble();
        maior = menor;
        soma = menor;
        do {            
            System.out.println("Digite um valor");
            valor = in.nextDouble();
            
            soma = soma + valor;
            qtdNumeros++;
            if (valor > maior) {
                maior = valor;
            }
            if (valor < menor) {
                menor = valor;
            }

            System.out.println("Deseja finalizar o programa? \n 0 - Não \n 1 - Sim");
            continua = in.nextInt();
        } while(continua != 1);

        System.out.println("A média dos valores é:" + soma/qtdNumeros);
        System.out.println("O menor valor é:" + menor);
        System.out.println("O maior valor é:" + maior);
        System.out.println("A diferença entre o maior e menor é:" + (maior - menor));
    }
}