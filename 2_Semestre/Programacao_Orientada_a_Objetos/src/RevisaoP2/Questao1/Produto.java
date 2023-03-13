package RevisaoP2.Questao1;

public class Produto<T, U> {
    private T codigo;
    private String descricao;
    private U preco;

    public Produto(T codigo, String descricao, U preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public T getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public U getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto {" +
                "\n\tcodigo: " + codigo +
                "\n\tdescricao: " + descricao +
                "\n\tpreco: " + preco +
                "\n}";
    }
}