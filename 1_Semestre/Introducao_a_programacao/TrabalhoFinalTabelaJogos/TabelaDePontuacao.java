public class TabelaDePontuacao {

    private Time[] times;

    public TabelaDePontuacao() {
        this.times = new Time[20];
        this.times[0] = new Time("Inter ");
        this.times[1] = new Time("Grêmio");
    }

    public Time[] getTimes() {
        return times;
    }

    public boolean existeTime(String nomeTime) {
        for (Time time : times) {
            if ((time != null) && (time.getNomeTime().equalsIgnoreCase(nomeTime)))
                return true;
        }
        return false;
    }

    public Time getTime(String nomeTime) {
        for (Time time : times) {
            if ((time != null) && (time.getNomeTime().equalsIgnoreCase(nomeTime)))
                return time;
        }
        return times[0];
    }

    public void alterarTime(String timeAntigo, String timeNovo) {
        for (int i = 0; i < times.length; i++)
            if ((times[i] != null) &&
                    times[i].getNomeTime().trim().equalsIgnoreCase(timeAntigo.trim()))
                times[i].setNomeTime(timeNovo);
    }

    public boolean inserirTime(Time timeNovo) {
        for (int i = 0; i < times.length; i++)
            if (times[i] == null) {
                times[i] = timeNovo;
                return true;
            }
        return false;
    }

    public void ordenarTabelaPontuacao() {
        int quantidadeTimes = times.length - 1;
        for (int i = 0; i < quantidadeTimes; i++) {
            for (int j = 0; j < quantidadeTimes - i; j++) {
                if ((times[j] != null) && (times[j + 1] != null)) {
                    int pontuacaoTime = times[j].getPontuacao().getQuantidadePontos();
                    int pontuacaoTimeSeguinte = times[j + 1].getPontuacao().getQuantidadePontos();
                    int vitoriaTime = times[j].getPontuacao().getQuantidadeVitorias();
                    int vitoriaTimeSeguinte = times[j + 1].getPontuacao().getQuantidadeVitorias();
                    if (pontuacaoTime < pontuacaoTimeSeguinte)
                        troca(j);
                    else {
                        if ((pontuacaoTime == pontuacaoTimeSeguinte)
                                && (vitoriaTime < vitoriaTimeSeguinte))
                            troca(j);
                    }
                }
            }
        }
    }

    private void troca(int j) {
        Time aux = times[j];
        times[j] = times[j + 1];
        times[j + 1] = aux;
    }

}
