#include <stdio.h>
#include <stdlib.h>

int isBinary(int number) {
    while(number > 0) {
        if (number % 10 != 0 && number % 10 != 1) return 0;
        number /= 10;
    }

    return 1;
}

int MathPow(int base, int exponent) {
    int result = 1;

    while (exponent > 0) {
        result *= base;
        exponent--;
    }

    return result;
}

int getValueFromBinary(int number) {
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

    if (!isBinary(number)) {
        printf("\nInvalid Non Binary number inserted");
        exit(0);
    }

    printf("\nBinary (%d) is equal to decimal (%d) ", number, getValueFromBinary(number));

    return 0;
}
