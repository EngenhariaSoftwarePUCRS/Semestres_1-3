/*
    Crie outra função similar à função do programa do exercício 3 para determinar também quantos segundos ainda faltam até o dia terminar.
*/

#include <stdio.h>

int segundosRestantes(int horas, int minutos, int segundos)
{
    return 86400 - (horas * 3600 + minutos * 60 + segundos);
}

int main()
{
    int horas = 0;
    int minutos = 0;
    int segundos = 0;
    int segundosRestantesDoDia = 0;

    printf("Digite o horário (hh:mm:ss): ");
    scanf("%d:%d:%d", &horas, &minutos, &segundos);

    segundosRestantesDoDia = segundosRestantes(horas, minutos, segundos);

    printf("Faltam %d segundos para o dia terminar.", segundosRestantesDoDia);

    return 0;
}
