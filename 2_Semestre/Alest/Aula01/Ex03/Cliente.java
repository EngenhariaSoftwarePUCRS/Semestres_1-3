package Ex03;

public class Cliente {
    private String nome;
    private CPF cpf;
    private int idade;
    private char genero;

    public Cliente() {
        this.cpf = new CPF("00000000000");
    }

    public Cliente(String nome, String cpf, int idade, char genero) {
        this.nome = nome;
        this.cpf = new CPF(cpf);
        this.idade = idade;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String toString() {
        return (""
            + "Nome: " + nome
            + "\nCpf: " + cpf
            + "\nIdade: " + idade
            + "\nGênero: " + genero   
        );
    }

}
