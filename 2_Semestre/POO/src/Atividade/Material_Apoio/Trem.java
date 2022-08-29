import java.util.ArrayList;

public class Trem {
	private int identificador;
	private ArrayList<Vagao> vagoes;
	private ArrayList<Locomotiva> locomotivas;

	public Trem(int identificador) {
		this.identificador = identificador;
		vagoes = new ArrayList<>();
		locomotivas = new ArrayList<>();
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

	private int maxVagoesNoTrem() {
		int somaVagoes = 0;
		int multiplicador = -1;
		for (Locomotiva locomotiva : locomotivas) {
			somaVagoes += locomotiva.getQtdadeMaxVagoes();
			multiplicador++;
		}
		somaVagoes -= (0.1 * multiplicador * somaVagoes);
		return somaVagoes;
	}

	public double pesoMaxNoTrem() {
		double soma = 0;
		for (Locomotiva locomotiva : locomotivas) {
			soma += locomotiva.getPesoMaximo();
		}
		return soma;
	}

	private double pesoAtualDoTrem() {
		int soma = 0;
		for (Vagao vagao : vagoes) {
			soma += vagao.getCapacidadeCarga();
		}
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

	public boolean desengataLocomotiva() {
		locomotivas.remove(getQtdadeLocomotivas() - 1);
		return false;
	}

	public boolean desengataVagao() {
		return false;
		// TO DO
	}

	public String toString() {
		return ("\nIdentificador: " + identificador +
				"\nVagões: " + vagoes +
				"\nLocomotivas: " + locomotivas);
		// TO DO
	}
}
