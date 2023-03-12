package General;

import java.util.Scanner;

public class CalculadoraG1 {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			double[] provas, trabalhos;
			int qtdProvas, qtdTrabalhos;
			double resultado;

			System.out.print("Quantas provas voce tem: ");
			qtdProvas = input.nextInt();
			provas = new double[qtdProvas];
			for (int i = 1; i <= qtdProvas; i++) {
				System.out.print("Digite a nota da " + i + "a prova: ");
				provas[i - 1] = input.nextDouble();
			}

			System.out.print("Quantos trabalhos voce tem: ");
			qtdTrabalhos = input.nextInt();
			trabalhos = new double[qtdTrabalhos];
			for (int i = 1; i <= qtdTrabalhos; i++) {
				System.out.print("Digite a nota do " + i + "o trabalho: ");
				trabalhos[i - 1] = input.nextDouble();
			}

			resultado = calculaG1(provas, trabalhos);
			System.out.print(resultado);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	private static double[] eliminaMenor(double[] valores) {
		int qtdValores = valores.length;
		double[] maiores = new double[qtdValores - 1];

		for (int i = 0; i < maiores.length; i++) {
			for (int j = 0; j < qtdValores; j++) {
				if (maiores[i] < valores[j]) {
					double aux = maiores[i];
					maiores[i] = valores[j];
					valores[j] = aux;
				}
			}
		}

		return maiores;
	}

	private static double media(double[] valores) {
		int qtdValores = valores.length;
		double media, soma = 0;

		for (int i = 0; i < qtdValores; i++) {
			soma += valores[i];
		}
		media = soma / qtdValores;

		return media;
	}

	private static double calculaG1(double[] provas, double[] trabalhos) {
		double G1,
				T1 = provas[0],
				T2 = provas[1],
				T3 = provas[2],
				MT = media(eliminaMenor(trabalhos));

		G1 = (2 * T1 + 2 * T2 + 2 * T3 + 4 * MT) / 10;

		return G1;
	}

}