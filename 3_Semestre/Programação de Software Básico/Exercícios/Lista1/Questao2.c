/*
    Escreva uma função que faz a conversão de temperaturas de Fahrenheit para Celsius, segundo a fórmula conhecida:
    C = 5 / 9 ∗ (F − 32)
    Depois de pronta, faça um programa para descobrir em que temperatura as duas escalas coincidem. Use papel, lápis e um pouco de matemática do ensino fundamental e confirme o resultado. Analise um pouco antes de programar e pense nisso: se você escrever a fórmula de conversão (na maioria das linguagens de programação) exatamente como ela foi dada acima, o resultado da conversão será sempre zero. Explique o motivo e corrija.

    O resultado será 0 visto que é uma divisão de inteiros 5/9 (que não gera um número fracionário)
*/

#include <stdio.h>

float fahrenheitToCelsius(float fahrenheit)
{
    return 5.0 / 9.0 * (fahrenheit - 32);
}

int main()
{
    float fahrenheit = 0;
    float celsius = 0;

    printf("Digite a temperatura em Fahrenheit: ");
    scanf("%f", &fahrenheit);

    celsius = fahrenheitToCelsius(fahrenheit);

    printf("A temperatura em Celsius é: %f\n", celsius);

    return 0;
}
