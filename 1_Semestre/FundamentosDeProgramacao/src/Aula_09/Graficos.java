package Aula_09;
import java.util.Scanner;

public class Graficos {

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
			System.out.println("Dist�ncia: "+distancia);
			
			inclinacao = (ponto2[1] - ponto1[1]) / (ponto2[0] - ponto1[0]);
			System.out.println("Inclina��o: "+inclinacao);
			
		}
	}
}
