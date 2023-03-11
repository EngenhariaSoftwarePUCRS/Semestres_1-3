import java.util.Scanner;
public class Ex3
{
    public static void main(String args[])
    {
        String frase;
        char letra;
        int espacoBranco = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("Digite uma frase: ");
        frase = in.nextLine();

        for(int i = 0; i < frase.length(); i++) {
            letra = frase.charAt(i);
            if(letra == ' ') {
                espacoBranco++;
            }
           
        }
        System.out.println("Existem " + espacoBranco + " espaços em branco");
    }
}