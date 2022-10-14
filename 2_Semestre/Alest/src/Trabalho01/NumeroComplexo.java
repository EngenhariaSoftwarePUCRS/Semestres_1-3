package Trabalho01;

public class NumeroComplexo {
    private double parteReal;
    private double parteImaginaria;

    public NumeroComplexo(NumeroComplexo n) {
        this.parteReal = n.getParteReal() == -0 ? 0 : n.getParteReal();
        this.parteImaginaria = n.getParteImaginaria() == -0 ? 0 : n.getParteImaginaria();
    }

    public NumeroComplexo(double parteReal, double parteImaginaria) {
        this.parteReal = parteReal == -0 ? 0 : parteReal;
        this.parteImaginaria = parteImaginaria == -0 ? 0 : parteImaginaria;
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
        return this.parteReal != 0
                ? Double.toString(this.parteReal)
                : "";
    }

    public String parteImaginariaToString() {
        String parteImaginaria = "";
        if (this.parteImaginaria < 0)
            parteImaginaria = (" " + Double.toString(this.parteImaginaria) + "i");
        else if (this.parteImaginaria > 0)
            parteImaginaria = (" + " + Double.toString(this.parteImaginaria) + "i");
        return parteImaginaria;
    }

    public String toString() {
        if (parteReal == parteImaginaria && parteImaginaria == 0)
            return "0";
        return (parteRealToString() + parteImaginariaToString());
    }
}
