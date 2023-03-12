package Semana_16;

import java.io.File;
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex04_EscreverDinamico {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o texto que deseja escrever no arquivo: ");
        String text = input.nextLine();

        System.out.print("Digite a quantidade de linhas que deseja no arquivo: ");
        int lineAmount = input.nextInt();

        try {
            File arquivo = new File(Util.FILE_PATH + "files/saidaRepetida.txt");
            if (arquivo.createNewFile())
                System.out.println("Arquivo criado");

            FileWriter myWriter = new FileWriter(Util.FILE_PATH + "files/saidaRepetida.txt");

            for (int i = 0; i < lineAmount; i++)
                myWriter.write(text + "\n");

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
