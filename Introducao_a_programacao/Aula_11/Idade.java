import java.util.Scanner;
public class Idade {
    public static void main(){
        
        String[] nome = new String[2];
        int[] data = new int[2];
        int[] mes = new int[2];
        int[] ano = new int[2];
    
        try (Scanner input = new Scanner(System.in)) {
            
            System.out.println("Escreva um primeiro nome: ");
            nome[0] = input.nextLine();
            
            System.out.println("Escreva um primeiro nome: ");
            nome[1] = input.nextLine();
            
            
            System.out.printf("\nEscreva o dia do nascimento de %s ", nome[0]);
            data[0] = input.nextInt();
            
            System.out.printf("\nEscreva o mês do nascimento de %s ", nome[0]);
            mes[0] = input.nextInt();
            
            System.out.printf("\nEscreva o ano do nascimento de %s ", nome[0]);
            ano[0] = input.nextInt();
            
            
            System.out.printf("\nEscreva o dia do nascimento de %s ", nome[1]);
            data[1] = input.nextInt();
            
            System.out.printf("\nEscreva o mês do nascimento de %s ", nome[1]);
            mes[1] = input.nextInt();
            
            System.out.printf("\nEscreva o ano do nascimento de %s ", nome[1]);
            ano[1] = input.nextInt();
            
            System.out.println(comparaIdades(nome, data, mes, ano));
        }
    }
    
    private static String comparaIdades(String[] nome, int[] data, int[] mes, int[] ano) {
        if (ano[0] > ano[1]) {
            System.out.println(nome[1]+" é mais velho que "+nome[0]);
        } else if (ano[1] > ano[0]) {
            System.out.println(nome[0]+" é mais velho que "+nome[1]);
        } else {
            if (ano[0] > ano[1]) {
            System.out.println(nome[1]+" é mais velho que "+nome[0]);
            } else if (ano[1] > ano[0]) {
                System.out.println(nome[0]+" é mais velho que "+nome[1]);
            } else {
                if (ano[0] > ano[1]) {
                System.out.println(nome[1]+" é mais velho que "+nome[0]);
                } else if (ano[1] > ano[0]) {
                    System.out.println(nome[0]+" é mais velho que "+nome[1]);
                } else {
                    System.out.println("27/11/00");
                }
            }
        }
    }
}