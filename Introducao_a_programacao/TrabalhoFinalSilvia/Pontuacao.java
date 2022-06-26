public class Pontuacao {
    
    private int pontuacaoFinal;
    private int golsPro;
    private int golsContra;
    private int saldoGols;
    private int qtdGolsEmCasa;
    private int qtdGolsForaDeCasa;
    private int qtdVitorias;
    private int qtdDerrotas;
    private int qtdEmpates;

    public Pontuacao() {
        this.pontuacaoFinal = 0;
        this.golsPro = 0;
        this.golsContra = 0;
        this.saldoGols = golsPro - 0;
        this.qtdGolsEmCasa = 0;
        this.qtdGolsForaDeCasa = 0;
        this.qtdVitorias = 0;
        this.qtdDerrotas = 0;
        this.qtdEmpates = 0;
    }

    public Pontuacao(int pontuacaoFinal, int golsPro, int golsContra, int qtdGolsEmCasa, int qtdGolsForaDeCasa, int qtdVitorias, int qtdDerrotas, int qtdEmpates) {
        this.pontuacaoFinal = pontuacaoFinal;
        this.golsPro = golsPro;
        this.golsContra = golsContra;
        this.saldoGols = golsPro - golsContra;
        this.qtdGolsEmCasa = qtdGolsEmCasa;
        this.qtdGolsForaDeCasa = qtdGolsForaDeCasa;
        this.qtdVitorias = qtdVitorias;
        this.qtdDerrotas = qtdDerrotas;
        this.qtdEmpates = qtdEmpates;
    }

    public int getPontuacaoFinal() {return pontuacaoFinal;}
    public int getGolsPro() {return golsPro;}
    public int getGolsContra() {return golsContra;}
    public int getSaldoGols() {return saldoGols;}
    public int getQtdGolsEmCasa() {return qtdGolsEmCasa;}
    public int getQtdGolsForaDeCasa() {return qtdGolsForaDeCasa;}
    public int getQtdVitorias() {return qtdVitorias;}
    public int getQtdDerrotas() {return qtdDerrotas;}
    public int getQtdEmpates() {return qtdEmpates;}

    public void setPontuacaoFinal(int pontuacaoFinal) {this.pontuacaoFinal = pontuacaoFinal;}
    public void setGolsPro(int golsPro) {this.golsPro = golsPro;}
    public void setGolsContra(int golsContra) {this.golsContra = golsContra;}
    public void setSaldoGols(int saldoGols) {this.saldoGols = saldoGols;}
    public void setQtdGolsEmCasa(int qtdGolsEmCasa) {this.qtdGolsEmCasa = qtdGolsEmCasa;}
    public void setQtdGolsForaDeCasa(int qtdGolsForaDeCasa) {this.qtdGolsForaDeCasa = qtdGolsForaDeCasa;}
    public void setQtdVitorias(int qtdVitorias) {this.qtdVitorias = qtdVitorias;}
    public void setQtdDerrotas(int qtdDerrotas) {this.qtdDerrotas = qtdDerrotas;}
    public void setQtdEmpates(int qtdEmpates) {this.qtdEmpates = qtdEmpates;}


    public Pontuacao acrescentarGols(int golsPro, int golsContra, int qtdGolsEmCasa, int qtdGolsForaDeCasa) {
        this.golsPro += golsPro;
        this.golsContra += golsContra;
        this.saldoGols += golsPro - golsContra;
        this.qtdGolsEmCasa += qtdGolsEmCasa;
        this.qtdGolsForaDeCasa += qtdGolsForaDeCasa;

        if (golsPro > golsContra) {
            this.qtdVitorias++;
            this.pontuacaoFinal += 3;
        } else if (golsPro < golsContra) {
            this.qtdDerrotas++;
        } else {
            this.qtdEmpates++;
            this.pontuacaoFinal += 1;
        }

        return this;
    }

    public String toString() {
        return
            "\tPF: " + pontuacaoFinal +
            "\tV: " + qtdVitorias +
            "\tE: " + qtdEmpates +
            "\tD: " + qtdDerrotas +
            "\tGP: " + golsPro +
            "\tGC: " + golsContra +
            "\tSG: " + saldoGols +
            "\n";
    }

}
