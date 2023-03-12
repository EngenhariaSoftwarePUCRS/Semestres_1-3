package Aula_08;

import java.util.Scanner;

public class DiferencaHorario {
    public static void main() {
        Scanner input = new Scanner(System.in);

        int qtdMinutosLidos;
        int horas;
        int minutos;

        System.out.println("Digite um primeiro horário: ");
        qtdMinutosLidos = input.nextInt();

        horas = qtdMinutosLidos / 60;
        minutos = qtdMinutosLidos % 60;

        System.out.printf("%d hora(s) e %d minuto(s).", horas, minutos);
    }
}
