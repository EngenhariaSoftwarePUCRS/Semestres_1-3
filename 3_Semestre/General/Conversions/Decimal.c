#include <stdio.h>
#include <stdlib.h>

int MathPow(int base, int exponent) {
    int result = 1;

    while (exponent > 0) {
        result *= base;
        exponent--;
    }

    return result;
}

int getBinaryFromDecimal(int number) {
    int result = 0;
    int power = 0;

    while (number > 0) {
        // If the last digit is not zero (1), then add 2 to its power to the sum
        if (number % 10)
            result += MathPow(2, power);
        number /= 10;
        power++;
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
