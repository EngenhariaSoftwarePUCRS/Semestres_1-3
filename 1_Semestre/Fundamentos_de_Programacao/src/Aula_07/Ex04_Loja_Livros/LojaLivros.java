package Aula_07.Ex04_Loja_Livros;

import java.util.Scanner;

public class LojaLivros {
    /*
     * O pseudocódigo abaixo descreve como uma loja de livros computa o preço de um
     * pedido a partir do número de livros que foram pedidos.
     * 1. Leia o preço do livro e o número de livros do pedido.
     * 2. Compute os impostos (15 porcento do total do preço dos livros).
     * 3. Compute o valor do frete (10 Reais por livro).
     * 4. O preço final é a soma do total do preço dos livros, dos impostos e do
     * valor total do frete.
     * 5. Imprima o preço do pedido na tela
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double precoLivro;
        int quantidadeLivros;
        double impostos = 0.15;
        double precoTotal = 0;
        int continuar = 1;

        while (continuar != 0) {
            System.out.print("\nDigite o preço do livro: ");
            precoLivro = input.nextDouble();

            System.out.print("Digite a quantidade do livro: ");
            quantidadeLivros = input.nextInt();

            if ((continuar != 0) || (continuar != 1)) {
                System.out.print("Deseja continuar? (0 | 1)\t");
                continuar = input.nextInt();
            }

            double total_preco_livros = precoLivro * quantidadeLivros;
            total_preco_livros += total_preco_livros * impostos;
            int frete = 10 * quantidadeLivros;
            double precoFinal = total_preco_livros + frete;

            System.out.println("O preço atual da compra é: " + precoFinal);
            precoTotal += precoFinal;
        }
        System.out.print("O preço final da compra é: " + precoTotal);
    }
}