#include <stdio.h>

void swap(int*, int*);

void swap(int *var1, int *var2) {
    int temp = *var1;
    *var1 = *var2;
    *var2 = temp;
}

int main() {
    int x = 10, y = 5;
    swap(&x, &y);
    printf("x = %d, y = %d\n", x, y);
    return 0;
}
