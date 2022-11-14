package P1;

public class Moto extends VeiculoRegulado {

    public Moto(int matricula, double pesoMax, String placa) {
        super(matricula, pesoMax, placa);
    }

    @Override
    public boolean colocaEncomenda(Encomenda e) {
        if ((e.getPeso() <= getPesoDisponivel()) && (e.getTamanho().equals("Pequeno"))) {
            addEncomenda(e);
            return true;
        } else {
            return false;
        }
    }

}
