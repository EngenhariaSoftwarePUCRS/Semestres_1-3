import java.util.Scanner;
public class Strings {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Escreva uma frase/palavra: ");
        String s1 = input.nextLine();
        
        System.out.println("Concatenação - "+s1.concat(" - "));
        System.out.println(s1.contains("a"));
        System.out.println(s1.toUpperCase()+" - Maiúscula");
        System.out.println(s1.toLowerCase()+" - Minúscula");
        System.out.println();
    }
}