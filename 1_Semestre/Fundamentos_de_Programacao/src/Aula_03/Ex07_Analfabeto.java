package Aula_03;

import java.util.Scanner;

public class Ex07_Analfabeto {
    public static void main(String[] args) {
        String nome;
        String sobrenome;
        int idade;

        Scanner input = new Scanner(System.in);

        System.out.print("Escreva aqui seu nome: ");
        nome = input.nextLine();
        System.out.print("Escreva aqui seu sobrenome: ");
        sobrenome = input.nextLine();
        System.out.print("Escreva aqui sua idade: ");
        idade = input.nextInt();

        System.out.println("Você tem " + idade + " anos e seu nome é " + nome + " " + sobrenome
                + ". \n Infelizmente, você deve ser analfabeto, lamento dizer.");
    }
}
