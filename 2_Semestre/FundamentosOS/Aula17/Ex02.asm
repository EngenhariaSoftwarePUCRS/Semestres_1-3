main
    ldw r1,vetsz
    ldi r2,vet

loop
    ldw r3,r2
    add r3,42
    add r2,2
    slt r4,r5,r1
    sub r1,1
    bnz r1,loop

end
    hcf

vetsz 10
vet	0 1 2 3 4 5 6 7 8 9

; --- ENUNCIADO ---
;
; Implememente um programa que soma o valor de uma constante a cada elemento de um vetor numérico