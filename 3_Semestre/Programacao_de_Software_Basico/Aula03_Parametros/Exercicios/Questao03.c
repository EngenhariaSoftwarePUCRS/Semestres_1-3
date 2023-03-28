#include <stdio.h>

int quantidadeValoresRepetidos(int *vetor, int quantidadeValores);

int main()
{
    int quantidadeValores = 11;
    int vetor[11] = {2, 4, 5, 4, 2, 4, 3, 2, 1, 2, 5};

    int quantidadeRepetida = quantidadeValoresRepetidos(vetor, quantidadeValores);

    printf("Quantidade de valores repetidos: %d \n", quantidadeRepetida);

    return 0;
}

int quantidadeValoresRepetidos(int *vetor, int quantidadeValores)
{
    int quantidadeValoresRepetidos = 0;
    int valoresRepetidos[quantidadeValores];
    for (int i = 0; i < quantidadeValores; i++)
        valoresRepetidos[i] = 0;

    for (int i = 0; i < quantidadeValores; i++)
        for (int j = 0; j < quantidadeValores; j++)
        {
            if (i >= j)
                continue;
            // printf("\n[%d, %d] = [%d, %d]\n", i, j, vetor[i], vetor[j]);
            if (vetor[i] == vetor[j])
            {
                // printf("Iguais %d e %d\n", vetor[i], vetor[j]);
                int alreadyCounted = -1;

                for (int k = 0; k < quantidadeValores; k++)
                {
                    // printf("valoresRepetidos[k], (k=%d) --> %d\n", k, valoresRepetidos[k]);
                    if (valoresRepetidos[k] == vetor[i])
                    {
                        alreadyCounted = 1;
                        break;
                    }
                }

                if (alreadyCounted == -1)
                    for (int l = 0; l < quantidadeValores; l++)
                        if (valoresRepetidos[l] == 0)
                        {
                            // printf("Iguais mesmo %d e %d\n", vetor[i], vetor[j]);
                            // printf("=======================\n");
                            valoresRepetidos[l] = vetor[i];
                            quantidadeValoresRepetidos++;
                            break;
                        }
            }
        }

    return quantidadeValoresRepetidos;
}