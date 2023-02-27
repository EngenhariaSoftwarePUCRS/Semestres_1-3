/*
    Escreva uma função que calcula o valor (aproximado) de cos(x), dado pela aproximação abaixo:
    cos(x) ≈ 1
            − x² / 2!
            + x4 / 4!
            − x6 / 6!
            + ···
    Faça a soma com três termos, e escreva um programa que recebe valores de x e calcula seu cosseno, calculando também a função cosseno disponível em C e apresentando a diferença entre os resultados obtidos. Se você achar o erro grande demais, recalcule com mais termos e compare outra vez. Use novamente a função fatorial já criada.
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

    printf("Digite o valor de n: ");
    scanf("%d", &n);
    printf("Soma: %f", soma(n));

    return 0;
}
