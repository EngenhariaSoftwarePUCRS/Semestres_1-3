public class TabelaDePontuacao {

    private Clube[] clubes = new Clube[20];

    public TabelaDePontuacao() {
        criarTabela();
    }

    private void criarTabela() {
        for (int i = 0; i < clubes.length; i++) {
            if (clubes[i] == null)
                clubes[i] = new Clube();
        }
    }

    public boolean insereClube(Clube clubePorInserir) {
        boolean preenchido = false;
        for (int i = 0; i < clubes.length; i++)
            if ((clubes[i] == null) || (clubes[i].getNomeClube().equals(""))) {
                clubes[i] = clubePorInserir;
                return !preenchido;
            }
        return preenchido;
    }

    public boolean excluiClube(Clube clubePorExcluir) {
        boolean excluido = true;
        for (int i = 0; i < clubes.length; i++)
            if (clubes[i] == clubePorExcluir) {
                clubes[i] = null;
                return excluido;
            }
        return !excluido;
    }

    public void consultaClube(Clube clube) {
        System.out.println(clube);
    }

    public void alteraClube(Clube clube, String nomeClube) {
        clube.setNomeClube(nomeClube);
    }

    public void alteraClube(Clube clube, Pontuacao pontuacao) {
        clube.setPontuacao(pontuacao);
    }

    public void exibirTabela() {
        for (Clube clube : clubes)
            if ((clube != null) && (!clube.getNomeClube().equals("")))
                System.out.println(clube);
    }

    public void ordenarTabela() {
        int quantidadeClubes = clubes.length - 1;
        int pontuacaoClube, pontuacaoProximoClube, vitoriasClube, vitoriasProximoClube;
        for (int i = 0; i < quantidadeClubes; i++) {
            for (int j = 0; j < quantidadeClubes - i; j++) {
                pontuacaoClube = clubes[j].getPontuacao().getQuantidadePontos();
                pontuacaoProximoClube = clubes[j + 1].getPontuacao().getQuantidadePontos();
                if (pontuacaoClube < pontuacaoProximoClube)
                    troca(j, clubes);
                else if (pontuacaoClube == pontuacaoProximoClube) {
                    vitoriasClube = clubes[j].getPontuacao().getQuantidadeVitorias();
                    vitoriasProximoClube = clubes[j + 1].getPontuacao().getQuantidadeVitorias();
                    if (vitoriasClube < vitoriasProximoClube)
                        troca(j, clubes);
                }
            }
        }
    }

    private void troca(int posicaoProcurada, Clube[] clubes) {
        Clube aux = clubes[posicaoProcurada];
        clubes[posicaoProcurada] = clubes[posicaoProcurada + 1];
        clubes[posicaoProcurada + 1] = aux;
    }
}
