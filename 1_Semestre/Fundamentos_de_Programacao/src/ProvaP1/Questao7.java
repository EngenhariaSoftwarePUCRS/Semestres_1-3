package ProvaP1;

import java.util.Scanner;

public class Questao7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double G1, P1, P2, P3;
        System.out.print("Escreva sua P1: ");
        P1 = input.nextDouble();
        System.out.print("Escreva sua P2: ");
        P2 = input.nextDouble();
        System.out.print("Escreva sua P3: ");
        P3 = input.nextDouble();
        G1 = (P1 + 2 * P2 + 3 * P3) / 6;

        if (G1 < 4)
            System.out.println("Reprovado");
        else if ((G1 >= 4) && (G1 < 7))
            System.out.println("Exame");
        else if (G1 >= 7)
            System.out.println("Aprovado");
        else
            System.out.println("Erro. Favor reiniciar o programa");
    }
}
