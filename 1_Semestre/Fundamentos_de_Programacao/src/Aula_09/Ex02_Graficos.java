package Aula_09;

import java.util.Scanner;

public class Ex02_Graficos {
	/*
	 * Escreva um programa que recebe dois pontos no plano,
	 * P1 = (x1,y1) e
	 * P2 = * (x2,y2) e calcula:
	 * a. A distancia entre eles dada por d(P1, P2) =
	 * √((𝑥1 − 𝑥2)**2 + (𝑦1 − 𝑦2)**2)
	 * 
	 * b. A inclinação da reta y = ax + b que une esses dois pontos, dada por
	 * 𝑎 =
	 * (𝑦2 − 𝑦1)
	 * ---------
	 * (𝑥2 − 𝑥1)
	 * Faça uma análise de seu programa e verifique que existem certos valores que
	 * fazem com que ele apresente um erro. Identifique o erro.
	 */
	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in)) {
			Double[] ponto1 = new Double[2];
			Double[] ponto2 = new Double[2];
			Double distancia;
			Double inclinacao;

			System.out.print("Escreva aqui o valor x do primeiro ponto: ");
			ponto1[0] = input.nextDouble();

			System.out.print("Escreva aqui o valor y do primeiro ponto: ");
			ponto1[1] = input.nextDouble();

			System.out.print("Escreva aqui o valor x do segundo ponto: ");
			ponto2[0] = input.nextDouble();

			System.out.print("Escreva aqui o valor y do segundo ponto: ");
			ponto2[1] = input.nextDouble();

			distancia = Math.sqrt(Math.pow((ponto1[0] - ponto2[0]), 2) + Math.pow((ponto1[1] - ponto2[1]), 2));
			System.out.println("Distancia: " + distancia);

			inclinacao = (ponto2[1] - ponto1[1]) / (ponto2[0] - ponto1[0]);
			System.out.println("Inclinacao: " + inclinacao);

		}
	}
}
