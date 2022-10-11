package Aula19.Material_Apoio;

public class Usuario{
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String sexo;
    private String ip;

    public Usuario(int id, String nome, String sobrenome, String email, String sexo, String ip) {
        super();
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.sexo = sexo;
        this.ip = ip;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getSexo() {
        return sexo;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", sexo="
                + sexo + ", ip=" + ip + "]";
    }
}