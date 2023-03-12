package Aula_08;

import java.util.Scanner;

public class Consts {
    public static void main(String[] args) {

        // FINAL = const (inalterável);
        final int QUANTIDADE_MINUTOS_HORA = 60;

        int qtdMinutosLidos;
        int horas;
        int minutos;

        Scanner input = new Scanner(System.in);

        System.out.print("Digite uma quantidade de minutos: ");
        qtdMinutosLidos = input.nextInt();

        horas = qtdMinutosLidos / QUANTIDADE_MINUTOS_HORA;
        minutos = qtdMinutosLidos % QUANTIDADE_MINUTOS_HORA;

        System.out.printf("%d hora(s) e %d minuto(s).", horas, minutos);
    }
}
