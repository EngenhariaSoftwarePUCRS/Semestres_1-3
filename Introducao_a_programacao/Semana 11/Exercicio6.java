/**
    6) Considere o método abaixo cujo objetivo é trocar o conteúdo de duas variáveis inteiras:
    
    public static void falseSwap(int a, int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }
    
    public static void main(String[] args)
    {
        int x = 3;
        int y = 4;
        falseSwap(x, y);
        System.out.println(x + " " + y);
    }
    Por que este método não funciona?
 */
public class Exercicio6 {
    private static void falseSwap(int a, int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }
    
    public static void main()
    {
        int x = 3;
        int y = 4;
        falseSwap(x, y);
        System.out.println(x + " " + y);
        System.out.println("Dá erro pois não atualiza os valores das variáveis x e y.");
    }
}
