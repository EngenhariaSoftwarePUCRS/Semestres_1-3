package Semana_16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex05_Populacoes {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(Util.FILE_PATH + "files/populacoes.txt");
        Scanner reader = new Scanner(file);
        int somaPopulacao = 0;

        while (reader.hasNext())
            somaPopulacao += Integer.parseInt(reader.nextLine().split(" ")[1]);

        reader.close();

        System.out.println("A soma das populações dos países é igual a: " + somaPopulacao);

    }
}
