import java.util.Scanner;

public class ContaCaracteres {

	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in)) {
			
			System.out.println("Escreva a primeira frase/palavra: ");
			String s1 = input.nextLine();
			
			System.out.println("Escreva a segunda frase/palavra: ");
			String s2 = input.nextLine();
			
			System.out.println(contaCaracteres(s1, s2)+"possui mais caracteres que a outra.");
		}
	}
	
	private static String contaCaracteres(String s1, String s2) {
		
		s1 = s1.trim();
		s2 = s2.trim();
		
		if (s1.length() > s2.length()) {
			return "A primeira frase ";
		} else if (s2.length() > s1.length()) {
			return "A segunda frase ";
		} else {
			return "Nenhuma frase ";
		}
	}
}
