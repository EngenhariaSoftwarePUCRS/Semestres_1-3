public class Time {
    private String nome;
    private Pontuacao pontuacao = new Pontuacao();

    public Time(String nome) {
        this.nome = nome;
    }

    public Time(String nome, Pontuacao pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }
    
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public Pontuacao getPontuacao() {return pontuacao;}
    public void setPontuacao(Pontuacao pontuacao) {this.pontuacao = pontuacao;}

    public String toString() {
        return
            "\n" + nome + 
            "\tpontuação: " + pontuacao +
            "\n";
    }
}
