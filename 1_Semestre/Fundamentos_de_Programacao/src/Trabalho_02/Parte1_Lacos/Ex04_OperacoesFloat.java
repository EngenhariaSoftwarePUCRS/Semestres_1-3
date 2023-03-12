package Trabalho_02.Parte1_Lacos;

// 4.Escreva um programa que lê um conjunto de números em ponto flutuante e imprime:
// A média dos valores
// O menor valor.
// O maior valor.
// A diferença entre o maior e o menor número digitado.

import java.util.Scanner;

public class Ex04_OperacoesFloat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite valores ou 0 para encerrar: ");
        double numeroLido = input.nextDouble();
        double menorValor = numeroLido;
        double maiorValor = numeroLido;
        double qtdValores = 1;
        double soma = numeroLido;
        double media;

        while (true) {
            numeroLido = input.nextDouble();
            if (numeroLido == 0)
                break;

            if (numeroLido > maiorValor)
                maiorValor = numeroLido;

            if (numeroLido < menorValor)
                menorValor = numeroLido;

            soma += numeroLido;
            qtdValores++;
        }

        media = soma / qtdValores;

        System.out.println("Média valores:   " + media);
        System.out.println("Menor valor:   " + menorValor);
        System.out.println("Maior valor: " + maiorValor);
        System.out.println("Diferença: " + (maiorValor - menorValor));
    }
}
