import java.util.Scanner;
public class Ex12
{
   public static void main(String[] args)
   {
       int total;
       Scanner in = new Scanner(System.in);

       System.out.println("Digite um numero");
       total = in.nextInt();

       for(int i = 1; i <= total; i++) {
           for(int j = 1; j <= i; j++) {
                if(i > 9) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + "  ");
                }
           }
           System.out.println();
       }
   }
}