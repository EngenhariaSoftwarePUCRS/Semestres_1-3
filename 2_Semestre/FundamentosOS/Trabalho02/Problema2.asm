main
	; r1 = soma(começa em 0)

	; r2 = sequencia
	ldi r2,sequencia

	; r3 = segmento
	ldi r3,segmento

	; r4 = segmento[0]
	ldw r4,r3

	; r5 = segmento[1]
	add r3,2
	ldw r5,r3

	; salva r1,r2
	sub sp,2
	stw r1,sp
	sub sp,2
	stw r2,sp

	; r1 = r2 = 0
	ldi r1,0
	ldi r2,0

	; r1 = r5 - r4
	sub r1,r5,r4

	; r6 = r1 (quantas vezes repito o laco)
	xor r6,r1,r2

	; recupera r1,r2
	ldw r2,sp
	add sp,2
	ldw r1,sp
	add sp,2

	; r2 -> sequence[i-1]
	sub r2,2

	; r5 = -1
	ldi r5,-1

move_pointer
	; r2 -> sequence[i+1]
	add r2,2

	; r3 = 0
	ldi r3,0

	; r4--;
	sub r4,1

	; if (r4 >= 0) {
	slt r3,r5,r4

	; repeat }
	bnz r3,move_pointer

	; r2 -> sequence[i-1]
	sub r2,2

laco_soma
	; r2 -> sequence[i+1]
	add r2,2

	; r3 = 0
	ldi r3,0

	; r3 = sequencia[i]
	ldw r3,r2

	; r1 += r3
	add r1,r3,r1

	; r6--
	sub r6,1

	; if (r6 >= 0) {
	slt r4,r5,r6

	; repeat }
	bnz r4,laco_soma

print
	stw r1,0xf002
	hcf

sequencia 5 2 -2 -7 3 14 10 -3 9 -6 4 1
segmento 4 8

; --- ENUNCIADO ---
;
;  Considere uma sequencia de n numeros inteiros. Para esta
; sequencia, determine um segmento de soma maxima e o valor dessa soma.
; Por exemplo, para a sequencia de valores 5, 2, -2, -7, 3, 14, 10, -3, 9, -6, 4,
; 1, o segmento esta entre o ́ındices 4 e 8 e a soma dos valores desse segmento
; e 33. Utilize dois vetores de numeros na demonstracao do funcionamento da
; sua solucao.