import java.util.Scanner;

public class SegundosDecorridosDia {

	public static void main(String[] args) {
		
		try (Scanner input = new Scanner(System.in)) {
			int[] horario = new int[3];
			int segundosDia;
			
			System.out.print("Digite a hora: ");
			horario[0] = input.nextInt();
			
			System.out.print("Digite os minutos: ");
			horario[1] = input.nextInt();
			
			System.out.print("Digite os segundos: ");
			horario[2] = input.nextInt();
			
			segundosDia = horario[2] + horario[1]*60 + horario[0]*3600;
			
			System.out.println("Se passaram "+segundosDia+" segundos desde o começo do dia.");
			
		}
	}
}
