package Trabalho01;

public class NumeroComplexo {
    private double parteReal;
    private double parteImaginaria;

    public NumeroComplexo() {}

    public NumeroComplexo(NumeroComplexo n) {
        this.parteReal = n.getParteReal();
        this.parteImaginaria = n.getParteImaginaria();
    }

    public NumeroComplexo(double parteReal, double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    public double getParteReal() {
        return parteReal;
    }

    public void setParteReal(double parteReal) {
        this.parteReal = parteReal;
    }

    public double getParteImaginaria() {
        return parteImaginaria;
    }

    public void setParteImaginaria(double parteImaginaria) {
        this.parteImaginaria = parteImaginaria;
    }

    public String parteRealToString() {
        String parteReal = this.parteReal != 0
                    ? Double.toString(this.parteReal)
                    : "";
        return parteReal;
    }

    public String parteImaginariaToString() {
        String parteImaginaria = "";
        if (this.parteImaginaria < 0)
            parteImaginaria = (" "+Double.toString(this.parteImaginaria)+"i");
        else if (this.parteImaginaria > 0)
            parteImaginaria = (" + "+Double.toString(this.parteImaginaria)+"i");
        return parteImaginaria;
    }

    public String toString() {
        return (parteRealToString() + parteImaginariaToString());
    }
}
