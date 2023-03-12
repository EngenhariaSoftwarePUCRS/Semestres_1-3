package Aula_10;

import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Escreva uma frase/palavra: ");
        String s1 = input.nextLine();

        System.out.println("Concatenação com '-' = " + s1.concat(" - "));
        System.out.println("Contém 'a' = " + s1.contains("a"));
        System.out.println("Tudo maiusculo = " + s1.toUpperCase());
        System.out.println("Tudo minusculo = " + s1.toLowerCase());
    }
}
