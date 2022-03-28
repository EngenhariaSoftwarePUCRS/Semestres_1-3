import java.util.Scanner;

public class Menor {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			
			System.out.print("Digite um primeiro valor: ");
			double a = input.nextDouble();
			
			System.out.print("Digite um primeiro valor: ");
			double b = input.nextDouble();
			
			System.out.println("O menor valor digitado é: "+menor(a, b));
		}
	}
	
	private static double menor(double a, double b) {
		if (b < a) {
			return b;
		} else {
			return a;
		}
	}
}
