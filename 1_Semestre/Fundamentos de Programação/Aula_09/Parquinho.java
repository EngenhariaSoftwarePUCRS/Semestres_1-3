package Aula_09;
import java.util.Scanner;

public class Parquinho {

	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in)) {
			
			System.out.println("\n/================================\\");
			System.out.println("| Confira nossa tabela de pre�os: ");
			System.out.println("|");
			System.out.println("| At� 7 anos: R$ 5 ");
			System.out.println("| 8-18 anos: R$ 10 ");
			System.out.println("| 18-59 anos: R$ 12 ");
			System.out.println("| +59 anos: R$ 8 ");
			System.out.println("\\================================/");
			
			System.out.print("Digite sua idade: ");
			int idade = input.nextInt();
			
			System.out.println("Voc� precisa pagar: R$ "+valorIngresso(idade));
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
