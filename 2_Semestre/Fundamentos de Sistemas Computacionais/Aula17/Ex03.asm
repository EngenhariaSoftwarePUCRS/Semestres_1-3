main
    ldi r1,mensagem

print
    ldb r2,r1
    stw r2,0xf000
    add r1,1
    bnz r2,print
    hcf

mensagem "Lorem ipsum dolor"

; --- ENUNCIADO ---
;
; Escreva um programa que apresenta a mensagem ”Lorem ipsum dolor” no terminal. Para isso, armazene a mensagem em uma string, e realize a impressão de cada byte no terminal.
