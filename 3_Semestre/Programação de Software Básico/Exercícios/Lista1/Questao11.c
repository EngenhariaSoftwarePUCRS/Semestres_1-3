/*
    Seus colegas da Biologia criaram uma bactéria que come lixo, consumindo cerca de metade de seu peso em lixo todos os dias. (Para facilitar, vamos supor que uma bactéria pesa cerca de 10−11 gramas). Seus colegas tem apenas cinco dessas bactérias, mas elas se dividem em duas todos os dias. A partir daí, escreva um programa que imprime uma tabela a partir do primeiro dia, quando existem apenas cinco bactérias, até dois meses depois (você terá de usar inteiros longos ou números de ponto flutuante para isso). A tabela deve listar o número do dia, quantas bactérias existem até o momento e quanto lixo elas  naquele dia. Depois de fazer isso, adapte seu programa para estas situações:

        (a) Suponha que as bactérias vivem apenas cinco dias. Neste caso, as bactérias que morrem devem ser descontadas do total.

        (b) Faça seu programa se adaptar às unidades de peso: de acordo com a quantidade de lixo consumida as unidades devem ser escritas em microgramas (10−6 g), miligramas (10−3 g), gramas, quilogramas ou toneladas, usando a maior unidade onde o peso seja maior do que um. Por exemplo, se for preciso imprimir 0.0037 gramas, você deve escolher 3.7 miligramas, e não 3700 microgramas.

        TODO: Review
*/

int main()
{
    int i;
    int bact = 5;
    float lixo = 0.00000000001;
    float lixoTotal = 0.00000000001;

    printf("Dia\tBactérias\tLixo\tLixo Total\n");
    printf("1\t%d\t\t%f\t%f\n", bact, lixo, lixoTotal);

    for (i = 2; i <= 60; i++)
    {
        bact = bact * 2;
        lixo = lixo * 2;
        lixoTotal = lixoTotal + lixo;
        printf("%d\t%d\t\t%f\t%f\n", i, bact, lixo, lixoTotal);
    }

    return 0;
}
