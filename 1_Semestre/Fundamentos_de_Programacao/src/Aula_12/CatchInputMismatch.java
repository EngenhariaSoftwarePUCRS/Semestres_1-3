package Aula_12;

import java.util.Scanner;

public class CatchInputMismatch {
    public static void main(String[] args) {
        int valorLido = 1;
        try (Scanner input = new Scanner(System.in)) {
            while (valorLido != 0) {
                System.out.print("Escreva um número: ");
                valorLido = input.nextInt();
            }
            System.out.println("Programa encerrado.");
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
}
