/*1 - Crie um método que imprime uma matriz de inteiros. Você pode reaproveitar este método para testar os métodos a seguir. Use um espaçamento de 5 caracteres para imprimir cada valor da matriz.

public static void imprimeMatrizInt(int[][] matriz)*/

public class Ex1 {
    public static void main(String[] args) {
        int[][] matriz = new int[3][3];
        imprimeMatrizInt(matriz);
        matriz[0][0] = 00;
        matriz[0][1] = 01;
        matriz[0][2] = 02;
        matriz[1][0] = 10;
        matriz[1][1] = 11;
        matriz[1][2] = 12;
        matriz[2][0] = 20;
        matriz[2][1] = 21;
        matriz[2][2] = 22;
    }

    public static void imprimeMatrizInt(int[][] matriz) {
        for (int i[] : matriz) {
            for (int j : i) {
                System.out.println(j);
            }
        }
    }
}