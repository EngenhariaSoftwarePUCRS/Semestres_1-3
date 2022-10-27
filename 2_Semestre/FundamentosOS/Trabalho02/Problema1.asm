; import java.util.Scanner;
;
; /*
; * Escreva um programa que conta o numero de palavras ar-
; mazenadas em uma string e apresenta o total no terminal. Como sugestao,
; utilize a funcao abaixo como referencia para sua implementacao, a ser cha-
; mada a partir do programa principal. Utilize duas strings na demonstracao
; do funcionamento.
; */
; public class Problema1 {
;    public static void main(String[] args) {
;        System.out.print("Sentence: ");
;        String strStr = new Scanner(System.in).nextLine();
;        char[] str = new char[strStr.length()];
;        for (int i = 0; i < strStr.length(); i++)
;            str[i] = strStr.charAt(i);
;        System.out.println("Contains: " + count_words(str, str.length) + " words.");
;    }
;
;    static int count_words(char[] str, int size) {
;        int i = 0, words = 0;
;        while (1 == 1) {
;            while ((str[i] < 33) || (str[i] > 126)) {
;                i++;
;                if (i >= size)
;                    return words;
;            }
;            while ((str[i] > 32) && (str[i] < 127)) {
;                i++;
;                if (i >= size)
;                    return words + 1;
;            }
;            words++;
;        }
;    }
; }

v4L {
    main
        ; r3 = espaco
        ldi r3,espaco
        ; r3 = " "
        ldb r3,r3
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
        ; print(totalPalavras)
        stw r2,0xf002
        ; end()
        hcf
        
    frase "teste isso e um teste com 8 palavras"
    espaco " "
    str  "\nTotal de palavras: "
}

v3 {
    main
    ;   r1 = words (0)
        ldi r1,words
    ;   r2 = size (20)
        ldi r2,size
    ;   r3 = str ("ab")
        ldi r3,str
        sub sp,2
        stw r3,sp
        sub sp,2
        stw r2,sp
        bnz r7,while_externo

    while_externo
        ldb r4,r3
        bnz r7,while_str_for_espaco
        add r1,1
        bez r4,fim

    while_str_for_espaco
        ldi r6,33
        slt r5,r4,r6
        bnz r5,while_str_for_espaco_interno
        ldi r6,127
        slt r5,r4,r6
        bnz r5,while_str_for_espaco_interno
        bnz r7,while_externo

    while_str_for_espaco_interno
        add r3,1
        ldb r4,r3
        bnz r4,while_str_for_espaco

    fim
        stw r1,0xf000
        hcf

    words 0
    size 20
    str "ab"
}

v2 {
    main
    ;   r1 = words (0)
        ldi r1,words
    ;   r2 = size (20)
        ldi r2,size
    ;   r3 = str ("ab")
        ldi r3,str
    ;   pointer_pilha -= 2
        sub sp,2
    ;   pilha[pointer_pilha] = r3
        stw r3,sp
    ;   pointer_pilha -= 2
        sub sp,2
    ;   pilha[pointer_pilha] = r2
        stw r2,sp
    ;   goTo(while_externo)
        bnz r7,while_externo

    while_externo
    ;   r4 = r3.charAt(0) ("a")
        ldb r4,r3
    ;   vai checar se é espaço/símbolo
        bnz r7,while_str_for_espaco
    ;   vai checar se é letra
        bnz r7,while_str_for_letra
    ;   words++
        add r1,1
    ;   se não tiverem mais letras, goTo(fim)
        bez r4,fim

    while_str_for_espaco
    ;   r5 = r4 < 33 ? 1 : 0
        slt r5,r4,33
    ;   se r4 < 33, goTo(laco_interno)
        bnz r5,while_str_for_espaco_interno
    ;   r5 = r4 < 126 ? 1 : 0
        slt r5,r4,127
    ;   se r4 >= 127, goTo(laco_interno)
        bnz r5,while_str_for_espaco_interno
    ;   if (r4 >= 33 || r4 <= 126), goTo(while_externo)
        bnz r7,while_externo

    while_str_for_espaco_interno
    ;   vai para o próximo caracter
        add r3,1
    ;   r4 = r4.charAt(1) ("b")
        ldb r4,r3
    ;   se ainda existir um caracter, goTo(laco_externo)
        bnz r4,while_str_for_espaco

    fim
        stw r1,0xf000
        hcf

    words 0
    size 20
    str "ab"
}

v1 {
    main
    ;   r1 = words
        ldi r1,words
    ;	r2 = pos
        ldi r2,pos
    ;   while(1)
        bnz r7,while_externo

    while_externo
        ldi r3,mensagem1
        ldb r4,r3
        ldi r6,33
        slt r5,r4,r6
        bnz r5,while_str_for_espaco
        ldi r6,126
        slt r5,r4,r6
        bnz r5,while_str_for_espaco
        bnz r7,while_str_for_letra

    while_str_for_espaco
        add r2,1
        stw r3,size
        slt r5,r3,r2
        bez r5,while_externo

    while_str_for_letra
        add r2,1
        stw r3,size
        slt r5,r3,r2
        add r1,1
        bez r5,while_externo

    print
        stw r1,0xf000

    words 0
    pos 0
    size 20
    mensagem1 "Lorem ipsum dolor\n"
    mensagem2 "labore et dolore magna aliqua"
}