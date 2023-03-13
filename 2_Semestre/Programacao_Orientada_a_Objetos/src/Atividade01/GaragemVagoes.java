package Atividade01;

import java.util.ArrayList;

public class GaragemVagoes {
	private ArrayList<Vagao> vagoes;

	public GaragemVagoes() {
		vagoes = new ArrayList<>();
	}

	public void adicionaGaragem(Vagao v) {
		vagoes.add(v);
	}

	public boolean removeGaragem(int id) {
		return vagoes.remove(getPorId(id));
	}

	public int qtdade() {
		return vagoes.size();
	}

	public Vagao getPorPosicao(int pos) {
		for (int i = 0; i < qtdade(); i++) {
			if (i == pos)
				return vagoes.get(i);
		}
		return null;
	}

	public Vagao getPorId(int id) {
		for (Vagao vagao : vagoes) {
			if (vagao.getIdentificador() == id)
				return vagao;
		}
		return null;
	}

	public String toString() {
		return (this.getClass().getName());
	}
}