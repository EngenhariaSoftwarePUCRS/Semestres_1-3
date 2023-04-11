package Trabalho01;

import java.io.File;
import java.io.FileWriter;

public class AppTest {
    public static void main(String[] args) {
        try {
            String filesPath = args.length > 0 ? args[0]
                    : "src/Trabalho01/casosTeste";
            String outputFilePath = args.length > 1 ? args[1]
                    : "src/Trabalho01/resultados.txt";
            File[] files = new File(filesPath).listFiles();
            FileWriter fileWriter = new FileWriter(outputFilePath);
            long totalTime = 0;
            String fileReadTimeOutput = "Tempo decorrido para analisar o arquivo: 0s";

            for (File file : files) {
                String fileName = file.getName();
                System.out.print("\nAnalisando arquivo: " + fileName);

                long startTime = System.nanoTime();
                Monkey winner = new JungleGame(file).play();
                long endTime = System.nanoTime();
                long fileTime = endTime - startTime;

                fileReadTimeOutput = String.format("Tempo decorrido para analisar o arquivo \"%s\": %s",
                        fileName, Util.convertLongToTime(fileTime));
                String winnerMonkey = String.format("Vencedor: Macaco %d - %d cocos.",
                        winner.getId(), winner.getCoconuts());

                fileWriter.write(fileReadTimeOutput + "\n");
                fileWriter.write("\t" + winnerMonkey + "\n");
                System.out.println(fileReadTimeOutput);

                totalTime += fileTime;
            }

            String totalFilesTime = Util.convertLongToTime(totalTime);
            String averageTime = Util.convertLongToTime(totalTime / files.length);

            String titleOutput = "------------------------ RESULTADOS ------------------------";
            String totalFilesOutput = "Total de arquivos analisados: " + files.length;
            String totalFilesTimeOutput = "Tempo total de execução: " + totalFilesTime;
            String averageTimeOutput = "Tempo médio de execução: " + averageTime;

            fileWriter.write(titleOutput + "\n");
            fileWriter.write(totalFilesOutput + "\n");
            fileWriter.write(totalFilesTimeOutput + "\n");
            fileWriter.write(averageTimeOutput + "\n");

            System.out.println("\n " + titleOutput);
            System.out.println("\t" + totalFilesOutput);
            System.out.println("\t" + totalFilesTimeOutput);
            System.out.println("\t" + averageTimeOutput);

            System.out.println("Resumo das informações disponíveis em: " + outputFilePath);

            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivos de teste.");
        }
    }
}
