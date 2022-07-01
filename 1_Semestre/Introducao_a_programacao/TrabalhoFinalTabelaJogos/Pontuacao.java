public class Pontuacao {

    private int golsPro;
    private int golsContra;
    private int saldoGols;
    private int quantidadePontos;
    private int quantidadeVitorias;
    private int quantidadeEmpates;
    private int quantidadeDerrotas;
    private int quantidadePartidasJogadas;
    private double aproveitamento;

    public Pontuacao() {
        // Since all values are 0 by default, the constructor is blank
    }

    public int getQuantidadePontos() {
        return this.quantidadePontos;
    }

    public int getQuantidadeVitorias() {
        return this.quantidadeVitorias;
    }

    public Pontuacao atualizacaoPartida(int golsPro, int golsContra) {
        this.quantidadePartidasJogadas++;
        this.golsPro += golsPro;
        this.golsContra += golsContra;
        this.saldoGols += (golsPro - golsContra);

        if (golsPro > golsContra) {
            this.quantidadeVitorias++;
            this.quantidadePontos += 3;
        } else if (golsPro < golsContra) {
            this.quantidadeDerrotas++;
        } else {
            this.quantidadeEmpates++;
            this.quantidadePontos += 1;
        }

        this.aproveitamento = (quantidadePontos
                /
                (double) (3 * quantidadePartidasJogadas))
                * 100;

        return this;
    }

    public String toString() {
        return ("Pts: " + quantidadePontos +
                "PJ: " + quantidadePartidasJogadas +
                "VIT: " + quantidadeVitorias +
                "E: " + quantidadeEmpates +
                "DER: " + quantidadeDerrotas +
                "GP: " + golsPro +
                "GC: " + golsContra +
                "SG: " + saldoGols +
                "Aproveitamento: " + aproveitamento + "%");
    }

}
