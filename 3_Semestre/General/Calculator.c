#include <stdio.h>

int main() {
    int a = 5;
    int b = 2;

    printf("Sum of %d and %d: %d\n", a, b, add(a, b));
    printf("Dif of %d and %d: %d\n", a, b, sub(a, b));
    printf("Mul of %d and %d: %d\n", a, b, mul(a, b));
    printf("Div of %d and %d: %d\n", a, b, div(a, b));

    return 0;
}

int add(int a, int b) {
    return a + b;
}

int sub(int a, int b) {
    return a - b;
}

int mul(int a, int b) {
    return a * b;
}

int div(int a, int b) {
    return a / b;
}