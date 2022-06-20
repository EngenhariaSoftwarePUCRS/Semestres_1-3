public class TabelaEleitor {
    private Eleitor[] eleitores;
    private int limite;

    public TabelaEleitor(int limite) {
        this.eleitores = new Eleitor[limite];
        this.limite = limite;
    }

    public boolean adicionarEleitor(Eleitor novoEleitor) {
        boolean achouEspacoLivre = false;
        boolean deuErro = false;
        int i = 0;
        
        while ((!achouEspacoLivre) && (!deuErro)) {
            if (eleitores[i] == null) {
                eleitores[i] = novoEleitor;
                achouEspacoLivre = true;
                deuErro = false;
            }
            i++;
            if ((i == this.limite) && (!achouEspacoLivre)) deuErro = true;
        }

        return !deuErro;
    }

    public void listarEleitores() {
        for (int i = 0; i < eleitores.length; i++) {
            if (eleitores[i] != null)
                System.out.printf("%nCódigo: %d%nNome: %s%nSituação: %d", eleitores[i].getCodigo(), eleitores[i].getNome(), eleitores[i].getSituacao());
        }
    }

    public boolean carregarArquivoEleitores(String localArquivo) {
        // para se divertir
        return false;
    }
}
