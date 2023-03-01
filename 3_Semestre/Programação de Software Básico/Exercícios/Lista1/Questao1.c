/*
Descubra quantos bits são usados no seu compilador preferido para armazenar os tipos
    short
    int,
    int,
    long int
    e long long int.
Use o operador sizeof(x) para isso, onde x pode ser uma variável ou mesmo um tipo de dado.
*/

#include <stdio.h>

int main()
{
    short s;
    int i;
    long int li;
    long long int lli;

    printf("short: %d bytes\n", sizeof(s));
    printf("int: %d bytes\n", sizeof(i));
    printf("long int: %d bytes\n", sizeof(li));
    printf("long long int: %d bytes\n", sizeof(lli));

    return 0;
}
