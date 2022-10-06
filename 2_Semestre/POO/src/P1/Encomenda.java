package P1;

public class Encomenda {
    private int codigo;
    private String produto;
    private String tamanho;
    private double peso;
    
    public Encomenda(int codigo, String produto, String tamanho, double peso) {
        this.codigo = codigo;
        this.produto = produto;
        this.tamanho = tamanho;
        this.peso = peso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getProduto() {
        return produto;
    }

    public String getTamanho() {
        return tamanho;
    }

    public double getPeso() {
        return peso;
    }
    
}
