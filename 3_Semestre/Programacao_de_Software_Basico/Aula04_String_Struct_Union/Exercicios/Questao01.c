#include <stdio.h>

typedef struct
{
    float numerador;
    float denominador;
} Fracao;

void fracaoToString(const Fracao *f);
Fracao soma(const Fracao *a, const Fracao *b);
Fracao multiplica(const Fracao *a, const Fracao *b);

int main()
{
    Fracao a, b;
    a.numerador = 2.0;
    a.denominador = 3.0;

    b.numerador = 1.0;
    b.denominador = 3.0;

    printf("\nFração a: \n");
    fracaoToString(&a);

    printf("\nFração b: \n");
    fracaoToString(&b);

    printf("\nFração a + Fração b: \n");
    Fracao somadas = soma(&a, &b);
    fracaoToString(&somadas);

    printf("\nFração a * Fração b: \n");
    Fracao multiplicadas = multiplica(&a, &b);
    fracaoToString(&multiplicadas);

    return 0;
}

void fracaoToString(const Fracao *fracao)
{
    if (fracao->denominador == 1)
        printf("\t%.2f\n", fracao->numerador);
    else
        printf("\t%.2f\n      --------\n\t%.2f\n", fracao->numerador, fracao->denominador);
}

Fracao soma(const Fracao *a, const Fracao *b)
{
    // By default assume that denominators are equal
    Fracao resultante;
    resultante.numerador = a->numerador + b->numerador;
    resultante.denominador = a->denominador;

    if (a->denominador != b->denominador)
    {
        resultante.numerador = a->numerador * b->denominador + b->numerador * a->denominador;
        resultante.denominador = a->denominador * b->denominador;
    }

    return resultante;
}

Fracao multiplica(const Fracao *a, const Fracao *b)
{
    Fracao resultante;
    resultante.numerador = a->numerador * b->numerador;
    resultante.denominador = a->denominador * b->denominador;

    return resultante;
}