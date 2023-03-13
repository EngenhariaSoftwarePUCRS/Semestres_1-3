package Atividade02;

import java.util.ArrayList;

public class Trem {
	private int identificador;
	private ArrayList<Vagao> vagoes;
	private ArrayList<Locomotiva> locomotivas;
	private ArrayList<VagaoPassageiro> vagoesPassageiros;

	public Trem(int identificador) {
		this.identificador = identificador;
		vagoes = new ArrayList<>();
		locomotivas = new ArrayList<>();
		vagoesPassageiros = new ArrayList<>();
	}

	public int getIdentificador() {
		return identificador;
	}

	public int getQtdadeLocomotivas() {
		return locomotivas.size();
	}

	public Locomotiva getLocomotiva(int posicao) {
		for (int i = 0; i < locomotivas.size(); i++) {
			if (i == posicao)
				return locomotivas.get(i);
		}
		return null;
	}

	public int getQtdadeVagoes() {
		return vagoes.size();
	}

	public Vagao getVagao(int posicao) {
		for (int i = 0; i < vagoes.size(); i++) {
			if (i == posicao)
				return vagoes.get(i);
		}
		return null;
	}

	public int getQtdadeVagoesPassageiros() {
		return vagoesPassageiros.size();
	}

	public VagaoPassageiro getVagaoPassageiro(int posicao) {
		for (int i = 0; i < vagoesPassageiros.size(); i++) {
			if (i == posicao)
				return vagoesPassageiros.get(i);
		}
		return null;
	}

	private int maxVagoesNoTrem() {
		int somaVagoes = 0;
		int multiplicador = -1;
		for (Locomotiva locomotiva : locomotivas) {
			somaVagoes += locomotiva.getQtdadeMaxVagoes();
			multiplicador++;
		}
		somaVagoes -= ((multiplicador * somaVagoes) / 10);
		return somaVagoes;
	}

	public double pesoMaxNoTrem() {
		double soma = 0;
		for (Locomotiva locomotiva : locomotivas) {
			soma += locomotiva.getCapacidadeCarga();
		}
		return soma;
	}

	private double pesoAtualDoTrem() {
		int soma = 0;
		for (Vagao vagao : vagoes)
			soma += vagao.getCapacidadeCarga();
		for (VagaoPassageiro vagaoPassageiro : vagoesPassageiros)
			soma += vagaoPassageiro.getCapacidadeCarga();
		return soma;
	}

	public boolean engataLocomotiva(Locomotiva locomotiva) {
		if (!vagoes.isEmpty())
			return false;
		locomotivas.add(locomotiva);
		return true;
	}

	public boolean engataVagao(Vagao vagao) {
		vagoes.add(vagao);
		return true;
	}

	public boolean engataVagaoPassageiro(VagaoPassageiro vagaoPassageiro) {
		vagoesPassageiros.add(vagaoPassageiro);
		return true;
	}

	public boolean desengataLocomotiva() {
		if (locomotivas.isEmpty())
			return false;
		else {
			locomotivas.get(locomotivas.size() - 1).setTrem(null);
			locomotivas.remove(locomotivas.size() - 1);
			return true;
		}
	}

	public boolean desengataVagao() {
		if (vagoes.isEmpty())
			return false;
		else {
			vagoes.get(vagoes.size() - 1).setTrem(null);
			vagoes.remove(vagoes.size() - 1);
			return true;
		}
	}

	public boolean desengataVagaoPassageiro() {
		if (vagoesPassageiros.isEmpty())
			return false;
		else {
			vagoesPassageiros.get(vagoesPassageiros.size() - 1).setTrem(null);
			vagoesPassageiros.remove(vagoes.size() - 1);
			return true;
		}
	}

	public String toString() {
		return ("\nIdentificador: " + identificador +
				"\nVagões: " + vagoes +
				"\nVagões de Passageiros: " + vagoesPassageiros +
				"\nLocomotivas: " + locomotivas);
	}
}
