public class Conta {
    
    private double saldo;

    private int numeroConta;

    public Conta(double s, int numero){

        if (s>0) saldo = s;

        else saldo =0;

        if (numero>0) numeroConta = numero;

        else numeroConta =0;

     }

    public void sacar(double valor){

        if (valor<=saldo)

            saldo = saldo - valor;

    }

    public void depositar(double valor){

        saldo = saldo + valor;

    }

    public double getSaldo(){

        return saldo;

    }

    public int getNumeroConta (){

        return numeroConta;

    }

    public void transferir(Conta contaDestino, double valor){

        sacar(valor);

        contaDestino.depositar(valor);

    }

    public String toString(){

        return "Conta número: "+numeroConta + "Saldo atual: "+ saldo;

    }
}
