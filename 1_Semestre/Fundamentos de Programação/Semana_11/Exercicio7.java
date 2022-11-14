/**
    7) O que este método faz:
    
    public static boolean mystery(int n)
    {
        if (n % 2 == 0)
        {
            return true; 
        }
        else
        {
            return false; 
        }
    }
 */
public class Exercicio7 {
    public static void main() {
        System.out.print(mystery(5));
        //Imprime a veracidade da paridade de um número. No caso, o número 5.
    }
    
    private static boolean mystery(int n)
    {
        if (n % 2 == 0)
        {
            return true; 
        }
        else
        {
            return false; 
        }
    }
}
