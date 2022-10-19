package Atividade3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
            reWriteFile(file);
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void renumber(File file) throws IOException {
        Scanner reader = new Scanner(file);
        File novo = new File(file.getName().split("\\.")[0].concat("-rn.").concat(file.getName().split("\\.")[1]));
        FileWriter fw = new FileWriter(novo);
        String fileLine, instruction, lineNumber;

        for (int i = 10; reader.hasNextLine(); i+=10) {
            fileLine = reader.nextLine();
            lineNumber = fileLine.split(" ")[0];
            instruction = fileLine.substring(lineNumber.length());
            fw.write("\n" + i + instruction);
        }
        fw.close();
    }
}
