package Semana_16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex01_ContaLinhas {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(Util.FILE_PATH + "README.md");
        Scanner reader = new Scanner(file);
        int lineAmount = 0;

        while (reader.hasNextLine()) {
            reader.nextLine();
            lineAmount++;
        }
        reader.close();

        System.out.printf("O arquivo possui um total de %d linhas.", lineAmount);

    }
}
