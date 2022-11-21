package Aula11.Questao1;

public class Premier extends Executive {
    public Premier(String cpf, String nome, String assento, double custo) {
        super(cpf, nome, assento, custo);
    }

    public double getCustoBagagem(int qtdade, double[] pesos) {
        return 0;
    }

    public double getCustoAssento() {
        return 0;
    }
}
