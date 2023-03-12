package Aula_09;

import java.util.Scanner;

public class Ex01_AreaLivreTerreno {
	/*
	 * Escreva um programa que recebe as dimensões (em metros) de um terreno
	 * retangular
	 * e em seguida as dimensões de uma casa (também em metros e retangular) sobre
	 * este
	 * terreno. Em seguida calcule e apresente a área livre do terreno, em metros
	 * quadrados e
	 * em percentagem.
	 */
	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in)) {

			double larguraTerreno;
			double comprimentoTerreno;
			double areaTerreno;
			double larguraCasa;
			double comprimentoCasa;
			double areaCasa;
			double[] areaLivre = new double[2];

			System.out.print("Insira a largura do terreno: ");
			larguraTerreno = input.nextDouble();

			System.out.print("Insira o comprimento do terreno: ");
			comprimentoTerreno = input.nextDouble();

			areaTerreno = larguraTerreno * comprimentoTerreno;

			System.out.print("Insira a largura da casa: ");
			larguraCasa = input.nextDouble();

			System.out.print("Insira o comprimento da casa: ");
			comprimentoCasa = input.nextDouble();

			areaCasa = larguraCasa * comprimentoCasa;

			areaLivre[0] = areaTerreno - areaCasa;
			areaLivre[1] = (areaTerreno - areaCasa) / areaTerreno * 100;

			System.out.println("Voce possui " + areaLivre[0] + "metros quadrados livres de terreno.");
			System.out.println("Isso equivalhe a " + areaLivre[1] + "% do total do terreno.");

		}
	}
}
