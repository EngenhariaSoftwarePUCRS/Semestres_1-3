#include <stdio.h>

// [] == *
// diferença é apenas para o programador
// int *v == int v[]
// int **v == int v[][]
// normalmente, utiliza-se a notação com parenteses
// para denotar um vetor e não uma variável qualquer
void incArray(int v[], int tam);
void exibeArray(int v[], int tam);

int main()
{
    int b = 200;
    int *a = &b;
    // scanf("%d", &b);
    printf("&b: %p\n", &b);
    printf("a : %p\n", a);
    printf("*a: %d\n", *a);

    int data[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    exibeArray(data, 10);
    incArray(data, 10);
    exibeArray(data, 10);

    char c[10] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
    printf("c: %p\n", c);
    char *p = c; // não precisa &, pois c já é um ponteiro

    printf("*p   : %c\n", *p); // exibe o primeiro elemento
    printf("p[0] : %c\n", p[0]); // exibe o primeiro elemento

    printf("p    : %p\n", p); // exibe o endereço do primeiro elemento
    printf("c    : %p\n", c); // exibe o endereço do primeiro elemento
    printf("&c[0]: %p\n", &c[0]); // exibe o endereço do primeiro elemento

    printf("%c\n", *p);     // exibe 'a'
    printf("%c\n", *(p+1)); // exibe 'b'
    printf("%c\n", *(p+2)); // exibe 'c'
    printf("%c\n", *(p+3)); // exibe 'd'

    // c[5] => *(c+5) - são equivalentes

    int m[] = { 3, 2, 1, 4, 5, 6, 9, 8, 7, 10 };

    printf("m    :%p\n", m);     // end. do primeiro elem., e.g. 0x7fff5fbfebf8
    printf("&m[0]:%p\n", &m[0]); // idem
    printf("m+1  :%p\n", m+1);   // end. do segundo elem., e.g. 0x7fff5fbfebfc
    printf("&m[1]:%p\n", &m[1]); // idem
}

void incArray(int v[], int tam)
{
    for (int i = 0; i < tam; i++)
        v[i]++;
}

void exibeArray(int v[], int tam) {
    for (int i = 0; i < tam; i++)
        printf("%d ", v[i]);
    printf("\n");
}
