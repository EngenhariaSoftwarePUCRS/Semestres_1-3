package Aula_12;

import java.util.Scanner;

public class CaraOuCoroa {
    public static void main(String[] args) {

        int valorLidoMoeda = 0;
        int valorLidoContinuar = 0;
        boolean valido = false;
        boolean continuar = false;
        boolean eCara = false;
        int qtdCara = 0;
        boolean eCoroa = false;
        int qtdCoroa = 0;
        boolean caiuDePe = false;
        int qtdCaiuDePe = 0;
        int acertos = 0;
        double valorMoeda = Math.random();

        try (Scanner input = new Scanner(System.in)) {
            do {
                do {
                    System.out.print("Cara(0) ou Coroa(1): ");
                    valorLidoMoeda = input.nextInt();
                    valido = ((valorLidoMoeda == 1) || (valorLidoMoeda == 0));
                } while (!valido);

                valorMoeda = Math.random();

                if (valorMoeda < 0.5)
                    eCara = true;
                else if (valorMoeda > 0.5)
                    eCoroa = true;
                else
                    caiuDePe = true;

                if ((eCara && valorLidoMoeda == 0) || (eCoroa && valorLidoMoeda == 1)) {
                    System.out.println("Parabéns, você acertou!");
                    acertos++;
                } else
                    System.out.println("Infelizmente não foi dessa vez.");
                if (eCara)
                    qtdCara += 1;
                else if (eCoroa)
                    qtdCoroa += 1;
                else if (caiuDePe)
                    qtdCaiuDePe += 1;

                System.out.println("Deseja continuar?");
                do {
                    System.out.print("Não(0) ou Sim(1)\t");
                    valorLidoContinuar = input.nextInt();
                    continuar = (valorLidoContinuar == 1);
                    valido = ((valorLidoMoeda == 1) || (valorLidoMoeda == 0));
                } while (!valido);

                eCara = false;
                eCoroa = false;
                caiuDePe = false;
            } while (continuar);

            System.out.println("A moeda caiu: ");
            System.out.print("\t" + qtdCara + " vez(es) cara, ");
            System.out.print("\t" + qtdCoroa + " vez(es) coroa, ");
            System.out.println(qtdCaiuDePe == 0 ? "\t" : "\t e " + qtdCaiuDePe + " vez(es) de pé");
            System.out.println("Você acertou " + acertos + " vez(es).");
            System.out.println(
                    "Isto equivale a " + (acertos * 100 / (qtdCara + qtdCoroa + qtdCaiuDePe)) + "% de acerto.");
            System.out.println("Obrigado por jogar!");

        } catch (Exception e) {
            System.out.println("\nErro: " + e);
        }
    }
}
