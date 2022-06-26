package aula;

public class Eleitor {

    public static final int SITUACAO_APTO = 1;
    public static final int SITUACAO_NAO_APTO = 2;

    private int codigo;
    private String nome;
    private int situacao;

    public Eleitor(int codigo, String nome, int situacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.situacao = situacao;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public int getSituacao() {
        return this.situacao;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public String descricaoSituacao() {
        if (this.situacao == SITUACAO_APTO)
            return "Apto";
        else
            return "Não Apto";
    }

    public String toString() {
        return "\nCódigo: " + getCodigo() +
                "\nNome: " + getNome() +
                "\nSituação: " + getSituacao();
    }

}