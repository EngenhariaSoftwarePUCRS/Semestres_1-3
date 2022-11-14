package P1;

public abstract class VeiculoRegulado extends Veiculo {
    private String placa;

    protected VeiculoRegulado(int matricula, double pesoMax, String placa) {
        super(matricula, pesoMax);
        this.placa = placa;
    }

    public String getPlaca() {
        return this.placa;
    }

}
