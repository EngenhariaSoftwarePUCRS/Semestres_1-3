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
        this.golsPro = 0;
        this.golsContra = 0;
        this.saldoGols = golsPro - golsContra;
        this.quantidadePontos = 0;
        this.quantidadeVitorias = 0;
        this.quantidadeEmpates = 0;
        this.quantidadeDerrotas = 0;
        this.quantidadePartidasJogadas = 0;
        this.aproveitamento = 0;
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
        
        this.aproveitamento = (quantidadePontos / (double)(3*quantidadePartidasJogadas)) * 100;

        return this;
    }

    public String toString() {
        return ("  |Pontos = " + quantidadePontos +
                "  |Partidas jogadas = " + quantidadePartidasJogadas +
                "  |Vitorias = " + quantidadeVitorias +
                "  |Empates = " + quantidadeEmpates +
                "  |Derrotas = " + quantidadeDerrotas +
                "  |Gols feitos = " + golsPro +
                "  |Gols sofridos = " + golsContra +
                "  |Saldo de gols = " + saldoGols +
                "  |Aproveitamento = " + aproveitamento + "%"
                );
       }

}
