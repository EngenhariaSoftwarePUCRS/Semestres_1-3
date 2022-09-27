package Atividade.Material_Apoio;

import java.util.ArrayList;

public class PatioDeManobras {
	private ArrayList<Trem> trens;

	public PatioDeManobras() {
		trens = new ArrayList<>();
	}

	public void adicionaPatio(Trem t) {
		trens.add(t);
	}

	public boolean removePatio(int id) {
		for (Trem trem : trens) {
			if (trem.getIdentificador() == id) {
				trens.remove(trem);
				return true;
			}
		}
		return false;
	}

	public int qtdade() {
		return trens.size();
	}

	public Trem getPorPosicao(int pos) {
		for (int i = 0; i < qtdade(); i++) {
			if (i == pos)
				return trens.get(i);
		}
		return null;
	}

	public Trem getPorId(int id) {
		for (Trem trem : trens) {
			if (trem.getIdentificador() == id)
				return trem;
		}
		return null;
	}

	public String toString() {
		return this.getClass().getName();
	}
}