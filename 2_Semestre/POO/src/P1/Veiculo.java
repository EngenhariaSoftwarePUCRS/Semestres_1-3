package P1;

import java.util.ArrayList;

public abstract class Veiculo implements IVeiculo {
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

    public double getPesoDisponivel() {
        double peso = 0.0;
        for (Encomenda e : encomendas) {
            peso += e.getPeso();
        }
        return (getPesoMax() - peso);
    }

    public void addEncomenda(Encomenda e) {
        encomendas.add(e);
    }

    public boolean retiraEncomenda(int codigo) {
        if (encomendas.size() != 0) {
            for (Encomenda e : encomendas) {
                if (e.getCodigo() == codigo) {
                    encomendas.remove(e);
                    return true;
                }
            }
        }
        return false;
    }

    public int qtdEncomendas() {
        return encomendas.size();
    }

}
