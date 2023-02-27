/*
    Escreva uma função para um caixa de banco, que recebe um valor inteiro R e algumas variáveis (por referência) para armazenar o número de notas de 100, 50, 10, 5 e 1 reais, necessárias para pagar a quantia R. Faça de forma que o número de notas usado seja o menor possível.
*/

void saqueCaixaDeBanco(int R, int *c100, int *c50, int *c10, int *c5, int *c1)
{
    do
    {
        if (R / 100 >= 1)
        {
            R = R - R / 100 * 100;
            c100 = R;
        }
        else if (R / 50 >= 1)
        {
            R = R - R / 50 * 50;
            c50 = R;
        }
        else if (R / 10 >= 1)
        {
            R = R - R / 10 * 10;
            c10 = R;
        }
        else if (R / 5 >= 1)
        {
            R = R - R / 5 * 5;
            c5 = R;
        }
        else if (R / 1 >= 1)
        {
            R = R - R / 1 * 1;
            c1 = R;
        }
    } while (R % 100 != 0);
}

int main()
{
    int saque;
    int c100, c50, c10, c5, c1;

    printf("Quanto você quer sacar?");
    scanf("%d", &saque);

    saqueCaixaDeBanco(saque, &c100, &c50, &c10, &c5, &c1);

    printf("%d notas de R$100.", c100);
    printf("%d notas de R$50.", c50);
    printf("%d notas de R$10.", c10);
    printf("%d notas de R$5.", c5);
    printf("%d moedas de R$1.", c1);

    return 0;
}
