#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define SIZE 200000000

int main() {
    double* array = malloc(sizeof *array * SIZE);
    printf("tam. mem: %lu\n", sizeof *array * SIZE);
    for (int i = 0; i < SIZE; i++)
        array[i] = i;
    // Olhar o uso de memória no monitor de sistema
    sleep(10);
    free(array);
    printf("Liberada!\n");
    return 0;
}
