#include <stdio.h>
#include <stdlib.h>

int main() {
    int* numbers_unsafe = malloc(sizeof(int) * 10);
    int* numbers = malloc(10 * sizeof *numbers);

    for (int i = 0; i < 10; i++)
        numbers[i] = i;

    for (int i = 0; i < 10; i++)
        printf("%d\n", numbers[i]);

    free(numbers);

    return 0;
}
