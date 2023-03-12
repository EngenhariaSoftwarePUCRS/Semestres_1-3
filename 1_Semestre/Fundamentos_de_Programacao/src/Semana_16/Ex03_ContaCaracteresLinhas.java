package Semana_16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex03_ContaCaracteresLinhas {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(Util.FILE_PATH + "README.md");
        Scanner reader = new Scanner(file);
        int characterAmount = 0;

        while (reader.hasNextLine())
            characterAmount += reader.nextLine().length();

        reader.close();

        System.out.printf("O arquivo possui um total de %d caracteres.", characterAmount);

    }
}
