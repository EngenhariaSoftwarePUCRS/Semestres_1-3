package Semana_11;

// 7) O que este método faz:

public class Ex07_Paridade {
    public static void main(String[] args) {
        int n = 5;
        System.out.printf("Imprime a veracidade da paridade de um número. No caso, o número %d ser par é %b.", n,
                mystery(n));
    }

    private static boolean mystery(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
