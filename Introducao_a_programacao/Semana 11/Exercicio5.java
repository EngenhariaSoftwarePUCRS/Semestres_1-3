/**
    5) O que o programa abaixo imprime?
    
    public static int mystery(int n)
    {
        n++;
        n++;
        return n;
    }
    
    public static void main(String[] args)
    {
        int a = 5;
        System.out.println(mystery(a));
    }
 */
public class Exercicio5 {
    private static int mystery(int n)
    {
        n++;
        n++;
        return n;
    }
    
    public static void main()
    {
        int a = 5;
        System.out.println(mystery(a));
    }
}
