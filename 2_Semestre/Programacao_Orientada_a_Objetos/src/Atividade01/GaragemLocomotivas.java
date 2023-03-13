package Atividade01;

import java.util.ArrayList;

public class GaragemLocomotivas {
	private ArrayList<Locomotiva> locomotivas;

	public GaragemLocomotivas() {
		locomotivas = new ArrayList<>();
	}

	public void adicionaGaragem(Locomotiva l) {
		locomotivas.add(l);
	}

	public boolean removeGaragem(int id) {
		return locomotivas.remove(getPorId(id));
	}

	public int qtdade() {
		return locomotivas.size();
	}

	public Locomotiva getPorPosicao(int pos) {
		for (int i = 0; i < qtdade(); i++) {
			if (i == pos)
				return locomotivas.get(i);
		}
		return null;
	}

	public Locomotiva getPorId(int id) {
		for (Locomotiva locomotiva : locomotivas) {
			if (locomotiva.getIdentificador() == id)
				return locomotiva;
		}
		return null;
	}

	public String toString() {
		return (this.getClass().getName());
	}
}