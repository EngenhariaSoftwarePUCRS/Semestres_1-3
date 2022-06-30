import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PopulacoesEx5 {
    public static void main(String[] args) throws FileNotFoundException {
    
        final String FILE_PATH = "Populacoes.txt";
        File file = new File(FILE_PATH);
        Scanner reader = new Scanner(file);
        int somaPopulacao = 0;
        
        while (reader.hasNext()) {
            reader.nextLine().substring(" ");

            reader.nextLine();
        }
        reader.close();

        System.out.println("A soma das populações dos países é igual a: "+somaPopulacao);

    }

    
}
