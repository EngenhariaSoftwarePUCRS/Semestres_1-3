package Aula_09;

import java.util.Scanner;

public class Ex07_Parquinho {
	/*
	 * O ingresso do parquinho é de 5 reais para crianças de 7 anos ou menos, 10
	 * reais para pessoas entre 8 e 18 anos e 12 reais para maiores de 18,
	 * mas custa apenas 8 * reais para idosos (acima de 59).
	 * Escreva um programa que recebe a idade do visitante e
	 * informa o valor a ser pago.
	 */
	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in)) {

			System.out.println("\n/================================\\");
			System.out.println("| Confira nossa tabela de precos: ");
			System.out.println("|");
			System.out.println("| Ate 7 anos: R$ 5 ");
			System.out.println("| 8-18 anos: R$ 10 ");
			System.out.println("| 18-59 anos: R$ 12 ");
			System.out.println("| +59 anos: R$ 8 ");
			System.out.println("\\================================/");

			System.out.print("Digite sua idade: ");
			int idade = input.nextInt();

			System.out.println("Voce precisa pagar: R$ " + valorIngresso(idade));
		}
	}

	private static int valorIngresso(int idade) {
		if (idade <= 7) {
			return 5;
		} else if (idade > 7 && idade <= 18) {
			return 10;
		} else if (idade > 18 && idade <= 59) {
			return 12;
		} else {
			return 8;
		}
	}

}
