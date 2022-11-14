package Trabalho01;

public class NumeroComplexo implements Comparable<NumeroComplexo> {
    private double parteReal;
    private double parteImaginaria;

    public NumeroComplexo() {
        // Creates "0 + 0i" (0)
    }

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
        this.parteReal = parteReal == -0 ? 0 : parteReal;
    }

    public double getParteImaginaria() {
        return parteImaginaria;
    }

    public void setParteImaginaria(double parteImaginaria) {
        this.parteImaginaria = parteImaginaria == -0 ? 0 : parteImaginaria;
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

    // @Override
    // public boolean equals(Object o) {
    // if (o == null)
    // return false;

    // if (this.getClass() != o.getClass())
    // return false;

    // return (this.compareTo((NumeroComplexo) o) == 0);
    // }

    @Override
    public int compareTo(NumeroComplexo n) {
        if (n == null)
            return 1;
        // Comparando apenas a parte real
        if (this.parteReal >= 0 && n.parteReal >= 0) {
            // Se ambos forem positivos, o maior módulo é maior
            if (CalculadoraComplexo.absolute(this) > CalculadoraComplexo.absolute(n))
                return 1;
            else if (CalculadoraComplexo.absolute(this) < CalculadoraComplexo.absolute(n))
                return -1;
        } else if (this.parteReal < 0 && n.parteReal < 0) {
            // Se ambos forem negativos, o menor módulo é maior
            if (CalculadoraComplexo.absolute(this) < CalculadoraComplexo.absolute(n))
                return 1;
            else if (CalculadoraComplexo.absolute(this) > CalculadoraComplexo.absolute(n))
                return -1;
        } else if (this.parteReal > n.parteReal) {
            return 1;
        } else if (this.parteReal < n.parteReal) {
            return -1;
        }
        return 0;
    }
}
