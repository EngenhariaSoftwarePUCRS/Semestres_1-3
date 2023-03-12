package Semana_16;

import java.io.*;
import java.util.Scanner;

public class Ex06_Pessoas {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(Util.FILE_PATH + "files/Pessoas.txt");
        Scanner reader = new Scanner(file);
        int lineAmount = 0;
        String[] pessoas = new String[50];

        while (reader.hasNextLine()) {
            pessoas[lineAmount] = reader.nextLine();
            lineAmount++;
        }
        reader.close();

        for (String pessoa : pessoas)
            if (pessoa != null)
                System.out.println(pessoa);
    }
}
