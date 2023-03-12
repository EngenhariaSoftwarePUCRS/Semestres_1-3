package Semana_16;

import java.io.File;
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;

public class EscreverArquivo {
    public static void main(String args[]) throws FileNotFoundException {
        try {
            File arquivo = new File(Util.FILE_PATH + "files/arquivo.txt");
            if (arquivo.createNewFile())
                System.out.println("Arquivo criado");

            FileWriter myWriter = new FileWriter(Util.FILE_PATH + "files/arquivo.txt");
            myWriter.write("oi....................");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
