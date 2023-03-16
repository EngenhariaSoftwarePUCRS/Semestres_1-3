/*
    Um método para cálculo de raízes quadradas de um número N já era conhecido pelos babilônios em. . . bom, há muito tempo atrás. (Este método também é conhecido como método de Heron, um matemático grego que o descreveu 20 séculos depois dos babilônios, perto do ano 50 DC.) Começando de um valor inicial k (geralmente valendo um) os babilônios geravam um novo valor de k de acordo com a regra:
    k = (k + N/k) / 2
    À medida que o processo é repetido, os novos valores de k se aproximam cada vez mais da raiz de N. Escreva um programa que leia o valor de N e imprima os primeiros doze valores obtidos com esta fórmula, testando-os para ver se eles realmente se aproximam.
*/

#include <stdio.h>

int main()
{
    int N = 0;
    int k = 1;
    int i = 0;

    printf("Digite um número: ");
    scanf("%d", &N);

    for (i = 0; i < 12; i++)
    {
        k = (k + N / k) / 2;
        printf("%d\n", k);
    }

    return 0;
}
