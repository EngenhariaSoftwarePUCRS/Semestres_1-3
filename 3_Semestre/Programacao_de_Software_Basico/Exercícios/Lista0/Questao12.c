/*
    Use seu conhecimento adquirido nos exercícios anteriores para imprimir as primeiras doze linhas do triângulo de Pascal como mostrado abaixo. Faça isso usando funções e não se importe com o tempo gasto.
        1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1
        1 5 10 10 5 1
*/

#include <stdio.h>

int main()
{
    int i, j;
    int n = 5;
    int pascal[5][5];

    for (i = 0; i < n; i++)
    {
        for (j = 0; j <= i; j++)
        {
            if (j == 0 || j == i)
            {
                pascal[i][j] = 1;
            }
            else
            {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }
    }

    for (i = 0; i < n; i++)
    {
        for (j = 0; j <= i; j++)
        {
            printf("%d ", pascal[i][j]);
        }
        printf("\n");
    }

    return 0;
}
