main
    ldw r1,i
    ldw r2,maior
    ldi r3,v

while
    slt r5,r1,r2
    bnz r5,if
    bnz r7,print

if
    ldw r4,r5
    add r5,1
    bnz r7,loop

print
    stw r2,0xf002
    hcf

i 0
maior -32768
v 0 1 2 3 4 5 6 7 8 9

; --- ENUNCIADO ---
;
; Faça um programa que percorre um vetor e armazena o maior elemento encontrado em uma variável. Dica: declare um vetor com diversos valores inteiros e percorra ele, elemento por elemento, com o uso de um ponteiro. A cada iteração, incremente o ponteiro em 2 posições de memória (inteiros ocupam 2 bytes na arquitetura Viking).
; i = 0; maior = -32768; v[10];
; while (i < max) {
; if (v[i] > maior)
;     maior = v[i];
;     i++;
; }