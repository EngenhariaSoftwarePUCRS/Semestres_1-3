package TrabalhoFinal_FecheACaixa;

public class Tabuleiro {
    private Dado[] dados;
    private Casa[] casas;

    public Tabuleiro() {
        dados = new Dado[2];
        casas = new Casa[9];
        dados[0] = new Dado();
        dados[1] = new Dado();
        for (int i = 0; i < casas.length; i++)
            casas[i] = new Casa(i + 1, true);
    }

    public Tabuleiro(int qtdDados, int qtdCasas, int qtdLadosDados) {
        dados = new Dado[qtdDados];
        casas = new Casa[qtdCasas];
        for (int i = 0; i < qtdDados; i++)
            dados[i] = new Dado(qtdLadosDados);
        for (int i = 0; i < qtdCasas; i++)
            casas[i] = new Casa(i + 1, true);
    }

    public Casa[] getCasas() {
        return casas;
    }

    public int jogarDados() {
        if (!casas[casas.length - 3].isAberto() &&
                !casas[casas.length - 2].isAberto() &&
                !casas[casas.length - 1].isAberto())
            return dados[0].sortearLado();
        return dados[0].sortearLado() + dados[1].sortearLado();
    }

    public void fecharCasas(int[] numeros) {
        for (int i : numeros)
            casas[i].fechar();
    }

    public int qtdCasasFechadas() {
        int qtdCasasFechadas = 0;
        for (Casa casa : casas)
            if (!casa.isAberto())
                qtdCasasFechadas++;
        return qtdCasasFechadas;
    }

    public void mostrar() {
        for (Casa casa : casas)
            System.out.println(casa);
    }
}
