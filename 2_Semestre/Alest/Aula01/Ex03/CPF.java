package Ex03;

public class CPF {
    private int valor;
    private String cpf;

    public CPF(String valor) {
        this.valor = Integer.parseInt(valor);
        this.cpf = valor;
    }

    public String toString() {
        // No momento, supõe-se que o padrão é o do Rio Grande do Sul
        return (""
            + cpf.substring(0, 3)
            + "."
            + cpf.substring(3, 6)
            + "."
            + cpf.substring(6, 9)
            + "-"
            + cpf.substring(9)
        );
    }
}
