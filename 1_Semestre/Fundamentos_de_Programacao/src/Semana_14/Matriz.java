package Semana_14;

// 1 - Crie um método que imprime uma matriz de inteiros. Você pode reaproveitar este método para testar os métodos a seguir. Use um espaçamento de 5 caracteres para imprimir cada valor da matriz.

// 2- Crie um método que retorna uma matriz n x n de números aleatórios inteiros entre o intervalo fechado [min,max].

// 3- Crie um método que recebe duas matrizes de mesmo tamanho e devolve a matriz com a soma dos respectivos valores de cada matriz.

// 4- Crie um método que recebe duas matrizes de mesmo tamanho e devolve a matriz com a multiplicação das duas matrizes.

// 5- Crie um método que imprime uma matriz de caracteres.

// 6- Crie um método que constrói uma matriz de caracteres de tamanho 80 x 100 onde algumas células possuem o carácter de espaço em branco e outras células possuem o carácter 'x'. A decisão de escolher se a célula é um espaço ou um 'x' deve ser aleatória. Use o método do exercício anterior para verificar a sua resposta.

// 7- Escreva um método que recebe uma matriz de inteiros e devolve o maior elemento.

// 8- Escreva um método que recebe uma matriz de inteiros e um valor inteiro e que determina se o valor inteiro ocorre pelo menos uma vez na matriz.

// 9- Escreva um método que recebe uma matriz de inteiros e um valor inteiro e que determina quantas vezes o valor ocorre na matriz.

// 10 - Escreva um método que recebe uma matriz de inteiros e dois valores inteiro a e b. O método deve substituir toda a ocorrência de a por b na matriz.

public class Matriz {
    public static void main(String[] args) {
        int[][] matriz1 = new int[3][3],
                matriz2 = new int[3][3],
                matriz4 = new int[5][5];
        char[][] matriz3 = new char[80][100];
        preencher(matriz1, 3, 3);
        preencher(matriz2, 5, 5);
        preencher(matriz3);
        preencher(matriz4, 25);

        System.out.println("\n==========Matriz 1===========");
        imprimir(matriz1);

        System.out.println("\n==========Matriz 2===========");
        imprimir(matriz2);

        System.out.println("\n==========Matrizes Somadas===========");
        imprimir(somar(matriz1, matriz2));

        System.out.println("\n==========Matrizes Multiplicadas===========");
        imprimir(multiplicar(matriz1, matriz2));

        // System.out.println("\n==========Matriz 3===========");
        // imprimir(matriz3);

        System.out.println("\n==========Matriz 4===========");
        imprimir(matriz4);

        System.out.println("\n==========Maior elemento da matriz 4===========");
        System.out.println(maior(matriz4));

        System.out.println("\n==========Ocorrencia do numero 5 na matriz 4===========");
        System.out.println(ocorrencia(matriz4, 5));

        System.out.println("\n==========Quantidade de ocorrencias do numero 5 na matriz 4===========");
        System.out.println(ocorrencias(matriz4, 5));

        System.out.println("\n==========Substituindo o numero 5 pelo numero 10 na matriz 4===========");
        substituir(matriz4, 5, 30);
        imprimir(matriz4);
    }

    public static int[][] preencher(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[i].length; j++)
                matriz[i][j] = (int) (Math.random() * 100);

        return matriz;
    }

    public static int[][] preencher(int[][] matriz, int limite) {
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[i].length; j++)
                matriz[i][j] = (int) (Math.random() * limite);

        return matriz;
    }

    public static int[][] preencher(int[][] matriz, int limiteInf, int limiteSup) {
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[i].length; j++)
                matriz[i][j] = (int) Math.floor((Math.random() * (limiteSup - limiteInf + 1)) + limiteInf);

        return matriz;
    }

    public static char[][] preencher(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[i].length; j++)
                matriz[i][j] = (Math.random() < 0.5) ? ' ' : 'x';
        return matriz;
    }

    public static void imprimir(int[][] matriz) {
        for (int i[] : matriz) {
            for (int j : i)
                System.out.print(j + "     ");
            System.out.println();
        }
    }

    public static void imprimir(char[][] matriz) {
        for (char i[] : matriz) {
            for (char j : i)
                System.out.print(j + "     ");
            System.out.println();
        }
    }

    public static int[][] somar(int[][] matriz1, int[][] matriz2) {
        int[][] matriz = new int[matriz1.length][matriz1[0].length];
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[i].length; j++)
                matriz[i][j] = matriz1[i][j] + matriz2[i][j];
        return matriz;
    }

    public static int[][] multiplicar(int[][] matriz1, int[][] matriz2) {
        int[][] matriz = new int[matriz1.length][matriz1[0].length];
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[i].length; j++)
                matriz[i][j] = matriz1[i][j] * matriz2[i][j];
        return matriz;
    }

    public static int maior(int[][] matriz) {
        int maior = matriz[0][0];
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[i].length; j++)
                if (matriz[i][j] > maior)
                    maior = matriz[i][j];
        return maior;
    }

    public static boolean ocorrencia(int[][] matriz, int valor) {
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[i].length; j++)
                if (matriz[i][j] == valor)
                    return true;
        return false;
    }

    public static int ocorrencias(int[][] matriz, int valor) {
        int ocorrencias = 0;
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[i].length; j++)
                if (matriz[i][j] == valor)
                    ocorrencias++;
        return ocorrencias;
    }

    public static int[][] substituir(int[][] matriz, int valor, int substituto) {
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[i].length; j++)
                if (matriz[i][j] == valor)
                    matriz[i][j] = substituto;
        return matriz;
    }
}
