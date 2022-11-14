package Aula11.Questao1;

public class Economy extends Passagem {
    public Economy(String cpf, String nome, String assento, double custo) {
        super(cpf, nome, assento, custo);
    }

    @Override
    public double getCustoBagagem(int qtdade, double[] pesos) {
        double c = 0;
        
        for (int i = 0; i < qtdade; i++) {
            c += 0.5 * pesos[i];
            c += 10;
        }

        return c;
    }
}
