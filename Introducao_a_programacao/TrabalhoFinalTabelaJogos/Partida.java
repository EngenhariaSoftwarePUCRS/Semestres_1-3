public class Partida {

    private int numeroPartida = 0;
    private Data data = new Data();
    private Clube[] clubes = new Clube[2];
    private int[] placarPartida = new int[2];

    public Partida(Data data, Clube[] clubes, int[] placarPartida) {
        this.data = data;
        this.clubes = clubes;
        this.placarPartida = placarPartida;
    }

    public void setNumeroPartida(int numeroPartida) {
        this.numeroPartida = numeroPartida;
    }

    public int getNumeroPartida() {
        return this.numeroPartida;
    }

    public Clube getClube1() {
        return clubes[0];
    }

    public Clube getClube2() {
        return clubes[1];
    }

    public Data getData() {
        return this.data;
    }

    public String toString() {
        return ("\n" + numeroPartida + "ª partida" +
                "\n" + data +
                "\nPrimeiro clube = " + clubes[0].getNomeClube() +
                "\tSegundo clube = " + clubes[1].getNomeClube() +
                "\nPlacar = (" + placarPartida[0] + " x " + placarPartida[1] + ")");
    }

}
