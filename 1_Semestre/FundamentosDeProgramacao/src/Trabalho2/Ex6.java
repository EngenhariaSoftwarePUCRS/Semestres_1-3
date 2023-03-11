/** Para fazer essa alteração apenas tive modificar a cons NMAX para o valor de 5 e partir os iteradores do valor 0, assim ele fez de até x elevado a 5, patindo do 0
 * Com isso aumentou uma coluna na exibição
 */
public class Ex6
{
   public static void main(String[] args)
   {
      final int NMAX = 5;
      final double XMAX = 10;

      // Imprime o cabeçalho da tabela
      for (int n = 0; n <= NMAX; n++)
      {
         System.out.printf("%10d", n);
      }
      System.out.println();
      for (int n = 0; n <= NMAX; n++)
      {
         System.out.printf("%10s", "x ");
      }
      System.out.println();

      // Imprime o corpo da tabela

      for (int x = 1; x <= XMAX; x++)
      {
         // Imprime uma linha da tabela

         for (int n = 0; n <= NMAX; n++)
         {
            System.out.printf("%10.0f", Math.pow(x, n));
         }
         System.out.println();
      }
   }
}