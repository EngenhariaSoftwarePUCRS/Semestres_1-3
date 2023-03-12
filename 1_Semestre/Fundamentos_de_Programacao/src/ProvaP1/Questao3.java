package ProvaP1;

public class Questao3 {
    public static void main(String[] args) {
        boolean q = true, w = false;
        int x = 8, y = 3;
        System.out.println("1 - " + um(q, w));
        System.out.println("2 - " + dois(q, w));
        System.out.println("3 - " + tres(q, w));
        System.out.println("4 - " + quatro(x, y));
        System.out.println("5 - " + cinco(x, y));
        System.out.println("6 - " + seis(x, y));
    }

    private static boolean um(boolean q, boolean w) {
        return (!q && w);
    }

    private static boolean dois(boolean q, boolean w) {
        return (q || w && !q);
    }

    private static boolean tres(boolean q, boolean w) {
        return ((q || w) && !q);
    }

    private static boolean quatro(int x, int y) {
        return (x == y);
    }

    private static boolean cinco(int x, int y) {
        return ((x > y) && (y == x - 3));
    }

    private static boolean seis(int x, int y) {
        return ((x > y) || !(x > y && x > 0));
    }
}
