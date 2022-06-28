public class ListaDePartidas {

    private Partida[] partidas;

    public ListaDePartidas() {
        this.partidas = new Partida[380];
    }

    public Partida[] getPartidas() {
        return this.partidas;
    }
    
    private int getQuantidadePartidas() {
        int quantidadePartidas = 0;

        for (Partida partida : partidas)
            if (partida != null)
                quantidadePartidas++;

        return quantidadePartidas;
    }
    
    public boolean existePartida(int indicePartida) {
        if (partidas[indicePartida - 1] != null) return true;
        return false;
    }
    
    public Partida consultaPartida(int indicePartida) {
        return partidas[indicePartida - 1];
    }
    
    public void inserePartida(Data dataPorInserir, Clube[] clubesPorInserir, int[] placarPorInserir) {
        Partida partidaPorInserir = new Partida(dataPorInserir, clubesPorInserir, placarPorInserir);

        for (int i = 0; i < partidas.length; i++)
            if (partidas[i] == null) {
                partidas[i] = partidaPorInserir;
                partidas[i].setNumeroPartida(i + 1);
                break;
            }
    }

    public void ordenarTabelaData() {
        int quantidadePartidas = getQuantidadePartidas() - 1;
        for (int i = 0; i < quantidadePartidas; i++) {
            for (int j = 0; j < quantidadePartidas - i; j++) {
                Data dataPartida = partidas[j].getData();
                Data dataPartidaSeguinte = partidas[j + 1].getData();
                int mesPartida = dataPartida.getMes();
                int mesPartidaSeguinte = dataPartidaSeguinte.getMes();
                int diaPartida = dataPartida.getDia();
                int diaPartidaSeguinte = dataPartidaSeguinte.getDia();
                int horaPartida = dataPartida.getHora();
                int horaPartidaSeguinte = dataPartidaSeguinte.getHora();
                int minutoPartida = dataPartida.getMinuto();
                int minutoPartidaSeguinte = dataPartidaSeguinte.getMinuto();
                if (mesPartida > mesPartidaSeguinte)
                    troca(j);
                else if (mesPartida == mesPartidaSeguinte)
                    if (diaPartida > diaPartidaSeguinte)
                        troca(j);
                    else if (diaPartida == diaPartidaSeguinte)
                        if (horaPartida > horaPartidaSeguinte)
                            troca(j);
                        else if (horaPartida == horaPartidaSeguinte)
                            if (minutoPartida > minutoPartidaSeguinte)
                                troca(j);
            }
        }
    }

    private void troca(int posicaoProcurada) {
        Partida aux = partidas[posicaoProcurada];
        partidas[posicaoProcurada] = partidas[posicaoProcurada + 1];
        partidas[posicaoProcurada + 1] = aux;
    }
}
