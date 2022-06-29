public class Candidato {

    private int id;
    private String nome;
    private String partido;
    private int quantidadeVotos;

    public Candidato() {
    }

    public Candidato(int id, String nome, String partido) {
        this.id = id;
        this.nome = nome;
        this.partido = partido;
        this.quantidadeVotos = 0;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getPartido() {
        return this.partido;
    }

    public int getQuandidadeVotos() {
        return this.quantidadeVotos;
    }

    public void adicionarVoto() {
        this.quantidadeVotos++;
    }

    public String toString() {
        return ("Id: " + id +
                "\nNome: " + nome +
                "\nPartido: " + partido);
    }
}
