public class Locomotiva extends ElementoTrem {
	private int qtdadeMaxVagoes;

	public Locomotiva(int identificador, double capacidadeCarga, int qtdadeMaxVagoes) {
		super(identificador, capacidadeCarga);
		this.qtdadeMaxVagoes = qtdadeMaxVagoes;
	}

	public int getQtdadeMaxVagoes() {
		return qtdadeMaxVagoes;
	}

	@Override
	public String toString() {
		String livre = livre() ? "livre" : "engatada no trem ".concat(Integer.toString(trem.getIdentificador()));
		return ("\n\tLocomotiva " + livre +
				"\n\tIdentificador: " + identificador +
				"\n\tPeso Máximo: " + capacidadeCarga + "kg" +
				"\n\tQuantidade Máxima Vagões: " + qtdadeMaxVagoes);
	}
}
