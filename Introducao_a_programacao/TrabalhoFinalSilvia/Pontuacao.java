public class Pontuacao {

    private int gP;
    private int gC;
    private int sG;
    private int quantidadePontos;
    private int quantidadeVitorias;
    private int quantidadeEmpates;
    private int quantidadeDerrotas;

    public Pontuacao() {
        this.gP = 0;
        this.gC = 0;
        this.sG = gP - gC;
        this.quantidadePontos = 0;
        this.quantidadeVitorias = 0;
        this.quantidadeEmpates = 0;
        this.quantidadeDerrotas = 0;
    }

    public Pontuacao(int gP, int gC, int quantidadePontos, int quantidadeVitorias, int quantidadeEmpates,
            int quantidadeDerrotas) {
        this.gP = gP;
        this.gC = gC;
        this.sG = gP - gC;
        this.quantidadePontos = quantidadePontos;
        this.quantidadeVitorias = quantidadeVitorias;
        this.quantidadeEmpates = quantidadeEmpates;
        this.quantidadeDerrotas = quantidadeDerrotas;
    }

    public void setGP(int gP) {
        this.gP = gP;
    }

    public void setGC(int gC) {
        this.gC = gC;
    }

    public void setSG(int sG) {
        this.sG = sG;
    }

    public void setQuantidadePontos(int quantidadePontos) {
        this.quantidadePontos = quantidadePontos;
    }

    public void setQuantidadeVitorias(int quantidadeVitorias) {
        this.quantidadeVitorias = quantidadeVitorias;
    }

    public void setQuantidadeEmpates(int quantidadeEmpates) {
        this.quantidadeEmpates = quantidadeEmpates;
    }

    public void setQuantidadeDerrotas(int quantidadeDerrotas) {
        this.quantidadeDerrotas = quantidadeDerrotas;
    }

    public int getGP() {
        return gP;
    }

    public int getGC() {
        return gC;
    }

    public int getSG() {
        return sG;
    }

    public int getQuantidadePontos() {
        return quantidadePontos;
    }

    public int getQuantidadeVitorias() {
        return quantidadeVitorias;
    }

    public int getQuantidadeEmpates() {
        return quantidadeEmpates;
    }

    public int getQuantidadeDerrotas() {
        return quantidadeDerrotas;
    }

    public Pontuacao atualizacaoPartida(int gP, int gC) {
        this.gP += gP;
        this.gC += gC;
        this.sG += (gP - gC);

        if (gP > gC) {
            quantidadeVitorias++;
            quantidadePontos += 3;
        } else if (gP < gC) {
            quantidadeDerrotas++;
        } else {
            quantidadeEmpates++;
            quantidadePontos += 1;
        }

        return this;
    }

    public String toString() {
        return ("\tQuantidade de pontos = " + quantidadePontos +
                "\tQuantidade de vitorias = " + quantidadeVitorias +
                "\tQuantidade de empates = " + quantidadeEmpates +
                "\tQuantdade de derrotas = " + quantidadeDerrotas +
                "\tGols feitos = " + gP +
                "\tGols sofridos = " + gC +
                "\tSaldo de gols = " + sG);
       }

}
