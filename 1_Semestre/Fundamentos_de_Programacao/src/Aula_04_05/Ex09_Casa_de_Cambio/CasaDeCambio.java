package Aula_04_05.Ex09_Casa_de_Cambio;
//9 - Faça um programa que inicialize duas variáveis para armazenar a taxa de câmbio de conversão de dólar para real e um valor em dólares. Em seguida mostre o valor em reais.

//Exemplo:
//taxa_cambio = 5.34
//valor_dolar = 1200
//escrever o valor em reais
public class CasaDeCambio {
    public static void main(String args[]) {
        double taxaConversao = 5.08;
        double qtdDolar = 30;
        double resultado = qtdDolar * taxaConversao;

        System.out.println("A conversão fica: " + resultado);
    }
}
