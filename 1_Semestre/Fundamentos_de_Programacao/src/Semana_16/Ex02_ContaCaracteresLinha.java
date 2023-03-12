package Semana_16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex02_ContaCaracteresLinha {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(Util.FILE_PATH + "README.md");
        Scanner reader = new Scanner(file);
        int characterAmount = reader.nextLine().length();
        reader.close();

        System.out.printf("O arquivo possui um total de %d caracteres.", characterAmount);

    }
}
