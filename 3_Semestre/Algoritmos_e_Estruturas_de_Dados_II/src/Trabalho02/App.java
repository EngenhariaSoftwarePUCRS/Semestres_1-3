package Trabalho02;

public class App {
    public static void main(String[] args) {
        // Without extension (txt), should be located inside mapas/ folder
        String fileName = args.length > 0 ? args[0] : "mapa_500_1000";
        int harbourAmount = 9;

        long startTime = System.nanoTime();
        new Map(fileName, harbourAmount);
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        System.out.println("Tempo decorrido para analisar o arquivo: " + Util.convertLongToTime(time));
    }
}
