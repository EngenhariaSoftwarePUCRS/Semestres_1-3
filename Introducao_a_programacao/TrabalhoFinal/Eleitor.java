public class Eleitor {

    private int id;
    private String nome;
    private boolean situacao;
    private boolean jaVotou;

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
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public boolean getJaVotou() {
        return this.jaVotou;
    }

    public void votar() {
        this.jaVotou = true;
    }
    
    public String situacaoToString() {
        if (situacao)
            return "Apto";
        else
            return "Não Apto";
    }
    
    public String jaVotouToString() {
        if (jaVotou)
            return "Votou";
        else
            return "Não Votou";
    }

    public String toString() {
        return ("Id: " + id +
                "\nNome: " + nome +
                "\nSituação: " + situacaoToString() +
                "\nJá votou: " + jaVotouToString()               
                );
    }
}
