package Aula11.Questao1;

public class Passagem {

    private String cpf;
    private String nome;
    private String assento;
    private double custoPassagem;

    public Passagem(String cpf, String nome, String assento, double custo) {
        this.cpf = cpf;
        this.nome = nome;
        this.assento = assento;
        custoPassagem = custo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getAssento() {
        return assento;
    }

    public double getCustoPassagem() {
        return custoPassagem;
    }

    public double getCustoAssento() {
        return 5.0;
    }

    public double getCustoBagagem(int qtdade, double pesos[]) {
        double c = 0;
        for (int i = 0; i < qtdade; i++) {
            c += 0.5 * pesos[i];
        }
        return c;
    }

    public double defineAssento(String poltrona) {
        assento = poltrona;
        return getCustoAssento();
    }

    public String toString() {
        return ">" + getCpf() + "," +
                getNome() + "," +
                getAssento() + "," +
                getCustoPassagem();
    }
}
