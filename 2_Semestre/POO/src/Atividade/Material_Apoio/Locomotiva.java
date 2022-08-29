public class Locomotiva {
	private int identificador;
	private double pesoMaximo;
	private int qtdadeMaxVagoes;
	private Trem trem;

	public Locomotiva(int identificador, double pesoMaximo, int qtdadeVagoes) {
		this.identificador = identificador;
		this.pesoMaximo = pesoMaximo;
		this.qtdadeMaxVagoes = qtdadeVagoes;
		this.trem = null;
	}

	public int getIdentificador() {
		return identificador;
	}

	public double getPesoMaximo() {
		return pesoMaximo;
	}

	public int getQtdadeMaxVagoes() {
		return qtdadeMaxVagoes;
	}

	public Trem getTrem() {
		return trem;
	}

	public boolean livre() {
		return trem == null;
	}

	public void setTrem(Trem trem) {
		this.trem = trem;
	}

	@Override
	public String toString() {
		if (livre()) {
			return "Locomotiva [LIVRE, identificador=" + identificador + ", pesoMaximo="
					+ pesoMaximo + ", qtdadeMaxVagoes=" + qtdadeMaxVagoes + "]";
		}
		return "Locomotiva [Engatada no trem=" + trem.getIdentificador() + ", identificador=" + identificador
				+ ", pesoMaximo="
				+ pesoMaximo + ", qtdadeMaxVagoes=" + qtdadeMaxVagoes + "]";
	}
}
