public class Clube {

    private String nomeClube;
    private Pontuacao pontuacao = new Pontuacao();

    public Clube() {
        this.nomeClube = "";
    }

    public Clube(String nomeClube) {
        this.nomeClube = nomeClube;
    }

    public Clube(String nomeClube, Pontuacao pontuacao) {
        this.nomeClube = nomeClube;
        this.pontuacao = pontuacao;
    }

    public void setNomeClube(String nomeClube) {
        this.nomeClube = nomeClube;
    }

    public void setPontuacao(Pontuacao pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getNomeClube() {
        return this.nomeClube;
    }

    public Pontuacao getPontuacao() {
        return this.pontuacao;
    }

    public String toString() {
        return ("\nClube = " + nomeClube +
                "\t" + pontuacao);
    }
}
