package Aula_06.Ex02_Saldo_Rendimento_Banco;

import java.util.Scanner;

public class SaldoRendimentoBanco {
    /*
     * Um banco online deseja criar um programa que mostra aos seus prospectivos
     * clientes como o saldo da conta irá crescer a partir dos rendimentos. O
     * programa deve receber o saldo inicial e a taxa de rendimento anual. O
     * rendimento é calculado mensalmente. Escreva um programa que imprime o saldo
     * da conta durante os três primeiros meses.
     * 
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double saldoInicial;
        double rendMensal;
        double saldoMes;

        System.out.print("Saldo Inicial: ");
        saldoInicial = input.nextDouble();

        System.out.print("Rendimento percentual mensal: ");
        rendMensal = input.nextDouble() / 100;

        saldoMes = saldoInicial * (1 + rendMensal);

        for (int index = 1; index <= 3; index++) {
            System.out.printf("Saldo após o %dº mês: %.2f%n", index, saldoMes);
            saldoMes = saldoMes * (1 + rendMensal);
        }
    }
}
