/*
1) Criar um arquivo ASCII com nomes de pessoas (um em cada linha)
2) Fazer um programa que leia o arquivo e coloque os nomes lidos em um vetor de String.
3) No final imprimir todos os nomes lidos e a quantidade total de nomes.
*/
import java.io.*;
import java.util.Scanner;
public class ExercicioAula {
    public static void main(String[] args) throws FileNotFoundException {
    
        final String FILE_PATH = "Pessoas.txt";
        File file = new File(FILE_PATH);
        Scanner reader = new Scanner(file);
        int lineAmount = 0;
        String[] pessoas = new String[50];
        
        while (reader.hasNextLine()) {
            pessoas[lineAmount] = reader.nextLine();
            lineAmount++;
        }
        reader.close();

        for (String pessoa : pessoas) {
            if (pessoa != null)
                System.out.println(pessoa);
        }
    }
}
