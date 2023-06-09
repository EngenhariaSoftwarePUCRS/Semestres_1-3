input in "Diz aí meu chapa, qual é o seu nome: "
split in "" array
var isPalindrome 1
length array size
greaterequal size 2 valid
while valid
    removefirst array first
    removelast array last
    notequal first last different
    if different
        var isPalindrome 0
        break
    endif
    length array size
    greaterequal size 2 valid
endwhile
say "Seu nome é um palíndromo? $(isPalindrome)"