import java.util.Scanner;

/**
   This program prints a table showing the growth of an investment.
*/
public class InvestmentTable
{
   public static void main(String[] args)
   {  
      final double RATE = 5;
      final double INITIAL_BALANCE = 10000;
      double balance = INITIAL_BALANCE;

      System.out.print("Enter number of years: ");
      Scanner in = new Scanner(System.in);
      int nyears = in.nextInt();
      
      // Print the table of balances for each year

      for (int year = 1; year <= nyears; year++)
      {
         double interest = balance * RATE / 100;
         balance = balance + interest;
         System.out.printf("%4d %10.2f\n", year, balance);
      }
   }
}

Parte 1 - Exercícios utilizando o WHILE
1. Quantos anos são necessários para que o investimento triplique o valor inicial?
2. Se o rendimento for 10% ao ano, quantos anos serão necessários para que o balanço duplique? O que é necessário mudar no programa?
3. Modifique o programa para que o mesmo imprima o balanço ao final de cada ano. O que você precisou alterar?
4. Suponha que a condição de parada do laço while seja
while (balanco <= META)
Qual o efeito desta alteração? Por quê?
5. O que o programa abaixo imprime?
int n = 1;
while (n < 100)
{
    n = 2 * n;
    System.out.print(n + " ");
}
6. Escreva um laço while que imprime:
    a. Todos os quadrados menores que n. Por exemplo, se n for 100, o programa imprime 0 1 4 9 16 25 36 49 64 81.
    b. Todos inteiros positivos que sejam divisíveis por 10 e menores que n. Por exemplo, se n for 100, o programa imprime 10 20 30 40 50 60 70 80 90
   c. Todas as potências de 2 menores que n. Por exemplo, se n for 100, o programa imprime 1 2 4 8 16 32 64
7. O que é um laço infinito? Como você pode encerrar em seu programa um programa que entrou em laço infinito?
8. Escreva um programa que lê do teclado um número inteiro e faz uma contagem regressiva deste número simulando o lançamento de um foguete. Por exemplo, se o usuário digitar 5, o programa imprime a cada linha:
Faltam 5 segundos.
Faltam 4 segundos.
Faltam 3 segundos.
Faltam 2 segundos.
Falta 1 segundo.
9. Adapte o programa DuplicaInvestimento para que ele solicite ao usuário o valor do saldo inicial, o rendimento anual e o saldo final desejado.


 
Part 2 - Exercícios utilizando o FOR
1. Escreva o laço do programa InvestmentTable.java usando um laço while.
2. Quantos números o laço abaixo imprime?
for (int n = 10; n >= 0; n--)
{
    System.out.println(n);
}
3. Escreva um laço for que imprima todos os números pares entre 10 e 20 (inclusive).
4. Escreva um laço for que computa a soma de todos os números inteiros entre 1 e n. (n deve ser lido do teclado)
5.Como você poderia modificar o laço for do programa InvestmentTable.java para que ele imprima todos os saldos até que o valor tenha dobrado?
6. O que estes laços imprimem na tela?
a. for (int i = 1; i < 10; i++) { System.out.print(i + " "); }
b. for (int i = 1; i < 10; i += 2) { System.out.print(i + " "); }
c. for (int i = 10; i > 1; i--) { System.out.print(i + " "); }
d. for (int i = 0; i < 10; i++) { System.out.print(i + " "); }
e. for (int i = 1; i < 10; i = i * 2) { System.out.print(i + " "); }
f. for (int i = 1; i < 10; i++) { if (i % 2 == 0) { System.out.print(i + " "); } }
7. Escreva um programa que lê um palavra e a imprime na tela um caractere por linha. Por exemplo, se o usuário digitar 'Ronaldo', o programa imprime:
R
o
n
a
l
d
o
8. Escreva um programa que imprime os valores de 20, 21, 22 até 220.

 
Parte 3 - Exercícios Adicionais (usar while ou for)
1. Escreva um programa que imprime os números de 1 a 10.
2. Escreva um programa que calcula o somatórios dos 10 primeiros números naturais.
3. Escreva um programa que solicita um número inteiro positivo e, em seguida, imprime a tabela da multiplicação daquele número. Por exemplo, se o usuário digitar 3, o programa imprime:
Digite um valor: 3
3 x 1 = 3
3 x 2 = 6
3 x 3 = 9
3 x 4 = 12
3 x 5 = 15
3 x 6 = 18
3 x 7 = 21
3 x 8 = 24
3 x 9 = 27
3 x 10 = 30
4. Escreva um programa que recebe um valor inteiro positivo e calcula o valor do fatorial deste número.
5. Dois números devem ser lidos do teclado. O programa deve usar o primeiro como base e o segundo como expoente para calcular a exponenciação. Não use o método pronto Math.pow().
6. Escreva um programa que solicita do usuário um valor inteiro e depois imprime o valor com os dígitos invertidos. Por exemplo, se o usuário digitar 12345, o programa imprime 54321.
7. Escreva um programa que solicita uma quantidade n de inteiros e depois lê os n valores inteiros. Na sequência, o programa imprime o somatório dos números pares e o somatório dos números ímpares. Por exemplo:
Digite a quantidade de valores: 4
Digite o valor 1: 23
Digite o valor 2: 3
Digite o valor 3: 2
Digite o valor 4: 4
O somatório dos números pares é 6.
O somatório dos números ímpares é 26.
8. Escreva um programa que solicita um valor n representando o número de inteiros a serem lidos e então conta quantos destes inteiros são positivos, negativos ou zeros.
9. Escreva um programa que solicita um valor n representando o número de inteiros a serem lidos e então imprime o maior e o menor. Por exemplo:
Digite a quantidade de valores: 4
Digite o valor 1: 23
Digite o valor 2: 3
Digite o valor 3: -1
Digite o valor 4: 4
O maior valor é 23 e o menor valor é -1.
10. Escreva um programa que solicita ao usuário um número inteiro e então imprime uma mensagem indicando que o número digitado é um valor primo ou não.
11. Faça um programa que some todos os números ímpares de a até b (inclusive) sendo que a e b são lidos do teclado.