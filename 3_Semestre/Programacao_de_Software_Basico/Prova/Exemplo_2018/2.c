#include <stdio.h>

// Esta função deve receber duas variáveis
// por referência e caso a primeira seja
// maior que a segunda, trocá-las entre si.

void trocaMaior(int* x, int* y) {
    if (*y >= *x) return;
    
    int temp = *x;
    *x = *y;
    *y = temp;
}

int main() {
    int a = 12;
    int b = 8;
    printf("Antes: A=%d, B=%d\n", a, b);
    printf("Endereco de A: %p\n", &a);
    printf("Endereco de B: %p\n", &b);
    trocaMaior(&a, &b);
    printf("Apos a troca: A=%d, B=%d\n", a, b);        
    return 0;
}
