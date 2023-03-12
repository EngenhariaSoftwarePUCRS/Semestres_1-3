package Aula_06.Ex01_Calculadora_de_Descontos;

import java.util.Scanner;

public class CalculadoraDeDescontos {
    /*
     * Uma videolocadora quer recompensar os melhores clientes com descontos. Estes
     * descontos são calculados a partir do número de locações feitas pelo cliente e
     * do número de novos clientes que foram recomendados. O desconto é dado em
     * percentual e é igual à soma das locações com as recomendações. O desconto não
     * pode exceder 75%.
     * Escreva um programa chamado CalculadoraDeDescontos que calcula o valor do
     * desconto a ser dado.
     * Exemplo de execução:
     * 
     * Entre com o número de locações: 56
     * Entre com o número de novos clientes recomendados: 3
     * O desconto é igual a: 59.00%
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numLocacoes;
        int numNovosClientes;
        double desconto;

        System.out.print("Entre com o número de locações: ");
        numLocacoes = input.nextInt();

        System.out.print("Entre com o número de novos clientes recomendados: ");
        numNovosClientes = input.nextInt();

        desconto = numLocacoes + numNovosClientes;
        if (desconto > 75)
            desconto = 75; // desconto não pode exceder 75%

        System.out.printf("Seu desconto é de: %.2f%%", desconto);
    }
}