package Aula_08;

import java.util.Scanner;

public class CelsiusFahrenheit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double temp_fahrenheit;
        double temp_celsius;

        System.out.print("Temperatura em ºF: ");
        temp_fahrenheit = input.nextDouble();
        temp_celsius = ((temp_fahrenheit - 32) * 5 / 9);
        System.out.printf("O equivalente em Celsius é: %.2fºC%n", temp_celsius);

        System.out.println("=====================================");

        System.out.print("Temperatura em ºC: ");
        temp_celsius = input.nextDouble();
        temp_fahrenheit = ((temp_celsius) * 9 / 5 + 32);
        System.out.printf("O equivalente em Fahrenheit é: %.2fºF%n", temp_fahrenheit);
    }
}
