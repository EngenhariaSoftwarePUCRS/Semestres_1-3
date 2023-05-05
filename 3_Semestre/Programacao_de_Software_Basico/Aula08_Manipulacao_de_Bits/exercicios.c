#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void printBinary(unsigned int val);
unsigned int generateBinary();
unsigned int getRand();
unsigned int clear(unsigned int val);
unsigned int setBit(unsigned int x, int bit);
unsigned int clearBit(unsigned int x, int bit);
unsigned int toggleBit(unsigned int x, int bit);
unsigned int testBit(unsigned int x, int bit);

int main()
{
    srand(time(NULL));
    unsigned int a = generateBinary();
    int bit = getRand();

    printf("a:              ");
    printBinary(a);

    printf("clear:          ");
    printBinary(clear(a));

    printf("setBit(%d):     ", bit);
    printBinary(setBit(a, bit));

    printf("clearBit(%d):   ", bit);
    printBinary(clearBit(a, bit));

    printf("toggleBit(%d):  ", bit);
    printBinary(toggleBit(a, bit));

    printf("testBit(%d):    ", bit);
    printBinary(testBit(a, bit));

    return 0;
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
    return x & ~(1 << bit);
}

unsigned int toggleBit(unsigned int x, int bit)
{
    return x ^ 1 << bit;
}

unsigned int testBit(unsigned int x, int bit)
{
    return x & 1 << bit;
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

unsigned int generateBinary()
{
    unsigned int val = 0;
    for (int i = 0; i < 32; i++)
    {
        val = val << 1;
        val += getRand() % 2;
    }
    return val;
}

unsigned int getRand()
{
    unsigned int upper = 32;
    return (rand() % upper);
}
