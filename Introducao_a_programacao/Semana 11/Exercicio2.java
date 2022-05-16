/**
    2) Considere os seguintes métodos:
    
    public static double f(double x)
    { 
        return g(x) + Math.sqrt(h(x)); 
    }
    
    public static double g(double x) 
    {
        return 4 * h(x); 
    }
    
    public static double h(double x) 
    { 
        return x * x + k(x) - 1;
    }
    
    public static double k(double x) 
    {
        return 2 * (x + 1);
    }
    Sem compilar o código e executar as funções, determine o resultado para cada uma das chamadas abaixo:
    a) double x1 = f(2);
    b) double x2 = g(h(2));
    c) double x3 = k(g(2) + h(2));
    d) double x4 = f(0) + f(1) + f(2);
    e) double x5 = f(-1) + g(-1) + h(-1) + k(-1);
*/
public class Exercicio2 {
    private static double f(double x)
    { 
        return g(x) + Math.sqrt(h(x)); 
    }
    
    private static double g(double x) 
    {
        return 4 * h(x); 
    }
    
    private static double h(double x) 
    { 
        return x * x + k(x) - 1;
    }
    
    private static double k(double x) 
    {
        return 2 * (x + 1);
    }
    
    public static void main() {
        System.out.println("a) "+f(2));
        System.out.println("b) "+g(h(2)));
        System.out.println("c) "+k(g(2) + h(2)));
        System.out.println("d) "+f(0) + f(1) + f(2));
        System.out.println("e) "+f(-1) + g(-1) + h(-1) + k(-1));
    }
}
