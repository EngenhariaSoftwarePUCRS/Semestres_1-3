package Atividade3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    public void inicializar() {
        Scanner input = new Scanner(System.in);
        String fileName;
        File file;
        
        do {
            System.out.print("Nome do arquivo que deseja ler: ");
            fileName = input.nextLine();
            file = new File(fileName);
            if (!file.exists())
                System.out.println("Arquivo inexistente.\nTente novamente.");
        } while(!file.exists());

        try {
            renumber(file);
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    private void renumber(File file) throws IOException {
        Scanner reader;
        ArrayList<String> lineNumbers = getLineNumbers(file);
        String[] lines = new String[lineNumbers.size()];
        File novo = new File(file.getName().split("\\.")[0].concat("-rn.").concat(file.getName().split("\\.")[1]));
        FileWriter fw = new FileWriter(novo);
        String oldLine, newLine;

        for (int i = 1; i <= lines.length; i++) {
            reader = new Scanner(file);
            String velha = lineNumbers.get(0);
            String nova = Integer.toString(i * 10);
            lineNumbers.remove(0);
            for (int j = 0; reader.hasNext(); j++) {
                oldLine = reader.nextLine();
                newLine = oldLine.replaceAll(velha, nova);
                if (i - 1 == j)
                    lines[j] = newLine;
            }
            fw.write(lines[i - 1] + "\n");
            // System.out.println("Linha "+(i-1)+": "+lines[i - 1]);
        }
        fw.close();
    }

    private ArrayList<String> getLineNumbers(File file) throws IOException {
        Scanner reader = new Scanner(file);
        ArrayList<String> lineNumbers = new ArrayList<>();

        while (reader.hasNext())
            lineNumbers.add(reader.nextLine().split(" ")[0]);

        return lineNumbers;
    }
}
