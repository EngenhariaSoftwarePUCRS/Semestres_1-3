import java.text.SimpleDateFormat;
import java.util.Calendar;

// (2,0) Partida: esta classe modelo deve representar uma partida de um jogo de 
// futebol, incluindo, data, horário da partida, bem como os clubes e os escores 
// obtidos no jogo.
public class Partida {

    private String data = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
    private String hora = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
    private Time[] times = new Time[2];
    private int[] scores = new int[2];
    private int numeroPartida;

    public Partida(Time[] times, int[] scores, int numeroPartida) {
        this.times = times;
        this.scores = scores;
        this.numeroPartida = numeroPartida;
    } 

    public Partida(String data, String hora, Time[] times, int[] scores, int numeroPartida) {
        this.data = data;
        this.hora = hora;
        this.times = times;
        this.scores = scores;
        this.numeroPartida = numeroPartida;
    }
    
    public String getData() {return data;}    
    public String getHora() {return hora;}
    public Time[] getTimes() {return times;}
    public int[] getScores() {return scores;}
    public int getNumeroPartida() {return numeroPartida;}

    public String toString() {
        return
            "\n\t"+numeroPartida+"ª partida\t" +
            "\nData: " + data +
            "\tHora: " + hora +
            "\nTime 1: " + times[0].getNome() +
            "\tGols: " + scores[0] +
            "\nTime 2: " + times[1].getNome() +
            "\tGols: " + scores[1];
    }
}
