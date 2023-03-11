public class Ex10
{
   public static void main(String[] args)
   {
       int resultado;
       for(int i = 1; i <= 10; i++) {
           for(int j = 1; j <= 10; j++) {
               resultado = j*i; 
               if(resultado > 9) {
                    System.out.print(resultado + " ");
               } else {
                    System.out.print(resultado + "  ");
               }
               
           }
           System.out.println();
       }
   }
}