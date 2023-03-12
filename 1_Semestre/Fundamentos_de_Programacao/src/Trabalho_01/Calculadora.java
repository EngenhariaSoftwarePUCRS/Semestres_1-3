package Trabalho_01;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String usuario,
                operacao = null;
        int escolha,
                a = 0,
                b = 0;
        double resultado = 0;
        boolean possivel = true;

        System.out.print("Digite seu nome: ");
        usuario = input.nextLine();

        menu(usuario);
        escolha = input.nextInt();

        if ((escolha > 0) && (escolha < 8)) {
            System.out.print("Digite o primeiro número: ");
            a = input.nextInt();

            System.out.print("Digite o segundo número: ");
            b = input.nextInt();

            if ((escolha == 3) && (b == 0)) {
                System.out.println("Não é possível dividir por 0.");
                System.out.print("Digite o segundo número novamente: ");
                b = input.nextInt();
            }
        }

        switch (escolha) {
            default:
                possivel = false;
                System.out.println("Por favor, reinicie o programa.");
                break;
            case 1:
                operacao = "adição";
                resultado = Adicao(a, b);
                break;
            case 2:
                operacao = "subtração";
                resultado = Subtracao(a, b);
                break;
            case 3:
                operacao = "divisão";
                if (b != 0)
                    resultado = ((double) a / (double) b);
                else {
                    System.out.println("Não é possível dividir por 0!");
                    possivel = false;
                }
                break;
            case 4:
                operacao = "multiplicação";
                resultado = Multiplicacao(a, b);
                break;
            case 5:
                operacao = "resto";
                resultado = Resto(a, b);
                break;
            case 6:
                operacao = "divisão inteira";
                resultado = DivisaoInteira(a, b);
                break;
            case 7:
                operacao = "potência";
                resultado = Potencia(a, b);
                break;
        }

        if (possivel)
            System.out.printf("O resultado da operação %s é:  %.2f\n", operacao, resultado);

        System.out.println(usuario + ", obrigado por usar o programa Calculadora. Tchau!!!");
    }

    private static void menu(String usuario) {
        System.out.println("\n/==========================================\\");
        System.out.println("|    BEM-VINDO AO PROGRAMA, " + usuario.toUpperCase());
        System.out.println("|");
        System.out.println("| ESCOLHA UMA DAS OPÇÕES ABAIXO PARA INICIAR    ");
        System.out.println("| (1) Adição    ");
        System.out.println("| (2) Subtração    ");
        System.out.println("| (3) Divisão    ");
        System.out.println("| (4) Multiplicação    ");
        System.out.println("| (5) Resto da Divisão    ");
        System.out.println("| (6) Divisão Inteira    ");
        System.out.println("| (7) Potência    ");
        System.out.println("\\==========================================/");
    }

    private static int Adicao(int a, int b) {
        return a + b;
    }

    private static int Subtracao(int a, int b) {
        return a - b;
    }

    private static int Multiplicacao(int a, int b) {
        return a * b;
    }

    private static int Resto(int a, int b) {
        return a % b;
    }

    private static int DivisaoInteira(int a, int b) {
        return a / b;
    }

    private static int Potencia(int a, int b) {
        return (int) Math.pow(a, b);
    }
}