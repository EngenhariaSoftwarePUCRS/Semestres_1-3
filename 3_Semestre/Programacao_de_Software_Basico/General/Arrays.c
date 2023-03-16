#include <stdio.h>

void br() {
    printf("\n");
}

int main() {
    int array[5] = {1, 2, 3, 4, 5};
    char nome[6] = {'f', 'e', 'l', 'i', 'p', 'e'};
    float idades[4] = {1.1, 2.2, 3.3, 4.4};

    br();

    for (int i = 0; i < 5; i++)
        printf("%d ", array[i]);

    br();

    for (int i = 0; i < 6; i++)
        printf("%c", nome[i]);

    br();

    for (int i = 0; i < 4; i++) {
        printf("%f, ", idades[i]);
        printf("%.2f, ", idades[i]);
    }

    br(); br();
    return 0;
}
