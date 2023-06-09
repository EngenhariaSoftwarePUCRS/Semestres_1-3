var array [0]
removefirst array arr
input x "Enter a number: "
while x
    append array x
    input x "Enter a number: "
endwhile
foreach item array
    mod item 2 parity
    if parity
        say "$(item) is odd"
    else
        say "$(item) is even"
    endif
endforeach
