/*
    Escreva uma função que recebe um horário (horas, minutos, segundos) e determina quantos segundos já se passaram desde que o dia começou.
*/

int segundosDecorridos(int horas, int minutos, int segundos)
{
    return horas * 3600 + minutos * 60 + segundos;
}

int main()
{
    int horas = 0;
    int minutos = 0;
    int segundos = 0;
    int segundosDesdeMeiaNoite = 0;

    printf("Digite o horário (hh:mm:ss): ");
    scanf("%d:%d:%d", &horas, &minutos, &segundos);

    segundosDesdeMeiaNoite = segundosDecorridos(horas, minutos, segundos);

    printf("Já se passaram %d segundos desde meia-noite.", segundosDesdeMeiaNoite);

    return 0;
}
