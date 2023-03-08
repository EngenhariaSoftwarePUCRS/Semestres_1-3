import java.util.Scanner;

public class ExerciciosFor {
    
    //Escreva o laço do programa InvestmentTable.java usando um laço while.
    public static void Ex1() {
        int year = 1;
        final double RATE = 5;
        final double INITIAL_BALANCE = 10000;
        double balance = INITIAL_BALANCE;

        System.out.print("Enter number of years: ");
        Scanner in = new Scanner(System.in);
        int nyears = in.nextInt();
      
        while (year <= nyears) {
            double interest = balance * RATE / 100;
            balance = balance + interest;
            System.out.printf("%4d %10.2f\n", year, balance);
            year++;
        }
    }
    
    //Quantos números o laço abaixo imprime?
    public static void Ex2() {
        int qtdNumeros = 0;
        
        for (int n = 10; n >= 0; n--) {
            System.out.println(n);
            qtdNumeros++;
        }
        
        System.out.printf("O laço imprime %d números.",qtdNumeros);
    }
    
    //Escreva um laço for que imprima todos os números pares entre 10 e 20 (inclusive).
    public static void Ex3() {
        for (int i = 10; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
    
    //Escreva um laço for que computa a soma de todos os números inteiros entre 1 e n.
    public static void Ex4() {
        int n, soma = 0;
        
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Escreva um número inteiro: ");
            n = input.nextInt();
            
            if (n > 0) {
                for (int i = 0; i <= n; i++) {
                    soma += i;
                }
            } else {
                for (int i = 0; i >= n; i--) {
                    soma += i;
                }
            }
            
            System.out.printf("A soma dos números inteiros até %d é: %d ", n, soma);
        } catch (Exception e) {
            System.out.println("Apenas números inteiros. Favor reiniciar o programa.");
            System.out.println("Erro: "+e);
        }
    }
    
    //Como você poderia modificar o laço for do programa InvestmentTable.java para que ele imprima todos os saldos até que o valor tenha dobrado?
    public static void Ex5() {
        final double RATE = 5;
        final double INITIAL_BALANCE = 10000;
        double balance = INITIAL_BALANCE;
        final double META = 2*INITIAL_BALANCE;
        int nyears = 0, i = 1;
      
        while (balance <= META) {
            double interest = balance * RATE / 100;
            System.out.printf("O balanço do ano %d é equivalente a: %.2f%n", nyears, balance);
            balance += interest;
            nyears = i;
            i++;
        }
        
        System.out.printf("Foram necessários %d anos para duplicar o investimento.%n", nyears);
    }
    
    //O que estes laços imprimem na tela?
    public static void Ex6() {
        System.out.print("a. ");
        for (int i = 1; i < 10; i++) { System.out.print(i + " "); }
        System.out.print("\nb. ");
        for (int i = 1; i < 10; i += 2) { System.out.print(i + " "); }
        System.out.print("\nc. ");
        for (int i = 10; i > 1; i--) { System.out.print(i + " "); }
        System.out.print("\nd. ");
        for (int i = 0; i < 10; i++) { System.out.print(i + " "); }
        System.out.print("\ne. ");
        for (int i = 1; i < 10; i = i * 2) { System.out.print(i + " "); }
        System.out.print("\nf. ");
        for (int i = 1; i < 10; i++) { if (i % 2 == 0) { System.out.print(i + " "); } }
    }
    
    //Escreva um programa que lê um palavra e a imprime na tela um caractere por linha.
    public static void Ex7() {
        String palavra;
        int qtdLetras;
        
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Escreva uma palavra: ");
            palavra = input.nextLine();
            qtdLetras = palavra.length();
                        
            for (int i = 0; i < qtdLetras; i++) {
                System.out.println(palavra.charAt(i));
            }
        } catch (Exception e) {
            System.out.println("Erro: "+e);
        }
    }
    
    //Escreva um programa que imprime os valores de 2^0, 2^1, 2^2 até 2^20.
    public static void Ex8() {
        for (int i = 0; i <= 20; i++) {
            System.out.println(Math.pow(2, i));
        }
    }
}
