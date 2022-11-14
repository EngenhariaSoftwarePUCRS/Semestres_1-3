main
    ldw r1,dividendo
    ldw r2,divisor
    ldw r3,quociente
    ; r4 = resto
    xor r4,r5,r1

divisao
    slt r5,r4,r2
    bnz r5,atr_msg
    sub r4,r4,r2
    add r3,1
    bnz r7,divisao

atr_msg
    ; r6 -> mensagem[0]
    ldi r6,mensagem

print_msg
    ; r5 = mensagem[i]
    ldb r5,r6

    ; print(r4)
    stw r5,0xf000

    ; r6 -> mensagem[i+1] (goToNextChar)
    add r6,1

    ; repeat while there are words
    bnz r5,print_msg

print_number
	stw r3,0xf002

atr_msg2
    ; r6 -> mensagem2[0]
    ldi r6,mensagem2

print_msg2
    ; r5 = mensagem2[i]
    ldb r5,r6

    ; print(r4)
    stw r5,0xf000

    ; r6 -> mensagem2[i+1] (goToNextChar)
    add r6,1

    ; repeat while there are words
    bnz r5,print_msg2

print_number
	stw r4,0xf002
	hcf

dividendo 18
divisor 3
quociente 0
mensagem "Divisor: "
mensagem2 "\nResto: "

; --- ENUNCIADO ---
;
; Escreva um programa que realiza a divisão de dois números utilizando subtrações sucessivas.
; dividendo = 88, divisor = 5, quociente = 0, resto;
;
; resto = dividendo;
; while (resto >= divisor) {
;     resto -= divisor;
;     quociente++;
; }