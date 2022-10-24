package util;

import java.util.Date;

public class Timer {
    private Date beginning;
    private Date end;
    private long tempoDecorrido;
    private long minutosDecorridos;
    private long horasDecorridas;

    public void start() {
        beginning = new Date();
    }

    public void finish() {
        end = new Date();
        tempoDecorrido = (end.getTime() - beginning.getTime()) / 1000;
        minutosDecorridos = tempoDecorrido / 60;
        horasDecorridas = tempoDecorrido / 3600;
        tempoDecorrido %= 60;
    }

    public String toString() {
        String tempo = "Tempo decorrido: ";

        if (horasDecorridas > 0)
            tempo += (horasDecorridas + "h ");
        if (minutosDecorridos > 0)
            tempo += (minutosDecorridos + "m ");
        tempo += (tempoDecorrido + "s");

        return tempo;
    }
}
