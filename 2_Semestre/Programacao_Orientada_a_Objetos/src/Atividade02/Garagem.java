package Atividade02;

import java.util.ArrayList;

public class Garagem {
    private ArrayList<ElementoTrem> elementos;

    public Garagem() {
        elementos = new ArrayList<>();
    }

    public void adicionaGaragem(ElementoTrem e) {
        elementos.add(e);
    }

    public boolean removeGaragem(int id, String tipo) {
        return elementos.remove(getPorId(id, tipo));
    }

    public int qtdade() {
        return elementos.size();
    }

    public ElementoTrem getPorPosicao(int pos) {
        if ((pos >= 0) && (pos < qtdade()))
            return elementos.get(pos);
        return null;
    }

    public ElementoTrem getPorId(int id, String tipo) {
        for (ElementoTrem elementoTrem : elementos) {
            if ((elementoTrem.getIdentificador() == id) && (elementoTrem.getClass().getName().endsWith(tipo)))
                return elementoTrem;
        }
        return null;
    }

    public String toString() {
        return (this.getClass().getName().replace("Atividade02.", null));
    }
}
