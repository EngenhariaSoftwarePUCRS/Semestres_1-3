public class TabelaDePontuacao {

    private Clube[] clubes = new Clube[20];

    public TabelaDePontuacao() {
        this.clubes[0] = new Clube("Bruno FC");
        this.clubes[1] = new Clube("Duda FC");
    }

    public Clube[] getClubes() {
        return clubes;
    }

    public boolean existeClube(String nomeClube) {
        for (int i = 0; i < clubes.length; i++) {
            if (clubes[i] != null) {
                if (clubes[i].getNomeClube().trim().equalsIgnoreCase(nomeClube.trim()))
                    return true;
            }
        }
        return false;
    }

    public Clube consultaClube(String nomeClubePorConsultar) {
        for (int i = 0; i < clubes.length; i++)
            if (clubes[i].getNomeClube().trim().equalsIgnoreCase(nomeClubePorConsultar.trim()))
                return clubes[i];
        return clubes[0];
    }

    public void alteraClube(String clubeAntigo, String clubeNovo) {
        for (int i = 0; i < clubes.length; i++)
            if (clubes[i] != null)
                if (clubes[i].getNomeClube().trim().equalsIgnoreCase(clubeAntigo.trim()))
                    clubes[i].setNomeClube(clubeNovo);
    }

    public boolean insereClube(Clube clube) {
        for (int i = 0; i < clubes.length; i++) {
            if(clubes[i] == null) {
                clubes[i] = clube; 
                return true;
            }
        } return false;
    }

    public void ordenarTabelaPontuacao() {
        int quantidadeClubes = clubes.length - 1;
        for (int i = 0; i < quantidadeClubes; i++) {
            for (int j = 0; j < quantidadeClubes - i; j++) {
                if ((clubes[j] != null) && (clubes[j + 1] != null)) {
                    int pontuacaoClube = clubes[j].getPontuacao().getQuantidadePontos();
                    int pontuacaoClubeSeguinte = clubes[j + 1].getPontuacao().getQuantidadePontos();
                    int vitoriaClube = clubes[j].getPontuacao().getQuantidadeVitorias();
                    int vitoriaClubeSeguinte = clubes[j + 1].getPontuacao().getQuantidadeVitorias();
                    if (pontuacaoClube < pontuacaoClubeSeguinte)
                        troca(j);
                    else if (pontuacaoClube == pontuacaoClubeSeguinte)
                        if (vitoriaClube < vitoriaClubeSeguinte)
                            troca(j);
                }
            }
        }
    }

    private void troca(int j) {
        Clube aux = clubes[j];
        clubes[j] = clubes[j + 1];
        clubes[j + 1] = aux;
    }

}
