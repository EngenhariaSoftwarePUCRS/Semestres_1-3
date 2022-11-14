; vet[10] = {-1000, -550, ... };
;
; add_const(int i, int c) {
; 	v[i] += c;
; }
;
; main() {
; 	i = 0;
; 	while (i < vetsz) {
; 		add_const(i, 42);
; 		i++;
; 	}
; }

main
	ldi	r1,0
rep
	ldw	r2,vetsz		; r2 = vetsz
	slt	r3,r1,r2		; r3 = r1 < r2 ? 1 : 0
	bez	r3,end		; if (r3 == 0), goTo(end)
	
	sub	sp,2		; PUSH(r2)
	stw	r2,sp		;
	
	ldi	r2,42		; r2 = 42 (r1 = i)
	ldi	lr,ret_add_const	; lr = &ret_add_const
	bnz	r7,add_const		; add_const(i, 42)

	ldw	r2,sp		; POP (r2)
	add	sp,2		;
ret_add_const
	add	r1,1		; i++
	bnz	r7,rep
end
	hcf
	
add_const
	; r1 (i), r2 (42)
	ldi	r3,vet		; r3 = &vet
	add	r3,r3,r1		; r3 = &vet + i * 2			(&vet[i])
	add	r3,r3,r1		; 
	ldw	r4,r3		; r4 = vet[i]

	add	r4,r4,r2		; r4 = r4 + r2
	stw	r4,r3		; vet[i] = r4			(*r3 = r4)
	bnz	r7,lr		; return


vetsz	10
vet	-1000 -550 -10 150 295 970 1551 1667 2599 6987

