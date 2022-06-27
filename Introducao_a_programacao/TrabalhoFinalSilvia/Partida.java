public class Partida {

    private int numeroPartida = 0;
    private Data data = new Data();
    private Clube[] clubes = new Clube[2];
    private int[] placarPartida = new int[2];

    public Partida(Data data, Clube[] clubes, int[] placarPartida) {
        this.numeroPartida++;
        this.data = data;
        this.clubes = clubes;
        this.placarPartida = placarPartida;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setClubes(Clube[] clubes) {
        this.clubes = clubes;
    }

    public void setClube1(Clube clube1) {
        this.clubes[0] = clube1;
    }

    public void setClube2(Clube clube2) {
        this.clubes[1] = clube2;
    }

    public void setPlacarPartida(int[] placarPartida) {
        this.placarPartida = placarPartida;
    }

    public int getNumeroPartida() {
        return this.numeroPartida;
    }

    public Data getData() {
        return this.data;
    }

    public Clube[] getClubes() {
        return this.clubes;
    }

    public Clube getClube1() {
        return this.clubes[0];
    }

    public Clube getClube2() {
        return this.clubes[1];

    }

    public int[] getPlacarPartida() {
        return this.placarPartida;
    }

    public String toString() {
        return ("\n" + numeroPartida + "ª partida" +
                "\n" + data +
                "\nPrimeiro clube = " + clubes[0].getNomeClube() +
                "\tSegundo clube = " + clubes[1].getNomeClube() +
                "\nPlacar = (" + placarPartida[0] + " x " + placarPartida[1] + ")");
    }

}
