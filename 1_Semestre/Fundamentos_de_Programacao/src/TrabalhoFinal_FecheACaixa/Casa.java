package TrabalhoFinal_FecheACaixa;

public class Casa {
    private int numero;
    private boolean aberto;

    public Casa(int numero, boolean aberto) {
        this.numero = numero;
        this.aberto = aberto;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void fechar() {
        this.aberto = false;
    }

    private String abertoToString() {
        if (isAberto())
            return "aberta";
        return "fechada";
    }

    public String toString() {
        return ("Casa nº: " + numero +
                "\t" + abertoToString());
    }
}
