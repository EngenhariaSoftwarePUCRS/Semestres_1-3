import java.util.Scanner;
public class consts {
    public static void main() {
        
        //FINAL = const (inalterável);
        final int QUANTIDADE_MINUTOS_HORA = 60;
        
        int qtdMinutosLidos;
        int horas;
        int minutos;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Digite um primeiro horário: ");
        qtdMinutosLidos = input.nextInt();
        
        horas = qtdMinutosLidos / QUANTIDADE_MINUTOS_HORA;
        minutos = qtdMinutosLidos % QUANTIDADE_MINUTOS_HORA;
        
        System.out.printf("%d hora(s) e %d minuto(s).", horas, minutos);
    }
}