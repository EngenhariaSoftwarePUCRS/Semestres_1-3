main
    ; r2 = totalPalavras(começa em 0)
    ldr r2,0

    ; r5 -> &frase
    ldi r5,frase

    ; salva r5 na pilha
    sub sp,2
    stw r5,sp

    ; r6 -> &count
    ldi r6,count

rep
    ; pega r5 da pilha
    ldw r5,sp
    add sp,2

    ; r4 = r5[i] (primeiro byte da frase)
    ldb r4,r5

    ; se não tiverem mais caracteres por ler, goTo(final)
    bez r4,print_final
    
    ; printa o byte em r4
    stw r4,0xf000

    ; r5 -> &mensagem + 1 (próximo byte)
    add r5,1

    ; salva r5 na pilha
    sub sp,2
    stw r5,sp

    ; r3 = 33 (primeiro caracter depois do " " na tabela ASCII)
    ldr r3,33
    
    ; r3 = r4 < r3 ? 1 : 0
    slt r3,r4,r3

    ; se r4 for um espaço, goTo(count)
    bnz r3,r6

    ; r3 = 126 (último caracter considerado como letra no exercício)
    ldr r3,126

    ; r3 = r4 < r3 ? 1 : 0
    slt r3,r4,r3

    ; se r4 não for uma letra, goTo(count)
    bez r3,r6
    
    ; repete o laço
    bnz r7,rep

count
    ; totalPalavras++
    add r2,1

    ; volta para o laço de repetição
    bnz r7,rep

print_final
    ; r4 -> &mensagem
    ldi r4,mensagem

print_rep
    ; r5 = r4[0] (primeiro byte da mensagem)
    ldb r5,r4

    ; print(r5)
    stw r5,0xf000

    ; r4 -> &mensagem + 1 (próximo byte)
    add r4,1

    ; if (r5
    bez r5,final
    bnz r5,print_rep

final
    ; totalPalavras++
    add r2,1

    ; print(totalPalavras)
    stw r2,0xf002
    
    hcf

frase "Teste com 4 palavras"
mensagem "\nTotal de palavras:\t"

; --- ENUNCIADO ---
;
; Escreva um programa que conta o numero de palavras ar-
; mazenadas em uma string e apresenta o total no terminal. Como sugestao,
; utilize a funcao abaixo como referencia para sua implementacao, a ser cha-
; mada a partir do programa principal. Utilize duas strings na demonstracao
; do funcionamento.