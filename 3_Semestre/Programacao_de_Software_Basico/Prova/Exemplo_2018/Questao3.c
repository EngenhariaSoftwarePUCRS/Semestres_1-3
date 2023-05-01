/*
    Crie uma função que receba uma string formada por palavras e imprima na tela:
    a) a quantidade de palavras que esta string contém;
    b) o tamanho de cada palavra desta string, na ordem em que estas ocorrem na string.
    As palavras da string estão separadas por exatamente um espaço em branco. Para obter o tamanho de uma string, você pode usar a função int strlen(char* s), mas isto não é obrigatório.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char frase[100];
    int i, j, cont = 0, tam = 0;

    printf("Digite uma frase: ");
    gets(frase);

    for (i = 0; i < strlen(frase); i++)
    {
        if (frase[i] == ' ')
        {
            printf("Tamanho da palavra %d: %d\n", cont + 1, tam);
            cont++;
            tam = 0;
        }
        else
        {
            tam++;
        }
    }
    printf("Tamanho da palavra %d: %d\n", cont + 1, tam);
    printf("Quantidade de palavras: %d\n", cont + 1);

    return 0;
}
