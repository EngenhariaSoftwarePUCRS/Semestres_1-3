package Aula05.Exemplo;

public class Carta {
    Naipe naipe;
    ValorCarta valor;

    public Carta(Naipe naipe, ValorCarta valor){
        this.naipe = naipe;
        this.valor = valor;
    }

    Naipe getNaipe(){
        return naipe;
    }

    ValorCarta getValor(){
        return valor;
    }

    @Override
    public String toString() {
        return "Carta [naipe=" + naipe + ", valor=" + valor + "]";
    }
}