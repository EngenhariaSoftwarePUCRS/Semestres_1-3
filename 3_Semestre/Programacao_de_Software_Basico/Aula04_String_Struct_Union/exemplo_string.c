#include <stdio.h>
#include <string.h>

int main() {
    char msg[] = "Hello!";
    char msg2[30];

    printf("msg: %s\n", msg);

    // Tamanho da string: strlen
    printf("Comprimento de msg: %d\n", strlen(msg));

    // Cópia de strings: strcpy
    // Inválido
    // msg2 = "Outra msg";

    strcpy(msg2, "outra msg");
    printf("msg2: %s\n", msg2);
    printf("Comprimento de msg2: %ld\n", strlen(msg2));

    /*strcpy(msg2, "outra msg muito longa que não cabe na string original");
    printf("msg2: %s\n", msg2);
    printf("Comprimento de msg2: %ld\n", strlen(msg2));*/

    strncpy(msg2, "outra msg muito longa que não cabe na string original", 30);
    printf("msg2: %s\n", msg2);
    printf("Comprimento de msg2: %ld\n", strlen(msg2));

    // Concatenar strings: strcat
    char msg3[60];
    strcpy(msg3, msg);
    strcat(msg3, msg2);
    printf("msg3: %s\n\n", msg3);

    // Sempre cuidar o espaço
    char str1[10] = "String1";
    char str2[10] = "teste";
    char str3[10] = "outra";

    printf("str1: %s\n", str1);
    printf("str2: %s\n", str2);
    printf("str3: %s\n", str3);

    //strcat(str3, str2);
    strcat(str2, str3);

    printf("str1: %s\n", str1);
    printf("str2: %s\n", str2);
    printf("str3: %s\n", str3);
    printf("str3[1]: %c\n", str3[1]);

    // Leitura de strings
    char nome[30];

    printf("Digite seu nome: ");
    // scanf("%s", nome);
    // gets(nome) --> NUNCA USE, NEVER, JAMAIS, NEM EM APOCALIPSE
    fgets(nome, 29, stdin); //--> Seguro, limita caracteres

    char sobrenome[31];
    printf("Digite seu sobrenome: ");
    fgets(sobrenome, 29, stdin); //--> Seguro, limita caracteres
    printf("Olá, %s\n", nome);

    int compareTo = strcmp(nome, sobrenome);
    printf("Diferença: %d\n", compareTo);

    if (compareTo < 0)
        printf("%s vem antes de %s", nome, sobrenome);
    else if (compareTo > 0)
        printf("%s vem antes de %s", sobrenome, nome);
    else
        printf("%s é igual a %s", nome, sobrenome);

    return 0;
}
