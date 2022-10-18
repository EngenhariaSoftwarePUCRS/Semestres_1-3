package Trabalho01;

import java.io.File;
import java.util.Date;

public class AppTest {
    public static void main(String[] args) {
        File[] files = new File("Trabalho01\\casosTeste").listFiles();
        Sistema sys = new Sistema();
        Date beginning, end;
        beginning = new Date();
        for (File file : files) {
            System.out.println(file);
            sys.main(file);
        }
        end = new Date();
        long tempoDecorrido = (end.getTime() - beginning.getTime()) / 1000;
        long minutosDecorridos = tempoDecorrido / 60;
        long horasDecorridas = tempoDecorrido / 3600;
        System.out.println("Tempo decorrido: ");
        System.out.print(horasDecorridas > 0 ? ((tempoDecorrido / 3600) + "h ") : " ");
        System.out.print(minutosDecorridos > 0 ? ((tempoDecorrido / 60) + "m ") : " ");
        System.out.print(" " + (tempoDecorrido % 60) + "s");
    }
}
