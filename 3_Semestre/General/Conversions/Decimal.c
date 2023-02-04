#include <stdio.h>
#include <stdlib.h>

int getBinaryFromDecimal(int number) {
    int result = 0;
    int i = 1;

    while (number != 0) {
        result += number % 2 * i;
        number /= 2;
        i *= 10;
    }

   return result;
}

int main() {
    int number;

    printf("\nType the number you wish to convert: ");
    scanf("%d", &number);

    printf("\nDecimal (%d) is equal to Binary (%d) ", number, getBinaryFromDecimal(number));

    return 0;
}
