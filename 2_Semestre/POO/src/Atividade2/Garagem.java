package Atividade2;

import java.util.ArrayList;

public class Garagem {
    private ArrayList<ElementoTrem> elementos;

    public Garagem() {
        elementos = new ArrayList<>();
    }

    public void adicionaGaragem(ElementoTrem e) {
        elementos.add(e);
    }

    public boolean removeGaragem(int id) {
        return elementos.remove(getPorId(id));
    }

    public int qtdade() {
        return elementos.size();
    }

    public ElementoTrem getPorPosicao(int pos) {
        for (int i = 0; i < qtdade(); i++) {
            if (i == pos)
                return elementos.get(i);
        }
        return null;
    }

    public ElementoTrem getPorId(int id) {
        for (ElementoTrem elementoTrem : elementos) {
            if (elementoTrem.getIdentificador() == id)
                return elementoTrem;
        }
        return null;
    }

    public String toString() {
        return (this.getClass().getName());
    }
}
