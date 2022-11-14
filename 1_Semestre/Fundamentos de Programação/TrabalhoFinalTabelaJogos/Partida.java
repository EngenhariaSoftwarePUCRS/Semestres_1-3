public class Partida {

    private int numeroPartida;
    private Data data;
    private Time[] times;
    private int[] placarPartida;

    public Partida(Data data, Time[] times, int[] placarPartida) {
        this.data = data;
        this.times = times;
        this.placarPartida = placarPartida;
    }

    public void setNumeroPartida(int numeroPartida) {
        this.numeroPartida = numeroPartida;
    }

    public int getNumeroPartida() {
        return this.numeroPartida;
    }

    public Time getTime1() {
        return times[0];
    }

    public Time getTime2() {
        return times[1];
    }

    public Data getData() {
        return this.data;
    }

    public String toString() {
        return ("\n" + numeroPartida + "ª partida" +
                "\n" + data +
                "\nPrimeiro time = " + getTime1().getNomeTime() +
                "\tSegundo time = " + getTime2().getNomeTime() +
                "\nPlacar = (" + placarPartida[0] + " x " + placarPartida[1] + ")");
    }

}
