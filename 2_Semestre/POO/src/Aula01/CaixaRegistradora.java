package Aula01;
public class CaixaRegistradora {
    private double precoTotal;
    private int numItens;

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getNumItens() {
        return numItens;
    }

    public void setNumItens(int numItens) {
        this.numItens = numItens;
    }

    public void addItem(double preco) {
        this.precoTotal += preco;
        this.numItens++;
    }

    public double getTotal() {
        return this.precoTotal;
    }

    public void limpa() {
        this.numItens = 0;
        this.precoTotal = 0;
    }
}
