package Semana_15;

public class Contador {
    private int valor;

    public void incrementar() {
        valor += 1;
    }

    public void decrementar() {
        if (valor > 0) {
            valor -= 1;
        }
    }

    public int getValor() {
        return valor;
    }

    public void zerar() {
        valor = 0;
    }
}
