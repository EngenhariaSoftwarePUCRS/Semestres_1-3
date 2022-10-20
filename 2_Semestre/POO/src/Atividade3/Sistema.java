package Atividade3;

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
        ArrayList<String> lineNumbers = getLineNumbers(file);
        String[] lines = getLines(file);
        File novo = new File(file.getName().split("\\.")[0].concat("-rn.").concat(file.getName().split("\\.")[1]));
        FileWriter fw = new FileWriter(novo);
        String oldLine;
        String newLine;

        for (int i = lines.length; i > 0; i--) {
            String velha = lineNumbers.get(lineNumbers.size() - 1);
            String nova = Integer.toString(i * 10);
            lineNumbers.remove(lineNumbers.size() - 1);
            for (int j = 0; j < lines.length; j++) {
                oldLine = lines[j];
                newLine = oldLine.replaceAll(velha, nova);
                lines[j] = newLine;
            }
        }
        for (String line : lines)
            fw.write(line + "\n");
        fw.close();
    }

    private ArrayList<String> getLineNumbers(File file) throws IOException {
        Scanner reader = new Scanner(file);
        ArrayList<String> lineNumbers = new ArrayList<>();

        while (reader.hasNext())
            lineNumbers.add(reader.nextLine().split(" ")[0]);

        return lineNumbers;
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
