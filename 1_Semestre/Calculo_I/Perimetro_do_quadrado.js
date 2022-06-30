/*
    Ver quantas possibilidades existem para formar um retângulo
    Depois utilizado para resolver problemas de otimização
*/
var quantidade = 0;
var a = 1
var b = 1
var area = 5000
for (let x = 0; x <= area; x += a) {
    for (let y = 0; y <= 450; y += b) {
        if (x * y == area) {
            var perimetro = 2 * x + 2 * y
            console.log("Base: " + x + " Altura: " + y)
            console.log("Perímetro: " + perimetro)
            console.log("-----------------------")
            quantidade++;
        }
    }
}
console.log("Existem " + quantidade + " soluções possíveis para o problema.")