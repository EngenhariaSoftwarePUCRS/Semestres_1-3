public class Time {

    private String nomeTime;
    private Pontuacao pontuacao;

    public Time(String nomeTime) {
        this.nomeTime = nomeTime;
        this.pontuacao = new Pontuacao();
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public void setPontuacao(Pontuacao pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getNomeTime() {
        return this.nomeTime;
    }

    public Pontuacao getPontuacao() {
        return this.pontuacao;
    }

    public String toString() {
        return (nomeTime + pontuacao);
    }
}
