package P1;

public class EncomendaClassificada extends Encomenda {

    public EncomendaClassificada(int codigo, String produto, String tamanho, double peso) {
        super(1000 + codigo, produto, tamanho, peso);
    }

    @Override
    public int getCodigo() {
        if (getTamanho().equals("Pequeno")) {
            return 000 + super.getCodigo();
        } else if (getTamanho().equals("Medio")) {
            return 300 + super.getCodigo();
        } else if (getTamanho().equals("Grande")) {
            return 600 + super.getCodigo();
        } else {
            return 9999;
        }
    }
    
}
