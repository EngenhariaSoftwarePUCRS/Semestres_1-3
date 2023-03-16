/*
    Escreva uma função para um caixa de banco, que recebe um valor inteiro R e algumas variáveis (por referência) para armazenar o número de notas de 100, 50, 10, 5 e 1 reais, necessárias para pagar a quantia R. Faça de forma que o número de notas usado seja o menor possível.
*/

#include <stdio.h>

void saqueCaixaDeBanco(int, int *, int *, int *, int *, int *);

void saqueCaixaDeBanco(int R, int *pc100, int *pc50, int *pc10, int *pc5, int *pc1)
{
    *pc100 = R / 100;
    *pc50 = R % 100 / 50;
    *pc10 = R % 50 / 10;
    *pc5 = R % 10 / 5;
    *pc1 = R % 5 / 1;
}

int main()
{
    int saque, c100, c50, c10, c5, c1;

    printf("Digite quanto você quer sacar: ");
    scanf("%d", &saque);

    saqueCaixaDeBanco(saque, &c100, &c50, &c10, &c5, &c1);

    if (c100 >= 1)
        printf("%d nota(s) de R$100.\n", c100);
    if (c50 >= 1)
        printf("%d nota(s) de R$50.\n", c50);
    if (c10 >= 1)
        printf("%d nota(s) de R$10.\n", c10);
    if (c5 >= 1)
        printf("%d nota(s) de R$5.\n", c5);
    if (c1 >= 1)
        printf("%d moeda(s) de R$1.\n", c1);

    return 0;
}
