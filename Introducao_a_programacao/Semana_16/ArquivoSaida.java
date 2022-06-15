import java.io.File; 
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class ArquivoSaida
{
    public static void main(String args[]) throws FileNotFoundException 
    {
        try
        {
            File arquivo = new File("c:\\temp\\saida.txt");        
            if(arquivo.createNewFile())
            {
                System.out.println("Arquivo criado");
            }
            FileWriter myWriter = new FileWriter("c:\\temp\\saida.txt");
            myWriter.write("oi....................");
            myWriter.close();        
        } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
        }
        
    }
}
