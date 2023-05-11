#include <stdio.h>

int semParenteses() {
    int vet[] = { 4, 9, 12 };
    int i, *ptr;
    ptr = vet;
    for(i = 0; i < 3; i++)
        printf("%d ", *ptr++);
    return 1;
}

int comParenteses() {
    int vet[] = { 4, 9, 12 };
    int i, *ptr;
    ptr = vet;
    for(i = 0; i < 3; i++) {

        printf("%d ", (*ptr)++);
    }
    return 1;
}

int main() {
    semParenteses();
    printf("\n");
    comParenteses();
    printf("\n");
    return 1;
}
