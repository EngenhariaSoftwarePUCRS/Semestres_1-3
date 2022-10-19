package Aula05.Exemplo;

public class App {
    public static void main(String args[]){
        Naipe naipe = Naipe.ESPADAS;
        ValorCarta valor = ValorCarta.DAMA;
        Carta carta = new Carta(naipe,valor);
        
        System.out.println(naipe.name()+", ord:"+naipe.ordinal());
        System.out.println(valor.name()+", ord:"+valor.ordinal());
        System.out.println(carta.toString());
    }
}