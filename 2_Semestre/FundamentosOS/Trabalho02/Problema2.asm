; /*
;  * Considere uma sequencia de n numeros inteiros. Para esta
; sequencia, determine um segmento de soma maxima e o valor dessa soma.
; Por exemplo, para a sequencia de valores 5, 2, -2, -7, 3, 14, 10, -3, 9, -6, 4,
; 1, o segmento esta entre o ́ındices 4 e 8 e a soma dos valores desse segmento
; e 33. Utilize dois vetores de numeros na demonstracao do funcionamento da
; sua solucao.
;  */
; public class Problema2 {
;     public static void main(String[] args) {
;         int[] sequence = {5, 2, -2, -7, 3, 14, 10, -3, 9, -6, 4, 1};
;         int[] segmento = {4, 8};
;         System.out.println("Soma: " + soma(sequence, segmento));
;     }
; 
;     static int soma(int[] sequence, int[] segment) {
;         int soma = 0;
; 
;         int i = segment[0];
;         while (i <= segment[1]) {
;             soma += sequence[i];
;             i++;
;         }
; 
;         return soma;
;     }
; }

v1 {
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

    ; r6 = 8
    ldc r6,8

verificacao_soma
    ; r3 = 0
    ldi r3,0

    ; r3 = r4 < r5 ? 1 : 0
    slt r3,r4,r5
    bnz r3,laco_soma
    bnz r7,print

laco_soma
    ; r3 = 0
    ldi r3,0

    ; r3 = sequencia[0]
    ldw r3,r2

    ; r1 += r3
    add r1,r3,r1

    ldi r3,0
    sub r6,1
    slt r3,1,r6
    bez r3,print
    bnz r7,repetir

repetir
    ; sequencia[0+1]
    add r2,2

    ; r3 = 0
    ldi r3,0

    ; r3 = sequencia[0]
    ldw r3,r2

    ; r1 += r3
    add r1,r3,r1
    bnz r7,laco_soma

print
    stw r1,0xf002
    hcf

sequencia 5 2 -1 -7 3 14 10 -3 9 -6 4 1
segmento 0 4
}