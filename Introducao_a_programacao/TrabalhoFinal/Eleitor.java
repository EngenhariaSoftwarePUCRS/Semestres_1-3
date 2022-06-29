public class Eleitor {

    private int id;
    private String nome;
    private boolean situacao;
    private boolean jaVotou;

    public Eleitor() {
    }

    public Eleitor(int id, String nome, String situacao) {
        this.id = id;
        this.nome = nome;
        if (situacao.equalsIgnoreCase("apto"))
            this.situacao = true;
        else
            this.situacao = false;
        this.jaVotou = false;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getPrimeiroNome() {
        return this.nome.split(" ")[0];
    }

    public boolean getSituacao() {
        return this.situacao;
    }

    public boolean getJaVotou() {
        return this.jaVotou;
    }

    public void votar() {
        this.jaVotou = true;
    }

    public String situacaoToString() {
        if (situacao) {
            if (jaVotou)
                return "Já votou";
            return "Apto";
        } else
            return "Não Apto";
    }

    public String toString() {
        return ("Id: " + id +
                "\nNome: " + nome +
                "\nSituação: " + situacaoToString());
    }
}
