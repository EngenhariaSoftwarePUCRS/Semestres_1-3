package Exercicios;
/*
    7 - Bob adora pedalar. Como Bob sabe da importância de se manter hidratado, ele bebe 0,5 litros de água a cada hora pedalada.

    Dado o número de horas a ser pedalado, você deve calcular a quantidade de litros de água que Bob precisa levar.
    O cálculo deve retornar o arredondamento para o menor inteiro mais próximo. Por exemplo,

    Horas: 3 -> Litros = 1

    Horas: 6.7 -> Litros = 3

    Horas: 11.8 -> Litros = 5
*/
import java.util.Scanner;
public class Ex7 {
    public static void main() {
        Scanner input = new Scanner(System.in);
        double horas, litros;
        System.out.print("Digite o número de horas que vai pedalar: ");
        horas = input.nextDouble();
        litros = litrosPorHora(horas);
        System.out.printf("Para %.2f horas de viagem, seriam necessários %.0f litros de água.", horas, litros);
    }
    
    private static double litrosPorHora(double horas) {
        double litros = 0.5 * horas; 
        return Math.floor(litros);
    }
}