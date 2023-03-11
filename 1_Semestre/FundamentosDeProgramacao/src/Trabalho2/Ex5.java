import java.util.Scanner;
public class Ex5
{
    public static void main(String args[])
    {
        String palavra;
        char letra;
        int vogais = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("Digite uma palavra: ");
        palavra = in.nextLine();

        for(int i = 0; i < palavra.length(); i++) {
            palavra = palavra.toLowerCase();
            letra = palavra.charAt(i);
            if(letra == 'a' || letra == 'e' || letra == 'i' || letra =='o' || letra == 'u') {
                vogais++;
            }
           
        }
        System.out.println(vogais + " vogais");
    }
}