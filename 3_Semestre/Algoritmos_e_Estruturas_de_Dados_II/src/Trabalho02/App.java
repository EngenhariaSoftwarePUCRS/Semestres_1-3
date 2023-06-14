package Trabalho02;

public class App {
    public static void main(String[] args) {
        // Without extension (txt), should be located inside mapas/ folder
        String fileName = args.length > 0 ? args[0] : "mapa_500_1000";
        int harbourAmount = 9;

        long startTime = System.nanoTime();
        Mapa map = new Mapa(fileName, harbourAmount);
        System.out.println(map.getDistances());
        long endTime = System.nanoTime();
        long fileTime = endTime - startTime;
        System.out.println("Tempo decorrido para analisar o arquivo: " + Util.convertLongToTime(fileTime));
    }
}
