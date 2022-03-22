import java.util.Scanner;
public class Analfabeto {
    public static void main() {
        String nome;
        String sobrenome;
        int idade;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Escreva aqui seu nome");
        nome = input.nextLine();
        System.out.println("Escreva aqui seu sobrenome");
        sobrenome = input.nextLine();
        System.out.println("Escreva aqui sua idade");
        idade = input.nextInt();
    
        System.out.println("Você tem "+idade+" anos e seu nome é "+nome+" "+sobrenome+". \n Infelizmente, você deve ser analfabeto, lamento dizer.");
    }
}