public class Ex11
{
   public static void main(String[] args)
   {
       int resultado;
       for(int i = 1; i <= 10; i++) {
           for(int j = 1; j <= 10; j++) {
               resultado = j*i; 
               System.out.print(i + " x " + j + " = " + resultado);
               System.out.println();
           }
           System.out.println();
       }
   }
}