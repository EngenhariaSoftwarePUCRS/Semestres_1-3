#include <stdio.h>

// Protótipo da função
void quadrado();

int main() {
    quadrado();
    return 0;
}

void quadrado() {
    for (int n = 1; n <= 10; n++)
        printf("%d\n", n * n);
}
