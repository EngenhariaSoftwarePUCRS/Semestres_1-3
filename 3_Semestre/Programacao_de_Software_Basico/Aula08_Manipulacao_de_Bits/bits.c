#include <stdio.h>

int main()
{
    int var = 2;
    unsigned int var2 = 0b11111110;
    char var3 = 254;
    unsigned char var4 = 0XFE;
    printf("var: %d\n", var);
    printf("var2: %d\n", var2);
    printf("var3: %d\n", var3);
    printf("var4: %d\n", var4);
    printf("var: %02X\n", var);
    printf("var2: %02X\n", var2);
    printf("var3: %02X\n", var3);
    printf("var4: %02X\n", var4);

    unsigned char a = 0b11000100;
    unsigned char b = 0b10110110;

    printf("a: %02X\n", a);
    printf("b: %02X\n", b);

    // Operadores bit a bit
    // & (AND)
    printf("a & b: %02X\n", a & b);
    // | (OR)
    printf("a | b: %02X\n", a | b);
    // ^ (XOR)
    printf("a ^ b: %02X\n", a ^ b);
    // ~ (NOT)
    printf("~a: %02X\n", ~a);
    printf("~b: %02X\n", ~b);

    a = 0b01;
    b = 0b10;
    // << (deslocamento para esquerda)
    printf("a << 2: %02X\n", a <<= 1);
    printf("b << 2: %02X\n", b <<= 1);
    // >> (deslocamento para direita)
    printf("a >> 2: %02X\n", a >>= 1);
    printf("b >> 2: %02X\n", b >>= 1);

    return 0;
}
