/*
    Escreva uma função que recebe um valor inteiro n e retorna 1 se este valor for um número primo (0 se não for). Um número primo é divisível apenas por ele e por 1.
*/

int primo(int n)
{
    int i;
    int divisores = 0;

    for (i = 1; i <= n; i++)
    {
        if (n % i == 0)
        {
            divisores++;
        }
    }

    if (divisores == 2)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

int main()
{
    int n;

    printf("Digite um número inteiro: ");
    scanf("%d", &n);

    if (primo(n) == 1)
    {
        printf("O número %d é primo.", n);
    }
    else
    {
        printf("O número %d não é primo.", n);
    }

    return 0;
}
