import java.io.File; 
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class Arquivo
{
    public static void main(String args[]) throws FileNotFoundException 
    {
        File arquivo = new File("c:\\temp\\entrada.txt");        
        Scanner leitor = new Scanner(arquivo);
        
        while(leitor.hasNextLine())
        {   
            String linha = leitor.nextLine();
            System.out.println(linha);
        }
        leitor.close();        
    }
}
