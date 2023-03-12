package Aula_09;

import java.util.Scanner;

public class Ex05_Imparidade {
	/*
	 * Escreva um programa que recebe três números inteiros e depois imprime quantos
	 * desses números eram ímpares.
	 */
	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in)) {
			int[] numero = new int[3];
			int qtdImpares = 0;

			for (int i = 0; i < 3; i++) {
				System.out.print("Digite um numero: ");
				numero[i] = input.nextInt();

				if (numero[i] % 2 != 0) {
					qtdImpares++;
				}
			}

			if (qtdImpares < 1) {
				System.out.println("Todos os valores sao pares.");
			} else if (qtdImpares < 2) {
				System.out.println("Havia " + qtdImpares + " valor impar.");
			} else {
				System.out.println("Haviam " + qtdImpares + " valores impares.");
			}

		}
	}
}
