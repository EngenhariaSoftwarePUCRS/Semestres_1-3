input str "Enter a string: "
var index1 0
length str index2
decrement index2
div index2 2 limit
var isPalidrome 1
while limit
    charat str index1 char1
    charat str index2 char2
    notequal char1 char2 charsAreNotEqual
    if charsAreNotEqual
        decrement isPalidrome
    endif
    increment index1
    decrement index2
    decrement limit
endwhile
say "The string '$(str)' is a palindrome! $(isPalidrome)"