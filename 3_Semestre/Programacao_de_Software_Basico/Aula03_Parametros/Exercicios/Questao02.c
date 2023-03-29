#include <stdio.h>

void converteSegundos(int segundosDesdeMeiaNoite, int *horas, int *minutos, int *segundos);

int main()
{
    int segundosDesdeMeiaNoite, horas, minutos, segundos;
    printf("Digite o tempo em segundos: ");
    scanf("%d", &segundosDesdeMeiaNoite);
    converteSegundos(segundosDesdeMeiaNoite, &horas, &minutos, &segundos);
    printf("%d segundos passados desde a meia noite equivalem a %d horas, %d minutos e %d\n", segundos, horas, minutos, segundos);
    return 0;
}

void converteSegundos(int segundosDesdeMeiaNoite, int *horas, int *minutos, int *segundos)
{
    *horas = segundosDesdeMeiaNoite / 3600;
    *minutos = (segundosDesdeMeiaNoite % 3600) / 60;
    *segundos = (segundosDesdeMeiaNoite % 3600) % 60;
}
