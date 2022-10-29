main
    ldw r1,vetsz
    ldi r2,vet

loop
    ldc r3,0
    ldw r3,r2
    add r3,42
    ldw r2,r3
    add r2,2
    sub r1,1
    bnz r1,loop

pre_print
    ldi r3,32
    ldi r5,vet
    ldw r6,vetsz

print
    ldw r4,r5
    stw r4,0xf002
    stw r3,0xf000
    add r5,2
    sub r6,1
    bez r6,end
    bnz r7,print

end
    hcf

vetsz 10
vet	0 1 2 3 4 5 6 7 8 9

; --- ENUNCIADO ---
;
; Implememente um programa que soma o valor de uma constante a cada elemento de um vetor numérico