package ProvaP1;

public class Questao2 {
    public static void main(String[] args) {
        int x = 5, y = 2;
        System.out.println("1 - " + um(x, y));
        System.out.println("2 - " + dois(x, y));
        System.out.println("3 - " + tres(x));
        System.out.println("4 - " + quatro(x, y));
        System.out.println("5 - " + cinco(x));
        System.out.println("6 - " + seis(x));
    }

    private static int um(int x, int y) {
        return (x / y);
    }

    private static int dois(int x, int y) {
        return (x % y);
    }

    private static int tres(int x) {
        return (x++);
    }

    private static double quatro(int x, int y) {
        return (x / (double) y);
    }

    private static int cinco(int x) {
        return (x *= 3);
    }

    private static double seis(int x) {
        return (Math.pow(x, 3) * 2);
    }
}
