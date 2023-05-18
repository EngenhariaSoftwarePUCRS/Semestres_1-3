#include <stdio.h>

void visualiza(unsigned char* ptr, int tam);

int main() {
    char* text = "Prog. Software Basico";
    int v[] = { 0, 1, 2, 3, 4 };
    int matriz[4][4] = {
        0, 1, 2, 3,
        4, 5, 6, 7,
        8, 9, 10, 11,
        12, 13, 14, 15
    };
    printf("Texto:\n");
    visualiza(text, 21);
    printf("\n");
    printf("Vetor v:\n");
    visualiza(v, sizeof(v));
    printf("\n");
    printf("matriz:\n");
    visualiza(matriz, sizeof(matriz));
    return 0;
}

void visualiza(unsigned char* ptr, int tam) {
    for (int i = 0; i < tam; i++) {
        if (i % 12 == 0) printf("\n%p: ", ptr + i);
        printf("%02X ", *(ptr + i));
    }
    printf("\n");
}
