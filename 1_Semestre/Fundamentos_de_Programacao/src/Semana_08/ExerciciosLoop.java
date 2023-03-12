package Semana_08;

import java.util.Scanner;

public class ExerciciosLoop {

    // Escreva um programa que imprime os números de 1 a 10.
    public static void Ex1() {
        System.out.println("Os números de 1 a 10 são: ");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }

    // Escreva um programa que calcula o somatórios dos 10 primeiros números
    // naturais.
    public static void Ex2() {
        int soma = 0;
        for (int i = 0; i < 10; i++) {
            soma = soma + i;
        }
        System.out.println("A soma dos 10 primeiros números naturais é: " + soma);
    }

    // Escreva um programa que solicita um número inteiro positivo e, em seguida,
    // imprime a tabela da multiplicação daquele número.
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
                for (int i = 1; i <= 10; i++) {
                    System.out.println(n + "\t x \t" + i + "\t = \t" + n * i);
                }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            System.out.println("(Apenas números inteiros são aceitos.)");
        }
    }

    // Escreva um programa que recebe um valor inteiro positivo e calcula o valor do
    // fatorial deste número.
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
                    System.out.println(n + "! = " + fatorial);
                } else {
                    System.out.println("0! = 1");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            System.out.println("(Apenas números inteiros são aceitos.)");
        }
    }

    // Dois números devem ser lidos do teclado. O programa deve usar o primeiro como
    // base e o segundo como expoente para calcular a exponenciação.
    public static void Ex5() {
        int base, expoente, produto = 1, produtoC;

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Escreva a base: ");
            base = input.nextInt();
            System.out.print("Escreva o expoente: ");
            expoente = input.nextInt();

            for (int i = 0; i < expoente; i++) {
                produto *= base;
            }

            if (testing(base, expoente)) {
                System.out.printf("O produto de %d elevado na %d é: %d %n", base, expoente, produto);
            } else {
                System.out.println("Então... \n\tera " + Math.pow(base, expoente));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

    private static boolean testing(int base, int expoente) {
        int produto = 1,
                produtoC = (int) Math.pow(base, expoente);

        for (int i = 0; i < expoente; i++) {
            produto *= base;
        }

        if (produto == produtoC) {
            return true;
        } else {
            return false;
        }
    }

    // Escreva um programa que solicita do usuário um valor inteiro e depois imprime
    // o valor com os dígitos invertidos.
    public static void Ex6() {
        String numero;
        int qtdDigitos;

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Escreva um número: ");
            numero = input.nextLine();
            qtdDigitos = numero.length();

            for (int i = qtdDigitos - 1; i >= 0; i--) {
                System.out.print(numero.charAt(i));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

    // Escreva um programa que solicita uma quantidade n de inteiros e depois lê os
    // n valores inteiros. Na sequência, o programa imprime o somatório dos números
    // pares e o somatório dos números ímpares.
    public static void Ex7() {
        int qtdInteiros, valor, somaPares = 0, somaImpares = 0;
        int[] numeros = {};

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Digite a quantidade de números que vai querer escrever: ");
            qtdInteiros = input.nextInt();

            while (qtdInteiros > 0) {
                System.out.printf("Digite o %dº valor: ", qtdInteiros);
                valor = input.nextInt();

                if (valor % 2 == 0) {
                    somaPares += valor;
                } else {
                    somaImpares += valor;
                }

                qtdInteiros--;
            }

            System.out.println("A soma dos valores pares é: " + somaPares);
            System.out.println("A soma dos valores impares é: " + somaImpares);
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            System.out.println("(Apenas números inteiros são aceitos.)");
        }
    }

    // Escreva um programa que solicita um valor n representando o número de
    // inteiros a serem lidos e então conta quantos destes inteiros são positivos,
    // negativos ou zeros.
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

            System.out.printf("Há %d valor(es) positivos. %n", qtdPositivos);
            System.out.printf("Há %d valor(es) negativos. %n", qtdNegativos);
            System.out.printf("Há %d zero(s). %n", qtdZeros);
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            System.out.println("(Apenas números inteiros são aceitos.)");
        }
    }

    // Escreva um programa que solicita um valor n representando o número de
    // inteiros a serem lidos e então imprime o maior e o menor.
    public static void Ex9() {
        int valor,
                qtdInteiros,
                menor = Integer.MAX_VALUE,
                maior = Integer.MIN_VALUE;

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Digite a quantidade de números que vai querer escrever: ");
            qtdInteiros = input.nextInt();

            while (qtdInteiros > 0) {
                System.out.print("Digite um valor: ");
                valor = input.nextInt();

                if (valor > maior) {
                    maior = valor;
                }
                if (valor < menor) {
                    menor = valor;
                }

                qtdInteiros--;
            }

            System.out.println("O maior valor digitado foi: " + maior);
            System.out.println("O menor valor digitado foi: " + menor);
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            System.out.println("(Apenas números inteiros são aceitos.)");
        }
    }

    // Escreva um programa que solicita ao usuário um número inteiro e então imprime
    // uma mensagem indicando que o número digitado é um valor primo ou não.
    public static void Ex10() {
        int n;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Digite um número inteiro: ");
            n = input.nextInt();

            if (n != 0) {
                if (ePrimo(n)) {
                    System.out.println(n + " é primo");
                } else {
                    System.out.printf("O número (%d) inserido não é primo. %n", n);
                }
            } else {
                do {
                    System.out.print("Digite um número inteiro (não nulo): ");
                    n = input.nextInt();
                } while (n == 0);
                if (ePrimo(n)) {
                    System.out.println(n + " é primo");
                } else {
                    System.out.printf("O número (%d) inserido não é primo. %n", n);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            System.out.println("(Apenas números inteiros são aceitos.)");
        }
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

    // Faça um programa que some todos os números ímpares de a até b (inclusive)
    // sendo que a e b são lidos do teclado.
    public static void Ex11() {
        int a, b, soma;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Digite um número inteiro: ");
            a = input.nextInt();
            System.out.print("Digite outro número inteiro: ");
            b = input.nextInt();
            soma = somaImpares(a, b);

            System.out.printf("A soma entre os ímpares inteiros de %d a %d é: %d %n", a, b, soma);
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            System.out.println("(Apenas números inteiros são aceitos.)");
        }
    }

    private static int somaImpares(int a, int b) {
        int soma = 0, fatorSoma = a, limite = b;

        if (a == b) {
            if (a % 2 != 0) {
                soma = a;
            }
        } else {
            if (a > b) {
                limite = a;
                fatorSoma = b;
            }
            while (fatorSoma <= limite) {
                if (fatorSoma % 2 != 0) {
                    soma += fatorSoma;
                }
                fatorSoma++;
            }
        }

        return soma;
    }
}
