public class Vagao extends ElementoTrem {
	public Vagao(int identificador, double capacidadeCarga) {
		super(identificador, capacidadeCarga);
	}

	@Override
	public String toString() {
		String livre = livre() ? "livre" : "engatado no trem ".concat(Integer.toString(trem.getIdentificador()));
		return ("\n\tVagão " + livre +
				"\n\tCapacidade de Carga = " + capacidadeCarga + "kg" +
				"\n\tIdentificador: " + identificador);
	}
}