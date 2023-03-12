package Aula_07.Ex03_Diferenca_Horario_Militar;

import java.util.Scanner;

public class DiferencaHorarioMilitar {
    /*
     * Escreva um programa que lê dois horários em formato militar (0900, 1730) e
     * imprime o número de horas e minutos entre os dois horários. Por exemplo (os
     * números representam as entradas do usuário:
     * Por favor, entre com o primeiro horário: 0900
     * Por favor, entre com o segundo horário: 1730
     * 8 horas 30 minutos
     * Preveja o caso onde o primeiro horário é maior que o segundo:
     * Por favor, entre com o primeiro horário: 1730
     * Por favor, entre com o segundo horário: 0900
     * 15 horas 30 minutos
     * 
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String horario1;
        String horario2;
        String diferencaHoras;
        String diferencaMinutos;

        System.out.print("Digite um primeiro horário: ");
        horario1 = input.nextLine();

        System.out.print("Digite um segundo horário: ");
        horario2 = input.nextLine();

        if (Integer.parseInt(horario1) <= Integer.parseInt(horario2)) {
            diferencaHoras = Integer.toString(
                    Integer.parseInt(horario2.substring(0, 2))
                            - Integer.parseInt(horario1.substring(0, 2)))
                    .replaceAll("-", "");

            diferencaMinutos = Integer.toString(
                    Integer.parseInt(horario2.substring(2, 4))
                            - Integer.parseInt(horario1.substring(2, 4)))
                    .replaceAll("-", "");
        } else {
            diferencaHoras = Integer.toString(24 +
                    Integer.parseInt(horario2.substring(0, 2))
                    - Integer.parseInt(horario1.substring(0, 2)));

            diferencaMinutos = Integer.toString(60 +
                    Integer.parseInt(horario2.substring(2, 4))
                    - Integer.parseInt(horario1.substring(2, 4)));

            if (Integer.parseInt(diferencaMinutos) % 60 != 0)
                diferencaHoras = Integer.toString(Integer.parseInt(diferencaHoras) - 1);
        }

        System.out.printf("Diferença: %s horas %s minutos%n", diferencaHoras, diferencaMinutos);
    }
}
