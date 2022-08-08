package Aula01.Ex03;

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
        this.clientes = new Cliente[10];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente();
        }
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void addCliente(Cliente cliente) {
        for (int i = 0; i < clientes.length; i++)
            if (clientes[i].getNome() == null) {
                clientes[i] = cliente;
                break;
            }
    }

    public boolean isNoRestaurante(CPF cpf) {
        for (int i = 0; i < clientes.length; i++)
            if (clientes[i].getCpf() == cpf)
                return true;
        return false;
    }
    
    public void sair(CPF cpf) {
        for (int i = 0; i < clientes.length; i++)
            if (clientes[i].getCpf() == cpf)
                clientes[i] = null;
    }
    
    private void contaClientes() {
        for (Cliente cliente : clientes) {
            if (cliente != null)
                if (cliente.getNome() != null) {
                    if (cliente.getGenero() == 'M') {qtdClientesMasc++;}
                    else if (cliente.getGenero() == 'F') {qtdClientesFem++;}
                }
        }
        qtdClientesTotal = qtdClientesMasc + qtdClientesFem;
    }

    private double getPercentMasc() {
        return (qtdClientesMasc / (double) qtdClientesTotal) * 100;
    }
    
    private double getPercentFem() {
        return (qtdClientesFem / (double) qtdClientesTotal) * 100;
    }

    public int getQtdClientesTotal() {
        return this.qtdClientesTotal;
    }

    public void getDistribuicaoClientes() {
        contaClientes();
        System.out.printf("| Há %d pessoas no bar.\t|", qtdClientesTotal);
        System.out.printf("%n| -- Distribuição -- \t|");
        System.out.printf("%n| Masculino:\t%.2f%% |", getPercentMasc());
        System.out.printf("%n| Feminino:\t%.2f%% |", getPercentFem());
    }
}
