package Atividade03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    public void inicializar() {
        try {
            renumber(getFile());
            System.out.println("Arquivo salvo com sucesso!");
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    private File getFile() {
        Scanner input = new Scanner(System.in);
        String fileName;
        File file;

        System.out.print("Nome do arquivo que deseja ler: ");
        fileName = input.nextLine();
        file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Arquivo inexistente.\nTente novamente.");
            return getFile();
        }

        return file;
    }

    void renumber(File file) throws IOException {
        String[] lines = getLines(file);
        File novo = new File("src/Atividade03/"
                + file.getName().split("\\.")[0].concat("-rn.").concat(file.getName().split("\\.")[1]));
        FileWriter fw = new FileWriter(novo);
        String oldLine;
        String newLine;

        for (int i = lines.length; i > 0; i--) {
            String velha = lines[i - 1].split(" ")[0];
            String nova = Integer.toString(i * 10);
            for (int j = 0; j < lines.length; j++) {
                oldLine = lines[j];
                newLine = replaceAll(oldLine, velha, nova);
                lines[j] = newLine;
            }
        }
        for (String line : lines)
            fw.write(line + "\n");
        fw.close();
    }

    private String replaceAll(String oldLine, String velha, String nova) {
        String[] palavras = oldLine.split(" ");
        String newLine = "";

        for (int i = 0; i < palavras.length; i++) {
            if (palavras[i].equals(velha))
                palavras[i] = nova;
            newLine += palavras[i] + " ";
        }

        return newLine.trim();
    }

    private int getLineAmount(File file) throws IOException {
        Scanner reader = new Scanner(file);
        int lineAmount = 0;

        while (reader.hasNext()) {
            lineAmount++;
            reader.nextLine();
        }

        return lineAmount;
    }

    private String[] getLines(File file) throws IOException {
        Scanner reader = new Scanner(file);
        String[] lines = new String[getLineAmount(file)];

        for (int i = 0; i < lines.length; i++)
            lines[i] = reader.nextLine();

        return lines;
    }
}
