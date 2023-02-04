#include <stdio.h>
#include <stdlib.h>

int isBinary(int number) {
    while(number > 0) {
        if (number % 10 != 0 && number % 10 != 1) return 0;
        number /= 10;
    }

    return 1;
}

int Pow(int base, int exponent) {
    int result = 1;

    while (exponent > 0) {
        result *= base;
        exponent--;
    }

    return result;
}

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

int getDecimalFromBinary(int number) {
    if (!isBinary(number)) {
        printf("\nInvalid Non Binary number received.");
        return -1;
    }

    int result = 0;
    int power = 0;

    while (number > 0) {
        // If the last digit is not zero (1), then add 2 to its power to the sum
        if (number % 10)
            result += Pow(2, power);
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
    if (isBinary(number))
        printf("\nBinary (%d) is equal to decimal (%d) ", number, getDecimalFromBinary(number));
    else
        printf("\nThis number cannot be converted to decimal as it is not in binary format.");

    return 0;
}
