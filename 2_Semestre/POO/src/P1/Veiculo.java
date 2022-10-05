package P1;

import java.util.ArrayList;

public abstract class Veiculo {
    private int matricula;
    private double pesoMax;
    private ArrayList<Encomenda> encomendas;

    protected Veiculo(int matricula, double pesoMax) {
        this.matricula = matricula;
        this.pesoMax = pesoMax;
        encomendas = new ArrayList<>();
    }

    public int getMatricula() {
        return matricula;
    }

    public double getPesoMax() {
        return pesoMax;
    }

    // public int compareTo(int matricula) {
    // if (this.matricula < matricula)
    // return -1;
    // else if (this.matricula > matricula)
    // return 1;
    // else
    // return 0;
    // }

}
