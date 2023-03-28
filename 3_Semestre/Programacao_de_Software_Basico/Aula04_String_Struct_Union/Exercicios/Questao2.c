// Escreva uma função chamada minha_substring, que recebe duas strings como parâmetro e verifica se a segunda é substring da primeira, retornando a posição onde ela começa na primeira.Caso não seja encontrada, retorne - 1 :

#include <stdio.h>
#include <string.h>

int minha_substring(char str1[], char str2[]);

int main()
{
    char primeira[] = "Java";
    char segunda[] = "Javascript";

    int isSubstring = minha_substring(primeira, segunda);

    if (isSubstring == -1)
        printf("%s não está contido em %s\n", segunda, primeira);
    else
        printf("%s contém %s\n", primeira, segunda);

    return 1;
}

int minha_substring(char str1[], char str2[])
{
    for (int i = 0; i < strlen(str1); i++)
        for (int j = 0; j < strlen(str2); j++)
            if (str2[j] != str1[i])
                break;

    return -1;
}