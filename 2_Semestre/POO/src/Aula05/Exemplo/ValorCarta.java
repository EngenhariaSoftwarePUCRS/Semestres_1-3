package Aula05.Exemplo;

public enum ValorCarta {
    AS(1), DOIS(2), TRES(3), VALETE(11), DAMA(12), REI(13);
    
    private int valor;
 
    private ValorCarta(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    }

    public static ValorCarta getValor(int n){
        switch(n){
            case 1: return ValorCarta.AS;
            case 2: return ValorCarta.DOIS;
            case 3: return ValorCarta.TRES;
            case 11: return ValorCarta.VALETE;
            case 12: return ValorCarta.DAMA;
            case 13: return ValorCarta.REI;
            default: return null;
        }

        /*
        // Suportado pelo Java 14 em diante
        return switch(n){
            case 1 -> ValorCarta.AS;
            case 2 -> ValorCarta.DOIS;
            case 3 -> ValorCarta.TRES;
            case 11 -> ValorCarta.VALETE;
            case 12 -> ValorCarta.DAMA;
            case 13 -> ValorCarta.REI;
            default -> null;
        };
        */
    }

    public static boolean verifica(String s){
        for(ValorCarta v:ValorCarta.values()){
            if (v.toString().equals(s)){
                return true;
            }
        }
        return false;
    }
}