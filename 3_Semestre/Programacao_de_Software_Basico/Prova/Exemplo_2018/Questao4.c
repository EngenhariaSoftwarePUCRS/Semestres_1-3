/*
  Qual é a saída na tela do seguinte programa?
*/
#include <stdio.h>
#include <string.h>

int main()
{
    char texto[2][17];
    int i;
    strcpy(texto[0], "Isto é um teste de uma string");
    strcpy(texto[1], "em C.");
    for (i = 0; i < 2; i++)
    {
        printf("%s\n", texto[i]);
    }
    return 0;
}
