package Trabalho01;

import java.io.File;

public class App {
    public static void main(String[] args) {
        String filePath = args.length > 0 ? args[0]
                : "src/Trabalho01/casosTeste/1000macaquinhos.txt";

        long startTime = System.nanoTime();
        new JungleGame(new File(filePath)).play();
        long endTime = System.nanoTime();
        long fileTime = endTime - startTime;
        System.out.println("Tempo decorrido para analisar o arquivo: " + Util.convertLongToTime(fileTime));
    }
}
