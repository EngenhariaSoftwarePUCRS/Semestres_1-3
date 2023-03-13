package RevisaoP2.Questao4;

public class Cachorro {
    private String nome;
    private int idade;
    private String raca;
    private String cor;
    private double peso;

    public Cachorro(String nome, int idade, String raca, String cor, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.cor = cor;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getRaca() {
        return raca;
    }

    public String getCor() {
        return cor;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Cachorro [nome=" + nome + ", idade=" + idade + ", raca=" + raca + ", cor=" + cor + ", peso="
                + peso + "]";
    }
}
