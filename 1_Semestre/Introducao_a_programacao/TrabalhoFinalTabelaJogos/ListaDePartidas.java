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

    public boolean existePartida(int numeroPartida) {
        if (indexOf(numeroPartida) > -1)
            if (partidas[indexOf(numeroPartida)] != null)
                return true;
        return false;
    }

    public Partida consultaPartida(int numeroPartida) {
        return partidas[indexOf(numeroPartida)];
    }

    private int indexOf(int a) {
        int i = 0;

        if (partidas == null)
            return -1;

        while (i < partidas.length) {
            if (partidas[i] != null)
                if (partidas[i].getNumeroPartida() == a)
                    return i;
                else
                    i += 1;
            else
                i += 1;
        }

        return -1;
    }

    public void alteraTimesPartida(String timeAntigo, String timeNovo) {
        timeAntigo = timeAntigo.trim();
        timeNovo = timeNovo.trim();
        for (int i = 0; i < partidas.length; i++)
            if (partidas[i] != null) {
                Time time1 = partidas[i].getTime1();
                Time time2 = partidas[i].getTime2();
                if (timeAntigo.equalsIgnoreCase(time1.getNomeTime().trim()))
                    time1.setNomeTime(timeNovo.trim());
                if (timeAntigo.equalsIgnoreCase(time2.getNomeTime().trim()))
                    time2.setNomeTime(timeNovo.trim());
            }
    }

    public void inserePartida(Data dataPorInserir, Time[] timesPorInserir, int[] placarPorInserir) {
        Partida partidaPorInserir = new Partida(dataPorInserir, timesPorInserir, placarPorInserir);

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
                int mesPartida = dataPartida.getMes().getNumero();
                int mesPartidaSeguinte = dataPartidaSeguinte.getMes().getNumero();
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

    private void troca(int j) {
        Partida aux = partidas[j];
        partidas[j] = partidas[j + 1];
        partidas[j + 1] = aux;
    }
}
