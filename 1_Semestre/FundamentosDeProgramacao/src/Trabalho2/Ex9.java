import java.util.Scanner;
public class Ex9
{
   public static void main(String[] args)
   {
        int altura, largura;
        char caracter;

        Scanner in = new Scanner(System.in);

        System.out.println("Digite a altura");
        altura = in.nextInt();

        System.out.println("Digite a largura");
        largura = in.nextInt();

        System.out.println("Digite o caracter desejado");
        caracter = in.next().charAt(0);
        for(int i = 1; i<=altura; i++) {
            for(int j = 1; j<=largura; j++) {
                    System.out.print(caracter);
            }
            System.out.println();
        }
   }
}