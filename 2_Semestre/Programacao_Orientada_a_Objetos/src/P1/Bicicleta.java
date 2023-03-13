package P1;

public class Bicicleta extends Veiculo {

    public Bicicleta(int matricula, double pesoMax) {
        super(matricula, pesoMax);
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
