main
    ; r3 = " "
    ldi r3,32

rep
    ; r4 -> frase[0]
    ldi r4,frase

    ; r4 -> frase[1]
    add r4,r4,1

    ; r4 = frase[1]
    ldb r4,r4

    ; print(r4)
    stw r4,0xf000

    ; r1++
    add r1,1

    ; (r5 = r4)
    xor r5,r3,r4

    ; se r4 não for caracter, goTo(cont)
    bez r5,cont

    ; se r4 for um caracter, goTo(rep)
    bnz r4,rep

    ; totalPalavras++;
    add r2,1

    ; goTo(fim)
    bnz r7,fim

cont
    ; totalPalavras++;
    add r2,1

    ; goTo(rep)
    bnz r7,rep

fim
    ; r1 = 0
    ldi r1,0

fim_rep
    ; r4 -> str[0]
    ldi r4,str

    ; r4 -> str[1]
    add r4,r4,1

    ; r4 = str[1]
    ldb r4,r4

    ; print(r4)
    stw r4,0xf000

    ; r1++
    add r1,1

    ; enquanto tiver palavras, volta
    bnz r4,fim_rep

print
    stw r2,0xf002
    hcf
    
frase "teste isso e um teste com 8 palavras"
str  "\nTotal de palavras: "

; --- ENUNCIADO ---
;
; Escreva um programa que conta o numero de palavras ar-
; mazenadas em uma string e apresenta o total no terminal. Como sugestao,
; utilize a funcao abaixo como referencia para sua implementacao, a ser cha-
; mada a partir do programa principal. Utilize duas strings na demonstracao
; do funcionamento.