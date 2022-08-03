package Ex03;

public class Restaurante {
    // A qualquer
    // momento, ele deseja ser capaz de consultar quem
    // são as pessoas que estão no bar, se alguém com
    // um determinado CPF está no bar, quantas são as
    // pessoas e qual a distribuição por gênero
    // (percentual de clientes masculinos e femininos). Ao
    // sair, o cliente deve informar seu CPF, para registrar
    // sua saída.
    private Cliente[] clientes;
    private int qtdClientesMasc;
    private int qtdClientesFem;
    private int qtdClientesTotal;

    public Restaurante() {
        this.clientes = new Cliente[4];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente();
        }
    }
    
    private void contaClientes() {
        for (Cliente cliente : clientes) {
            if (cliente.getGenero() == 'M') {qtdClientesMasc++;}
            if (cliente.getGenero() == 'F') {qtdClientesFem++;}
        }
        qtdClientesTotal = qtdClientesMasc + qtdClientesFem;
    }

    private double getPercentMasc() {
        contaClientes();
        return (qtdClientesMasc / qtdClientesTotal) * 100;
    }
    
    private double getPercentFem() {
        contaClientes();
        return (qtdClientesFem / qtdClientesTotal) * 100;
    }

    public int getQtdClientesTotal() {
        return this.qtdClientesTotal;
    }

    public void getDistribuicaoPorGenero() {
        System.out.printf("Masculino: %.2f", getPercentMasc());
        System.out.printf("%nFeminino: %.2f", getPercentFem());
    }
}
