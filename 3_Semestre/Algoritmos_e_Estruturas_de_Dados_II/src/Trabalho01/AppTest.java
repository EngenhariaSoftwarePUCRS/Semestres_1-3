package Trabalho01;

import java.io.File;

public class AppTest {
    public static void main(String[] args) {
        String filesPath = args.length > 0 ? args[0]
                : "src/Trabalho01/casosTeste";

        try {
            long totalTime = 0;
            File[] files = new File(filesPath).listFiles();

            for (File file : files) {
                System.out.print("\nAnalisando arquivo: ");
                System.out.println(file.getName());
                long startTime = System.nanoTime();
                new JungleGame(file).play();
                long endTime = System.nanoTime();
                long fileTime = endTime - startTime;
                System.out.println("Tempo decorrido para analisar o arquivo: " + convertLongToTime(fileTime));
                totalTime += fileTime;
            }

            String totalFilesTime = convertLongToTime(totalTime);
            String averageTime = convertLongToTime(totalTime / files.length);

            System.out.println("\n ------------------------ RESULTADOS ------------------------");
            System.out.println("\tTotal de arquivos analisados: " + files.length);
            System.out.println("\tTempo total de execução: " + totalFilesTime);
            System.out.println("\tTempo médio de execução: " + averageTime);
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivos de teste.");
        }
    }

    public static String convertLongToTime(long time) {
        long milliseconds = time / 1000000;
        long seconds = (time / 1000000000) % 60;
        long minutes = (time / 60000000000L) % 60;
        long hours = (time / 3600000000000L) % 24;

        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
    }
}
