main
    ldi r1,helloWorld
    
print
    ldb r2,r1
    stw r2,0xf000
    add r1,1
    bnz r2,print

    hcf

helloWorld "Hello, World!"