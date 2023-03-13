package Aula11.Questao2;

public class ContaBancaria {
    private String id;
    private double saldo;

    public ContaBancaria(String id) {
        this.id = id;
        saldo = 0.0;
    }

    public String getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean deposito(double valor) {
        if (valor <= 0.0)
            return false;
        else {
            saldo += valor;
            return true;
        }
    }

    public boolean retirada(double valor) {
        if (valor <= 0.0)
            return false;
        else {
            if (saldo - valor < 0.0)
                return false;
            else {
                saldo -= valor;
                return true;
            }
        }
    }
}
