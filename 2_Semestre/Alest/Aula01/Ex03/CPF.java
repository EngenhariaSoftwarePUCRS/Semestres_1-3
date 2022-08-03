package Ex03;

public class CPF {
    private String cpf;

    public CPF(String valor) {
        this.cpf = valor;
    }

    public String toString() {
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
