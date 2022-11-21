package Aula_09;
import java.util.Scanner;

public class MinCedulasBanco {

	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in)) {
			int saque;
			
			System.out.print("Quanto voc� quer sacar: ");
			saque = input.nextInt();
			
			do {
				if (saque / 100 >= 1) {
					System.out.println(saque/100+" notas de R$100.");
					saque = saque - saque/100 * 100;
				} else if (saque / 50 >= 1) {
					System.out.println(saque/50+" notas de R$50.");
					saque = saque - saque/50 * 50;
				} else if (saque / 10 >= 1) {
					System.out.println(saque/10+" notas de R$10.");
					saque = saque - saque/10 * 10;
				} else if (saque / 5 >= 1) {
					System.out.println(saque/5+" notas de R$5.");
					saque = saque - saque/5 * 5;
				} else if (saque / 1 >= 1) {
					System.out.println(saque/1+" moedas de R$1.");
					saque = saque - saque/1 * 1;
				}
				
			} while (saque % 100 != 0);
			
		}
	}
}
