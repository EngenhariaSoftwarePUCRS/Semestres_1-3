package P1;

public class Carro extends VeiculoRegulado {

    protected Carro(int matricula, double pesoMax, String placa) {
        super(matricula, pesoMax, placa);
    }

    @Override
    public boolean colocaEncomenda(Encomenda e) throws IllegalArgumentException {
        if (!((e.getTamanho().equals("Pequeno")) || (e.getTamanho().equals("Medio")) || (e.getTamanho().equals("Grande"))))
            throw new IllegalArgumentException();
        if ((e.getPeso() <= getPesoDisponivel())) {
            addEncomenda(e);
            return true;
        } else {
            return false;
        }
    }

}
