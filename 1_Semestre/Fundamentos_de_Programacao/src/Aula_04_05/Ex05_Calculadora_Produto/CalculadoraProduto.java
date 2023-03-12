package Aula_04_05.Ex05_Calculadora_Produto;

public class CalculadoraProduto {
    // 4- Escreva um programa que calcula o produto dos dez primeiros números
    // positivos, 1 * 2 * ... * 10
    public static void main(String[] args) {
        int produto = 1;
        for (int i = 1; i <= 10; i++)
            produto *= i;
        System.out.println(produto);
    }
}
