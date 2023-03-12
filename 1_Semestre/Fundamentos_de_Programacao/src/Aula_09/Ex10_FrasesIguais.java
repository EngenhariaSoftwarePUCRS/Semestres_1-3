package Aula_09;

import java.util.Scanner;

public class Ex10_FrasesIguais {
	/*
	 * Escreva um programa que leia dois strings (s1 e s2) e informe se o conteúdo
	 * de s1 é igual o conteúdo de s2 ou não.
	 */
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Escreva a primeira frase/palavra: ");
			String s1 = input.nextLine();

			System.out.print("Escreva a segunda frase/palavra: ");
			String s2 = input.nextLine();

			boolean saoIguais = avaliaSemelhanca(s1, s2);

			if (saoIguais)
				System.out.println("Os conteudos sao iguais.");
			else
				System.out.println("Os conteudos nao sao iguais.");
		}
	}

	private static boolean avaliaSemelhanca(String s1, String s2) {
		s1 = s1.trim();
		s2 = s2.trim();

		return s1.equals(s2);
	}
}
