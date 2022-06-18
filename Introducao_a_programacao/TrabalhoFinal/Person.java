public class Pessoa {
    
    private int id;
    private String nome;

    public Pessoa() {
        this.id = 0;
        this.nome = null;
    }

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
