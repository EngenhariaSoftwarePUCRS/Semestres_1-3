import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Util {
    public static int getQuantidadePessoas(File file) {
        int qtdPessoas = 0;

        try {
            Scanner reader = new Scanner(file);
            // Pular cabeçalho
            reader.nextLine();
            while (reader.hasNext()) {
                qtdPessoas++;
                reader.nextLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }

        return qtdPessoas;
    }
}
