/*
    Seus colegas da Biologia criaram uma bactéria que come lixo, consumindo cerca de metade de seu peso em lixo todos os dias. (Para facilitar, vamos supor que uma bactéria pesa cerca de 10e−11 gramas). Seus colegas tem apenas cinco dessas bactérias, mas elas se dividem em duas todos os dias. A partir daí, escreva um programa que imprime uma tabela a partir do primeiro dia, quando existem apenas cinco bactérias, até dois meses depois (você terá de usar inteiros longos ou números de ponto flutuante para isso). A tabela deve listar o número do dia, quantas bactérias existem até o momento e quanto lixo elas comeram naquele dia. Depois de fazer isso, adapte seu programa para estas situações:

        (a) Suponha que as bactérias vivem apenas cinco dias. Neste caso, as bactérias que morrem devem ser descontadas do total.

        (b) Faça seu programa se adaptar às unidades de peso: de acordo com a quantidade de lixo consumida as unidades devem ser escritas em microgramas (10−6 g), miligramas (10−3 g), gramas, quilogramas ou toneladas, usando a maior unidade onde o peso seja maior do que um. Por exemplo, se for preciso imprimir 0.0037 gramas, você deve escolher 3.7 miligramas, e não 3700 microgramas.

        TODO: Review
*/

#include <math.h>
#include <stdio.h>

void printHeading()
{
    printf("Dia\t\tBactérias\t\t\t\tLixo\n");
}

void printLine(int day, int bacteriasAmount, float waste)
{
    printf("%d\t\t%d\t\t\t\t%f\n", day, bacteriasAmount, waste);
}

void printLineWithUnit(int day, int bacteriasAmount, float waste, char *unit)
{
    printf("%d\t\t%d\t\t\t\t%f%s\n", day, bacteriasAmount, waste, unit);
}

float getConvertedValue(float value)
{
    if (value >= 1000000000)
    {
        return value /= 1000000000;
    }

    if (value >= 1000000)
    {
        return value /= 1000000;
    }

    if (value >= 1000)
    {
        return value /= 1000;
    }

    if (value >= 1)
    {
        return value /= 1;
    }

    return value *= 1000000;
}
char getConvertedUnit(float value)
{
    if (value >= 1000000000)
    {
        return 'T';
    }

    if (value >= 1000000)
    {
        return 'M';
    }

    if (value >= 1000)
    {
        return 'K';
    }

    if (value >= 1)
    {
        return 'G';
    }

    return 'U';
}

int main()
{
    printf("\n\n========================================\n");
    printf("\t\tSituação Inicial:\n\n");
    long long int bacteriasAmount = 5;
    int day;
    float BACTERIA_WEIGHT = 0.00000000001;
    float waste;

    printHeading();
    for (day = 1; day <= 60; day++)
    {
        printLine(day, bacteriasAmount, waste);
        bacteriasAmount = pow(2, day) * 5;
        waste += BACTERIA_WEIGHT / 2;
    }

    printf("\n\n========================================\n");
    printf("\t\tSituação a:\n\n");
    a();

    printf("\n\n========================================\n");
    printf("\t\tSituação b:\n\n");
    b();

    return 0;
}

void a()
{
    // long int bacteriasAmount = 5;
    // int bacteriasAmountDayPrior = 0;
    // int bacteriasAmountDayCurrent = bacteriasAmount;
    // int deadBacteriasOverall = 0;
    // float BACTERIA_WEIGHT = 0.00000000001;
    // int day;
    // float waste;

    // printHeading();
    // printLine(day, bacteriasAmount, waste);
    // for (day = 1; day <= 60; day++)
    // {
    //     bacteriasAmountDayPrior = bacteriasAmountDayCurrent;
    //     bacteriasAmountDayCurrent = bacteriasAmount;
    //     bacteriasAmount *= 2;
    //     deadBacteriasOverall = bacteriasAmountDayPrior - bacteriasAmountDayCurrent;
    //     bacteriasAmount -= deadBacteriasOverall;
    //     waste += BACTERIA_WEIGHT / 2;
    //     printLine(day, bacteriasAmount, waste);
    // }
}

void b()
{
    // long int bacteriasAmount = 5;
    // int day = 1;
    // float BACTERIA_WEIGHT = 0.00000000001;
    // float waste;

    // printHeading();
    // printLine(day, bacteriasAmount, waste);
    // for (day = 1; day <= 60; day++)
    // {
    //     bacteriasAmount *= 2;
    //     waste += BACTERIA_WEIGHT / 2;
    //     float visualWaste = getConvertedValue(waste);
    //     char unit = getConvertedUnit(waste);

    //     printLineWithUnit(day, bacteriasAmount, visualWaste, unit);
    // }
}
