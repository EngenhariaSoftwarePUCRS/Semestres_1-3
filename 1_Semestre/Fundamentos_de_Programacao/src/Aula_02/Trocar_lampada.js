/*
    Algoritmo trocar lâmpada
    1.	Pegar uma escada
    2.	Subir na escada
    3.	Tirar lâmpada velha
    4.	Por lâmpada nova
    5.	Descer da escada
*/

var ladder = true
var ladder_up = true
var old_lamp_inserted = false
var new_lamp_inserted = true
var ladder_down = true

if (ladder && ladder_up && !(old_lamp_inserted) && new_lamp_inserted && ladder_down) {
    console.log("Lampada trocada com sucesso")
} else {
    console.log("Erro, não foi possível trocar a lâmpada")
}