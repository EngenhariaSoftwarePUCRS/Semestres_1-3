var quantidade = 0;
var a = 0.5
var b = 0.5
for (let x = 0; x<=450; x+=a) {
    for (let y = 0; y <= 450; y+=b) {
        if (x*y == 450) {
            var perimetro = 2*x + 2*y
            console.log("Base: "+x+" Altura: "+y)
            console.log("Perímetro: "+perimetro)
            console.log("-----------------------")
            quantidade++;
        }
    }
}
console.log("Existem "+quantidade+" soluções possíveis para o problema.")