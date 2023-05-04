#include <stdio.h>

void printBinary(unsigned int val);
unsigned int clear(unsigned int val);
unsigned int setBit(unsigned int x, int bit);
unsigned int clearBit(unsigned int x, int bit);
unsigned int toggleBit(unsigned int x, int bit);
unsigned int testBit(unsigned int x, int bit);

int main()
{
    unsigned int a = 1;

    printf("a: ");
    printBinary(a);

    printf("clear: ");
    printBinary(clear(a));

    printf("setBit: ");
    printBinary(setBit(a, 31));

    printf("clearBit: ");
    printBinary(clearBit(a, 31));

    printf("toggleBit: ");
    printBinary(toggleBit(a, 31));

    printf("testBit: ");
    printBinary(testBit(a, 31));
    return 0;
}

void printBinary(unsigned int val)
{
    unsigned mask = 1 << 31;
    for (int bit = 0; bit < 32; bit++)
    {
        if (val & mask)
        {
            printf("1");
        }
        else
        {
            printf("0");
        }
        mask >>= 1;
    }
    printf("\n");
}

unsigned int clear(unsigned int val)
{
    return val & 0;
}

unsigned int setBit(unsigned int x, int bit)
{
    return x | 1 << bit;
}

unsigned int clearBit(unsigned int x, int bit)
{
    return x & (1 | (0 << bit));
}

unsigned int toggleBit(unsigned int x, int bit)
{
    return x ^ 1 << bit;
}

unsigned int testBit(unsigned int x, int bit)
{
}
