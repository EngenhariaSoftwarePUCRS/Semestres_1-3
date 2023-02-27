/*
    Escreva uma função para calcular a soma a seguir. Crie uma função auxiliar para calcular o fatorial de um número:
    n! = n × n − 1 × n − 2 ··· × 1
    S =     1
        + 1 / 2!
        + 1 / 3!
        + 1 / 4!
        + ···
        + 1 / 8!
*/

int fatorial(int n)
{
    int i;
    int fatorial = 1;

    for (i = 1; i <= n; i++)
    {
        fatorial = fatorial * i;
    }

    return fatorial;
}

float soma(int n)
{
    int i;
    float soma = 0;

    for (i = 1; i <= n; i++)
    {
        soma = soma + 1 / fatorial(i);
    }

    return soma;
}

int main()
{
    int n;

    printf("Digite um número inteiro: ");
    scanf("%d", &n);

    printf("Soma: %f", soma(n));

    return 0;
}
