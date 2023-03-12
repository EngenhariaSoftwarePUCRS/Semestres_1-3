package Semana_10;

import java.util.Scanner;

public class Exercicios {
    // → Suponha que o usuário deva entrar com um valor inteiro menor que 100. Se o
    // usuário entrar com um valor maior ou igual a 100, o laço solicitar novamente
    // um valor inteiro até que o usuário entre com um valor válido:
    public static void main(String[] args) {
        int valor;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Entre com um inteiro <= 100: ");
            valor = input.nextInt();
        } while (valor > 100);

        System.out.println("\n\n =================== Exercício 1 ===================\n\n");
        Ex1();
        System.out.println("\n\n =================== Exercício 2 ===================\n\n");
        Ex2();
        System.out.println("\n\n =================== Exercício 3 ===================\n\n");
        Ex3();
        System.out.println("\n\n =================== Exercício 4 ===================\n\n");
        Ex4();
        System.out.println("\n\n =================== Exercício 5 ===================\n\n");
        Ex5();
        System.out.println("\n\n =================== Exercício 6 ===================\n\n");
        Ex6();
        System.out.println("\n\n =================== Exercício 7 ===================\n\n");
        Ex7();
    }

    // 1. Suponha que a entrada deva ser no mínimo 0 e no máximo 100. Modifique o
    // laço do while anterior para fazer esta nova condição.
    public static void Ex1() {
        int valor;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Entre com um inteiro <= 100 e >= 0: ");
            valor = input.nextInt();
        } while ((valor >= 0) && (valor <= 100));
    }

    // 2. Reescreva o laço do while do exemplo agora com um laço while. Qual é a
    // desvantagem desta solução com o laço while?
    public static void Ex2() {
        int valor;
        Scanner input = new Scanner(System.in);

        System.out.print("Entre com um inteiro <= 100 e >= 0: ");
        valor = input.nextInt();

        while ((valor >= 0) && (valor <= 100)) {
            System.out.print("Entre com um inteiro <= 100 e >= 0: ");
            valor = input.nextInt();
        }
    }

    // 3. Suponha que Java não tivesse um laço do while. Você poderia reescrever
    // qualquer laço do usando um laço while?
    public static void Ex3() {
        System.out.println("Sim");
    }

    // 4. Escreva um laço do que lê valores inteiros e computa a soma destes. Pare a
    // execução assim que o usuário digitar o valor 0.
    public static void Ex4() {
        Scanner input = new Scanner(System.in);
        int numero = 0, soma = 0;

        do {
            System.out.print("Digite um número inteiro diferente de diferente de zero: ");
            numero = input.nextInt();
            soma += numero;
        } while (numero != 0);

        System.out.printf("A soma é: %d%n", soma);
    }

    // 5. Escreva um laço do while que leia valores inteiros e computa o valor do
    // somatório destes. O programa deve parar quando o usuário digitar 0 ou entrar
    // com dois valores repetidos.
    public static void Ex5() {
        Scanner input = new Scanner(System.in);
        int valor, ultValor = 0, soma = 0;

        do {
            System.out.print("Digite um número inteiro diferente de diferente de zero: ");
            valor = input.nextInt();
            soma += valor;

            if (valor == ultValor)
                break;

            ultValor = valor;
        } while (valor != 0);
    }

    // 6.
    // Reescreva o trecho de código
    // abaixo utilizando um laço' for':
    // double x = 0;
    // double s;
    // do {
    // s = 1.0 / (1 + n * n);
    // n++;
    // x = x + s;
    // } while (s > 0.01);

    public static void Ex6() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double x = 0;
        for (double s = 0; s > 0.01; n++) {
            s = 1.0 / (1 + n * n);
            x = x + s;
        }
    }

    // 7.
    // Mostre o resultado de
    // cada um dos laços abaixo:
    public static void Ex7() {
        // a.
        int s = 1;
        int n = 1;
        while (s < 10) {
            s = s + n;
            System.out.println(s);
        }

        // b.
        s = 1;
        for (n = 1; n < 5; n++) {
            s = s + n;
            System.out.println(s);
        }

        // c.
        s = 1;
        n = 1;
        do {
            s = s + n;
            n++;
            System.out.println(s);
        } while (s < 10 * n);
    }
}
