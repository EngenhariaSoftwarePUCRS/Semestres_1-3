import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ContaLinhasEx1 {
    public static void main(String[] args) throws FileNotFoundException {
    
        final String FILE_PATH = "Exercicios.txt";
        File file = new File(FILE_PATH);
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
