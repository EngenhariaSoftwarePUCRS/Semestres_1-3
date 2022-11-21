package Aula_09;
import java.util.Scanner;

public class FrasesIguais {

	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in)) {
			
			System.out.println("Escreva a primeira frase/palavra: ");
			String s1 = input.nextLine();
			
			System.out.println("Escreva a segunda frase/palavra: ");
			String s2 = input.nextLine();
			
			boolean saoIguais = avaliaSemelhanca(s1, s2);
			
			if (saoIguais) {
				System.out.println("Os conte�dos s�o iguais.");
			} else {
				System.out.println("Os conte�dos n�o s�o iguais.");
			}
		}
	}
	
	private static boolean avaliaSemelhanca(String s1, String s2) {
		
		s1 = s1.trim();
		s2 = s2.trim();
		
		if (s1.equals(s2)) {
			return true;
		} else {
			return false;
		}
	}
}
