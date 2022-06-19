public class Person {

    private int id;
    private String nome;

    public Person() {
        this.id = 0;
        this.nome = null;
    }

    public Person(int id, String nome) {
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
