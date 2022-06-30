import java.util.Scanner;
public class horariov2 {
    public static void main() {
        
        int qtdMinutosLidos;
        int horas;
        int minutos;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Digite um primeiro horário: ");
        qtdMinutosLidos = input.nextInt();
        
        horas = qtdMinutosLidos / 60;
        minutos = qtdMinutosLidos % 60;
        
        System.out.printf("%d hora(s) e %d minuto(s).", horas, minutos);
    }
}