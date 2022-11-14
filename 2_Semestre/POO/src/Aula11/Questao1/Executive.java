package Aula11.Questao1;

public class Executive extends Passagem {
    private int milhas;

    public Executive(String cpf, String nome, String assento, double custo) {
        super(cpf, nome, assento, custo);
    }

    public int getMilhas() {
        return this.milhas;
    }

    public void calcMilhas(double percentual) {
        
    }

    @Override
    public double getCustoBagagem(int qtdade, double[] pesos) {
        double c = 0;

        if (qtdade > 2)
            for (int i = 0; i < qtdade; i++) {
                c += 0.5 * pesos[i];
            }

        return c;
    }

    public String toString() {
        return (
            "milhas: " + milhas
        );
    }
}
