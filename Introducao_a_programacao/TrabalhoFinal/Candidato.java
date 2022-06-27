public class Candidato {

    private int id;
    private String nome;
    private String partido;

    public Candidato(int id, String nome, String partido) {
        this.id = id;
        this.nome = nome;
        this.partido = partido;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPartido() {
        return partido;
    }

    public String toString() {
        return ("\nId: " + id +
                "\nNome: " + nome +
                "\nPartido: " + partido);
    }
}
