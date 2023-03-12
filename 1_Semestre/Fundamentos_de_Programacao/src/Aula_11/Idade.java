package Aula_11;

import java.util.Scanner;

public class Idade {
    public static void main(String[] args) {

        String[] nome = new String[2];
        int[] data = new int[2];
        int[] mes = new int[2];
        int[] ano = new int[2];

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Escreva um primeiro nome: ");
            nome[0] = input.nextLine();

            System.out.print("Escreva um segundo nome: ");
            nome[1] = input.nextLine();

            System.out.printf("\nEscreva o dia do nascimento de %s: ", nome[0]);
            data[0] = input.nextInt();

            System.out.printf("Escreva o mês do nascimento de %s: ", nome[0]);
            mes[0] = input.nextInt();

            System.out.printf("Escreva o ano do nascimento de %s: ", nome[0]);
            ano[0] = input.nextInt();

            System.out.printf("\nEscreva o dia do nascimento de %s: ", nome[1]);
            data[1] = input.nextInt();

            System.out.printf("Escreva o mês do nascimento de %s: ", nome[1]);
            mes[1] = input.nextInt();

            System.out.printf("Escreva o ano do nascimento de %s: ", nome[1]);
            ano[1] = input.nextInt();

            System.out.println("\n --- Conclusão --- \n");
            comparaIdades(nome, data, mes, ano);
        }
    }

    private static void comparaIdades(String[] nome, int[] data, int[] mes, int[] ano) {
        if (ano[0] < ano[1]) {
            System.out.println(nome[0] + " é mais velho(a) que " + nome[1]);
        } else if (ano[1] < ano[0]) {
            System.out.println(nome[1] + " é mais velho(a) que " + nome[0]);
        } else {
            if (mes[0] < mes[1]) {
                System.out.println(nome[0] + " é mais velho(a) que " + nome[1]);
            } else if (mes[1] < mes[0]) {
                System.out.println(nome[1] + " é mais velho(a) que " + nome[0]);
            } else {
                if (data[0] < data[1]) {
                    System.out.println(nome[0] + " é mais velho(a) que " + nome[1]);
                } else if (data[1] < data[0]) {
                    System.out.println(nome[1] + " é mais velho(a) que " + nome[0]);
                } else {
                    System.out.println("As duas pessoas tem a exata mesma idade.");
                }
            }
        }
    }
}