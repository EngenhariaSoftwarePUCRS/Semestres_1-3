package P1;

public class EncomendaSimples extends Encomenda {

    public EncomendaSimples(int codigo, String produto, String tamanho, double peso) {
        super(codigo, produto, tamanho, peso);
    }
    
    @Override
    public int getCodigo() {
        return 2000 + super.getCodigo();
    }

}
