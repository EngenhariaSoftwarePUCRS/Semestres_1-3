/*
    Implemente a sua versão da função char* strstr(char s1[], char s2[]), que procura a string s2 em s1 e retorna:
    • um ponteiro para a primeira posição de s2 em s1, se encontrá-la.
    • um ponteiro para s1, se s2 for vazia.
    • NULL, se s2 não estiver presente em s1.
    Considere que as strings são NULL-terminated, isto é, são finalizadas com o caractere 0.
*/

#include <stdio.h>
#include <stdlib.h>

char *strstr(char s1[], char s2[]);
int main()
{
    char s1[100], s2[100];
    char *p;
    printf("Digite a string s1: ");
    scanf("%s", s1);
    printf("Digite a string s2: ");
    scanf("%s", s2);
    p = strstr(s1, s2);
    if (p == NULL)
        printf("NULL\n");
    else
        printf("%s\n", p);
    return 0;
}

char *strstr(char s1[], char s2[])
{
    int i, j, k;
    for (i = 0; s1[i] != '\0'; i++)
    {
        for (j = 0, k = i; s2[j] != '\0' && s1[k] == s2[j]; j++, k++)
            ;
        if (s2[j] == '\0')
            return &s1[i];
    }
    return NULL;
}
