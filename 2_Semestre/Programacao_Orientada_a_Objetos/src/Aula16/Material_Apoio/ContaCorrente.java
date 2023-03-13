package Aula16.Material_Apoio;

public class ContaCorrente {
    private double saldo;
    private final String ERROR_MESSAGE = "Apenas valores positivos são aceitos.";
    private int contadorInstancias;
    private int contadorTentativas;
    
    public ContaCorrente(double saldoInicial) throws Exception {
        try {
            if (saldoInicial >= 0) {
                saldo = saldoInicial;
                contadorInstancias++;
            } else
                throw new Exception(ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println("A conta não pode ser inicializada com um valor negativo.\n" + e.getMessage());
        } finally {
            contadorTentativas++;
        }
    }
    
    public void deposito(double valor) throws Exception {
        if (valor > 0)
            saldo += valor;
        else
            throw new Exception(ERROR_MESSAGE);
    }
    
    public void saque(double valor) throws Error {
        if (0 < valor && valor <= saldo)
            saldo -= valor;
        // else
        //     throw new Exception(ERROR_MESSAGE);
        else
            throw new Error(ERROR_MESSAGE);
    }
    
    public double getSaldo() throws Exception {
        return saldo;
	}

    public int getContadorInstancias() {
        return contadorInstancias;
    }

    public int getContadorTentativas() {
        return contadorTentativas;
    }

    @Override
    public String toString() {
        return "ContaCorrente [saldo=" + saldo + "]";
    }
}