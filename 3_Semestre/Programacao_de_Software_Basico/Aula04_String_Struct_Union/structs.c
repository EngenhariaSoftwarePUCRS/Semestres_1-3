#include <stdio.h>

typedef struct {
    float p1;
    float p2;
    float trab;
    int faltas;
} Aluno;

void alunoToString(const Aluno *aluno);

int main() {
    Aluno a, b;
    a.p1 = 10;
    a.p2 = 7.5;
    a.trab = 9;
    a.faltas = 3;

    b.p1 = 9;
    b.p2 = 10;
    b.trab = 7.5;
    b.faltas = 4;

    alunoToString(&a);
    printf("%s\n", "=============");
    alunoToString(&b);

    return 0;
}

void alunoToString(const Aluno *aluno) {
    printf("p1: %f\np2: %f\ntrab: %f\nfaltas: %d\n", aluno->p1, (*aluno).p2, aluno->trab, aluno->faltas);
}
