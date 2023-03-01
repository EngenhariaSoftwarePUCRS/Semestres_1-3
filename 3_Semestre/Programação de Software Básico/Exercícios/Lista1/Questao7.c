/*
    Escreva uma função para um caixa de banco, que recebe um valor inteiro R e algumas variáveis (por referência) para armazenar o número de notas de 100, 50, 10, 5 e 1 reais, necessárias para pagar a quantia R. Faça de forma que o número de notas usado seja o menor possível.

    TODO: Não está funcionando no compilador online, revisar.
*/

#include <stdio.h>

void saqueCaixaDeBanco(int R, int *pc100, int *pc50, int *pc10, int *pc5, int *pc1)
{
    do
    {
        if (R / 100 >= 1)
        {
            printf("100 - %d", R);
            R = R - R / 100 * 100;
            printf("100 - %d", R);
            *pc100 = R;
        }
        else if (R / 50 >= 1)
        {
            printf("50 - %d", R);
            R = R - R / 50 * 50;
            printf("50 - %d", R);
            *pc50 = R;
        }
        else if (R / 10 >= 1)
        {
            printf("25 - %d", R);
            R = R - R / 10 * 10;
            printf("25 - %d", R);
            *pc10 = R;
        }
        else if (R / 5 >= 1)
        {
            printf("5 - %d", R);
            R = R - R / 5 * 5;
            printf("5 - %d", R);
            *pc5 = R;
        }
        else if (R / 1 >= 1)
        {
            printf("1 - %d", R);
            R = R - R / 1 * 1;
            printf("1 - %d", R);
            *pc1 = R;
        }
    } while (R % 100 != 0);
}

int main()
{
    int saque;
    int
        c100,
        *pc100 = &c100,
        c50, *pc50 = &c50,
        c10, *pc10 = &c10,
        c5, *pc5 = &c5,
        c1, *pc1 = &c1;

    printf("Digite quanto você quer sacar: ");
    scanf("%d", &saque);

    saqueCaixaDeBanco(saque, *pc100, *pc50, *pc10, *pc5, *pc1);

    printf("%d notas de R$100.\n", c100);
    printf("%d notas de R$50.\n", c50);
    printf("%d notas de R$10.\n", c10);
    printf("%d notas de R$5.\n", c5);
    printf("%d moedas de R$1.\n", c1);

    return 0;
}
