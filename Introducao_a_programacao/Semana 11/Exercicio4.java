/**
    4) O que o programa abaixo imprime?
    
    public static int mystery(int x)
    {
        int y = x * x;
        return y;
    }
    
    public static void main(String[] args)
    {
        int a = 4;
        System.out.println(mystery(a + 1));
    }
 */
public class Exercicio4 {
    private static int mystery(int x)
    {
        int y = x * x;
        return y;
    }
    
    public static void main()
    {
        int a = 4;
        System.out.println(mystery(a + 1));
    }
}
