#include "bibfunc.h"

long fatorial(int v)
{
    long res = 1;
    for (int i = v; i > 1; i--)
        res *= i;
    return res;
}

long somatorio(int v)
{
    long soma = 0, i;
    for (int i = 1; i <= v; i++)
        soma += i;
    return soma;
}