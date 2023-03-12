package Aula_09;

import java.util.Scanner;

public class Ex06_Menor {
	/*
	 * Escreva um programa que recebe dois números a e b e depois imprime o menor
	 * dos dois números.
	 */

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {

			System.out.print("Digite um primeiro valor: ");
			double a = input.nextDouble();

			System.out.print("Digite um primeiro valor: ");
			double b = input.nextDouble();

			System.out.println("O menor valor digitado e: " + menor(a, b));
		}
	}

	private static double menor(double a, double b) {
		if (b < a)
			return b;
		else
			return a;
	}
}
