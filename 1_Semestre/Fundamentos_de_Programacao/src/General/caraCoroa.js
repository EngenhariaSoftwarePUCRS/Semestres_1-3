
var cara = 0;
var coroa = 0;
var pe = 0;

function caraOuCoroa() {
    var bruto = Math.random();
    var moeda = parseFloat(bruto.toFixed(10))
    if (moeda < 0.5) {
        cara ++;
    } else if (moeda > 0.5) {
        coroa++;
    } else {
        pe++;
    }
}

var jogos = 10000000;
var inicio = new Date();
for (n = 0; n < jogos; n += 1) {
    caraOuCoroa()
}

var timeElapsed = (new Date() - inicio)/1000

console.log("Tempo inicial: "+inicio)
console.log("A moeda caiu "+cara+" vezes cara e "+coroa+" vezes coroa.")
if (timeElapsed > 60) {
    console.log("Tempo decorrido: "+(timeElapsed/60).toFixed(4)+" minutos.")
} else {
    console.log("Tempo decorrido: "+timeElapsed+" segundos.")
}
if (pe != 0) {
    console.log("A moeda caiu em pé "+pe+" vez(es) em "+jogos+" jogo(s).")
}
