package Aula_08;

import java.util.Scanner;

public class Horario {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int horario1;
        int hora_horario1;
        int minuto_horario1;
        int minutagem_horario1;
        int horario2;
        int hora_horario2;
        int minuto_horario2;
        int minutagem_horario2;
        int diferenca;
        int hora_diferenca;
        int minuto_diferenca;

        System.out.print("Digite um primeiro horário: ");
        horario1 = input.nextInt();
        hora_horario1 = horario1 / 100;
        minuto_horario1 = horario1 % 100;
        minutagem_horario1 = 60 * hora_horario1 + minuto_horario1;
        System.out.println(hora_horario1 + " hora(s) e " + minuto_horario1 + " minuto(s).");

        System.out.print("Digite um segundo horário: ");
        horario2 = input.nextInt();
        hora_horario2 = horario2 / 100;
        minuto_horario2 = horario2 % 100;
        minutagem_horario2 = 60 * hora_horario2 + minuto_horario2;
        System.out.println(hora_horario2 + " hora(s) e " + minuto_horario2 + " minuto(s).");

        diferenca = (minutagem_horario1 - minutagem_horario2);
        hora_diferenca = diferenca / 60;
        minuto_diferenca = diferenca % 60;

        System.out.print("Diferença: " + hora_diferenca + " hora(s) e " + minuto_diferenca + " minuto(s).");
    }
}