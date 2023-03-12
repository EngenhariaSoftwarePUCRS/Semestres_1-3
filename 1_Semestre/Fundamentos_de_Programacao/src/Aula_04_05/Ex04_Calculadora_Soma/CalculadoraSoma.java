package Aula_04_05.Ex04_Calculadora_Soma;

public class CalculadoraSoma {
    // 4- Escreva um programa que calcula a soma dos dez primeiros números
    // positivos, 1 + 2 + ... + 10
    public static void main(String[] args) {
        int soma = 0;
        for (int i = 1; i <= 10; i++)
            soma += i;
        System.out.println(soma);
    }
}
