import java.util.Scanner;

public class ExerciciosLoop {
    
    //Escreva um programa que imprime os números de 1 a 10.
    public static void Ex1() {
        System.out.println("Os números de 1 a 10 são: ");
        for(int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }    
    
    //Escreva um programa que calcula o somatórios dos 10 primeiros números naturais.
    public static void Ex2() {
        int soma = 0;
        for(int i = 0; i < 10; i++) {
            soma = soma + i;
        }
        System.out.println("A soma dos 10 primeiros números naturais é: "+soma);
    }
    
    //Escreva um programa que solicita um número inteiro positivo e, em seguida, imprime a tabela da multiplicação daquele número.
    public static void Ex3() {
        int n = 0;
        boolean possible = true;
        
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Digite um número inteiro positivo: ");
            n = input.nextInt();
            
            if (n < 0) {
                System.out.println("Apenas valores positivos. Favor reinicie o programa.");
                possible = false;
            }
            
            if (possible)
                for(int i = 1; i <= 10; i++) {
                    System.out.println(n+"\t x \t"+i+"\t = \t"+n*i);
                }
        } catch (Exception e) {
            System.out.println("Erro: "+e);
            System.out.println("(Apenas números inteiros são aceitos.)");
        }
    }
    
    //Escreva um programa que recebe um valor inteiro positivo e calcula o valor do fatorial deste número.
    public static void Ex4() {
        int n = 0, fatorial = 0;
        boolean possible = true;
        
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Digite um número inteiro positivo: ");
            n = input.nextInt();
            
            if (n < 0) {
                System.out.println("Apenas valores positivos. Favor reinicie o programa.");
                possible = false;
            }
            
            if (possible) {
                fatorial = n;
                for (int i = n - 1; i > 1; i--) {
                    fatorial *= i;
                }
                if (n != 0) {
                    System.out.println(n+"! = "+fatorial);
                } else {
                    System.out.println("0! = 1");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: "+e);
            System.out.println("(Apenas números inteiros são aceitos.)");
        }
    }
    
    //Dois números devem ser lidos do teclado. O programa deve usar o primeiro como base e o segundo como expoente para calcular a exponenciação.
    public static void Ex5() {

    }
    
    //Escreva um programa que solicita do usuário um valor inteiro e depois imprime o valor com os dígitos invertidos. Por exemplo, se o usuário digitar 12345, o programa imprime 54321.
    public static void Ex6() {

    }
    
    //Escreva um programa que solicita uma quantidade n de inteiros e depois lê os n valores inteiros. Na sequência, o programa imprime o somatório dos números pares e o somatório dos números ímpares.
    public static void Ex7() {
        int qtdInteiros, valor, somaPares = 0, somaImpares = 0;
        int[] numeros = {};
        
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Digite a quantidade de números que vai querer escrever: ");
            qtdInteiros = input.nextInt();
            
            while (qtdInteiros > 0) {
                System.out.print("Digite um valor: ");
                valor = input.nextInt();
                
                if (valor % 2 == 0) {
                    somaPares += valor;
                } else {
                    somaImpares += valor;
                }
                
                qtdInteiros --;
            }
            
            System.out.println("A soma dos valores pares é: "+somaPares);
            System.out.println("A soma dos valores impares é: "+somaImpares);
        } catch (Exception e) {
            System.out.println("Erro: "+e);
            System.out.println("(Apenas números inteiros são aceitos.)");
        }
    }
    
    //Escreva um programa que solicita um valor n representando o número de inteiros a serem lidos e então conta quantos destes inteiros são positivos, negativos ou zeros.
    public static void Ex8() {
        int n, valor, qtdPositivos = 0, qtdNegativos = 0, qtdZeros = 0;
        int[] numeros = {};
        
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Digite a quantidade de números que vai querer escrever: ");
            n = input.nextInt();
            
            while (n > 0) {
                System.out.print("Digite um valor: ");
                valor = input.nextInt();
                
                if (valor > 0) {
                    qtdPositivos++;
                } else if (valor < 0) {
                    qtdNegativos++;
                } else {
                    qtdZeros++;
                }
                
                n--;
            }
            
            System.out.printf("Há %d valor(es) positivos. %n",qtdPositivos);
            System.out.printf("Há %d valor(es) negativos. %n",qtdNegativos);
            System.out.printf("Há %d zero(s). %n",qtdZeros);
        } catch (Exception e) {
            System.out.println("Erro: "+e);
            System.out.println("(Apenas números inteiros são aceitos.)");
        }
    }
    public static void Ex9() {

    }
    public static void Ex10() {

    }
    public static void Ex11() {

    }
}
