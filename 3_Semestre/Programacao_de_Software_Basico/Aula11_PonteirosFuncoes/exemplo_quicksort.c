#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 1000000

int comparaIntAsc(const void *a, const void *b);
int comparaIntDesc(const void *a, const void *b);
int* fillArray(int *vet, int size);
void printArray(int *vet, int size);

int main() {
    int vet[SIZE];
    fillArray(vet, SIZE);

    printArray(vet, SIZE);

    qsort(vet, SIZE, sizeof(int), comparaIntAsc);
    printArray(vet, SIZE);

    qsort(vet, SIZE, sizeof(int), comparaIntDesc);
    printArray(vet, SIZE);
    
    return 0;
}

int comparaIntAsc(const void *a, const void *b) {
    int *pa = (int *) a;
    int *pb = (int *) b;
    return *pa - *pb;
}

int comparaIntDesc(const void *a, const void *b) {
    int *pa = (int *) a;
    int *pb = (int *) b;
    return *pb - *pa;
}

int* fillArray(int *vet, int size) {
    srand(time(0));
    
    for (int i = 0; i < size; i++)
        vet[i] = rand() % 100;
    return vet;
}

void printArray(int *vet, int size) {
    for (int i = 0; i < size; i++)
        printf("%d\n", vet[i]);
}
