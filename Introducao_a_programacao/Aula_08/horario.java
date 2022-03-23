import java.util.Scanner;
public class horario {
    public static void main() {
        Scanner input = new Scanner(System.in);
        
        int horario1;
        int horario2;
        int diferenca;
        
        System.out.println("Digite um primeiro horário: ");
        horario1 = input.nextInt();
        
        System.out.println("Digite um segundo horário: ");
        horario2 = input.nextInt();
        
        diferenca = (horario1 - horario2);
        Integer.toString(diferenca);
        
        System.out.println("Horário 1: "+horario1+" \nHorário 2: "+horario2);
        System.out.print("Diferença: "+diferenca);
    }
}