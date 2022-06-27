public class ListaDePartidas {

    private Partida[] partidas;

    public ListaDePartidas() {
        this.partidas = new Partida[380];
    }

    public Partida getPartida(int indicePartida) {
        return partidas[indicePartida];
    }

    public int getQuantidadePartidas() {
        int quantidadePartidas = 0;

        for (Partida partida : partidas) {
            if ((partida != null) && ((!partida.getClube1().getNomeClube().equals("")) || (!partida.getClube2().getNomeClube().equals(""))))
                quantidadePartidas++;
        }

        return quantidadePartidas;
    }

    public boolean inserePartida(Data dataPorInserir, Clube[] clubesPorInserir, int[] placarPorInserir) {
        Partida partidaPorInserir = new Partida(dataPorInserir, clubesPorInserir, placarPorInserir);
        boolean preenchido = false;
        
        for (int i = 0; i < partidas.length; i++)
            if (partidas[i] == null) {
                partidas[i] = partidaPorInserir;
                return !preenchido;
            }

        return preenchido;
    }

    public boolean excluiPartida(Partida partidaPorExcluir) {
        boolean excluido = true;
        if (partidaPorExcluir != null)
            for (int i = 0; i < partidas.length; i++)
                if (partidas[i] == partidaPorExcluir) {
                    partidas[i] = null;
                    return excluido;
                }
        return !excluido;
    }

    public boolean consultaPartida(Partida partida) {
        boolean encontrada = true;

        if (partida != null)
            return encontrada;

        return !encontrada;
    }

    public void alteraPartida(Partida partida, boolean qualClube, Clube clube) {
        if (!qualClube)
            partida.setClube1(clube);
        else
            partida.setClube2(clube);
    }

    public void alteraPartida(Partida partida, int[] pontuacaoClube) {
        partida.setPlacarPartida(pontuacaoClube);
    }

    public void exibirLista() {
        for (Partida partida : partidas)
            if (partida != null)
                System.out.println(partida);
    }

    public void ordernarListaPorData() {
        // AmanhãDay
    }
}
