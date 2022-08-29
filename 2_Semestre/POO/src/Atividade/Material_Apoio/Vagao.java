public class Vagao {
	private int identificador;
	private double capacidadeCarga;
	private Trem trem;

	public Vagao(int identificador, double capacidadeCarga) {
		this.identificador = identificador;
		this.capacidadeCarga = capacidadeCarga;
		this.trem = null;
	}

	public int getIdentificador() {
		return identificador;
	}

	public double getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public Trem getTrem() {
		return trem;
	}

	public boolean livre(){
		return trem == null;
	}

	public void setTrem(Trem trem) {
		this.trem = trem;
	}

	@Override
	public String toString() {
		if (livre()){
			return "Vagao [LIVRE, capacidadeCarga=" + capacidadeCarga + ", identificador=" + identificador + "]";
		}
		return "Vagao [Engatado no trem: "+trem.getIdentificador()+", capacidadeCarga=" + capacidadeCarga + ", identificador="+ identificador + "]";
	}
}