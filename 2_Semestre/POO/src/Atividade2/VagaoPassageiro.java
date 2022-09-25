public class VagaoPassageiro extends Vagao {
    private int qtdPassageiros;

    public VagaoPassageiro(int identificador, int qtdPassageiros) {
        super(identificador, 75 * qtdPassageiros);
        this.qtdPassageiros = qtdPassageiros;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    @Override
    public String toString() {
        String livre = livre() ? "livre" : "engatado no trem ".concat(Integer.toString(trem.getIdentificador()));
        return ("\n\tVagão " + livre +
                "\n\tCapacidade de Carga = " + capacidadeCarga + "kg" +
                "\n\tQuantidade de Passageiros = " + qtdPassageiros +
                "\n\tIdentificador: " + identificador);
    }
}
