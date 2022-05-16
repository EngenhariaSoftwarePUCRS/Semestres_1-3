/**
    1) Escreva cabeçalhos para os seguintes métodos:
    a) Calcula o maior de dois inteiros.
    b) Calcula o menor entre três números em ponto-flutuante.
    c) Determina se um número inteiro é primo, retornando true neste caso e false caso contrário.
    d) Determina se uma string está contida dentro de uma outra string.
    e) Calcula o saldo final de uma conta a partir do saldo inicial, do rendimento anual e da quantidade de anos de investimento.
    g) Gera um número inteiro aleatório entre 1 e n.
 */
import java.util.Scanner;
public class Exercicio1 {
    public static void main() {
        /*a)
            System.out.println(maior(1, 2));
        */
        /*b)
        for (double a = 1; a <= 3; a++) {
            for (double b = 1; b <= 3; b++) {
                for (double c = 1; c <= 3; c++) {
                    System.out.printf("a: %.0f, b: %.0f, c: %.0f %n", a, b, c);
                    System.out.println(menor(a, b, c));
                    System.out.println("-----------------");
                }
            }
        }*/
        /*c)
        Scanner input = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        int n = input.nextInt();
        
        if (n != 0) {
            if (ePrimo(n)) {
                System.out.println(n+" é primo");
            } else {
                System.out.printf("O número (%d) inserido não é primo. %n", n);
            }
        } else {
            do {
                System.out.print("Digite um número inteiro (não nulo): ");
                n = input.nextInt();
            } while (n == 0);
            if (ePrimo(n)) {
                System.out.println(n+" é primo");
            } else {
                System.out.printf("O número (%d) inserido não é primo. %n", n);
            }
        }*/
        /*d)
            System.out.println(primeiraContidaNaSegunda("Primeira", "está contida?"));
        */
    }
    
    private static int maior(int a, int b) {
        if (a >= b)
            return a;
        else
            return b;
    }
    
    private static double menor(double x, double y, double z) {
        if (x <= y && x <= z)
            return x;
        else if (y <= x && y <= z)
            return y;
        else
            return z;
    }
    
    private static boolean ePrimo(int n) {
        boolean divisivelPorUm = true;
        if (divisivelPorUm && divisivelApenasPorEleMesmo(n)) {
            return true;
        } else {
            return false;
        }
    }
    
    private static boolean divisivelApenasPorEleMesmo(int n) {
        int qtdDivisores = 0;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    qtdDivisores++;
                }
            }
        } else {
            for (int j = -1; j >= n; j--) {
                if (n % j == 0) {
                    qtdDivisores++;
                }
            }
        }
        if (qtdDivisores == 2) {
            return true;
        } else {
            return false;
        }
    }
    
    private static boolean primeiraContidaNaSegunda(String primeira, String segunda) {
        if (segunda.contains(primeira))
            return true;
        else
            return false;
    }
    
    private static int inteiroAleatorio () {
        return 5;
    }
    
}
