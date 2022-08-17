package Aula02;

import java.util.Random;

/*
Objetivo: Introduzir, de forma experimental, a noção de complexidade de algoritmos, e a diferença no comportamento dos diferentes algoritmos que resolvem o mesmo problema.
Se desejar, durante este período, poste dúvidas e soluções no nosso Slack.

Enunciado:
Resolva o exercício dado abaixo.

A) Dado um vetor com números pares e ímpares, escreva um método
                      void separaParImpar(int[] vet);
para colocar todos os números pares à frente no vetor e os ímpares ao final. Escreva o método em duas versões:
 Sem usar outra estrutura de dados auxiliar, faça a movimentação com um único laço;
 Usando um vetor auxiliar, copie todos o pares em uma iteração, depois todos os ímpares, e depois copie todos os valores organizados para o vetor original.
B) Execute ambas as implementações para entradas com a seguinte configuração:
100 elementos, 50 pares e 50 ímpares;
100 elementos, 20 pares e 80 ímpares;
100 elementos, 80 pares e 20 ímpares;
500.000 elementos, 250.000 pares e 250.000 ímpares;
500.000 elementos, 100.000 pares e 400.000 ímpares;
500.000 elementos, 400.000 pares e 100.000 ímpares;
     Para cada execução, coloque um contador para registrar o número de iterações (repetições, laços) de cada implementação, para cada execução.
Ou seja, crie um atributo na classe para contar iterações. A cada vez que a execução do método passar por uma estrutura de repetição (um for, um while, ...)
incremente o contador.    

Ao final da execução destes vários casos de testes, exiba um relatório mostrando os parâmetros da execução e o número de iterações para cada execução./*/

public class Main {

    public static void main(String[] args) {

        LetraA letraA = new LetraA();
        LetraB letraB = new LetraB();

        System.out.println("Repetição 1");
        int[] vetor1 = geraVetor(50, 50);
        letraA.separaParImpar(vetor1);
        System.out.println("Quantidade de repetições letraA: " + letraA.getContador());
        letraB.separaParImpar(vetor1);
        System.out.println("Quantidade de repetições letraB: " + letraB.getContador());
        zerarContadores(letraA, letraB);

        System.out.println("Repetição 2");
        int[] vetor2 = geraVetor(20, 80);
        letraA.separaParImpar(vetor2);
        System.out.println("Quantidade de repetições letraA: " + letraA.getContador());
        letraB.separaParImpar(vetor2);
        System.out.println("Quantidade de repetições letraB: " + letraB.getContador());
        zerarContadores(letraA, letraB);

        System.out.println("Repetição 3");
        int[] vetor3 = geraVetor(80, 20);
        letraA.separaParImpar(vetor3);
        System.out.println("Quantidade de repetições letraA: " + letraA.getContador());
        letraB.separaParImpar(vetor3);
        System.out.println("Quantidade de repetições letraB: " + letraB.getContador());
        zerarContadores(letraA, letraB);

        System.out.println("Repetição 4");
        int[] vetor4 = geraVetor(25000, 25000);
        letraA.separaParImpar(vetor4);
        System.out.println("Quantidade de repetições letraA: " + letraA.getContador());
        letraB.separaParImpar(vetor4);
        System.out.println("Quantidade de repetições letraB: " + letraB.getContador());
        zerarContadores(letraA, letraB);

        System.out.println("Repetição 5");
        int[] vetor5 = geraVetor(10000, 40000);
        letraA.separaParImpar(vetor5);
        System.out.println("Quantidade de repetições letraA: " + letraA.getContador());
        letraB.separaParImpar(vetor5);
        System.out.println("Quantidade de repetições letraB: " + letraB.getContador());
        zerarContadores(letraA, letraB);

        System.out.println("Repetição 6");
        int[] vetor6 = geraVetor(40000, 10000);
        letraA.separaParImpar(vetor6);
        System.out.println("Quantidade de repetições letraA: " + letraA.getContador());
        letraB.separaParImpar(vetor6);
        System.out.println("Quantidade de repetições letraB: " + letraB.getContador());
        zerarContadores(letraA, letraB);
    }

    private static int[] geraVetor(int nroPares, int nroImpares) {
        int[] res = null;
        int contPar = 0, contImpar = 0, novoNum;
        Random rnd = new Random();

        if ((nroPares >= 0) ||
                (nroImpares >= 0) &&
                        (nroPares + nroImpares > 0)) {

            res = new int[nroPares + nroImpares];

            while ((contPar < nroPares) || (contImpar < nroImpares)) {
                novoNum = rnd.nextInt(98) + 1;

                if ((novoNum % 2 == 0) && (contPar < nroPares)) {
                    res[contPar + contImpar] = novoNum;
                    contPar++;
                } else if ((novoNum % 2 == 1) && (contImpar < nroImpares)) {
                    res[contPar + contImpar] = novoNum;
                    contImpar++;
                }
            }
        }

        return res;
    }

    private static void zerarContadores(LetraA letraA, LetraB letraB) {
        letraA.setContador(0);
        letraB.setContador(0);
    }
}