/**Esse script imprime 3 grupos de linhas separados por uma linha em branco
 * Sendo que em cada grupo o valor inicial é aumentado em 1, começando no numero 0
 */
public class Ex7
{
   public static void main(String[] args)
   {
        for(int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                System.out.println(i + j);
            }
            System.out.println();
        }
   }
}