public class Questao4 {
    public static void a() {
        double a;
        double b;
        a = 9;
        b = 2;
        if (a > 0) {
            a = a + 2;
        }
        a = a + 4;
        b = a / b;
        b = b * 2;
        System.out.println(b);
    }
    public static void b() {
        double a;
        double b;
        a = 9;
        b = 2;
        if (a > 0) {
            a = a + 2;
        }
        a = a + 4;
        b = a / b;
        b = b * 2;
        System.out.println(a);
    }
    public static void c() {
        int a;
        int b;
        a = 9;
        b = 2;
        if (a > 0) {
            a = a + 2;
        }
        a = a + 4;
        b = a / b;
        b = b * 2;
        System.out.println(b);
    }
    public static void d() {
        /*final */double a/* = 9*//*erro, pois não é possível alterar o valor de um final, qe é constante.*/;
        double b;
        a = 9;
        b = 2;
        if (a > 0) {
            a = a + 2;
        }
        a = a + 4;
        b = a / b;
        b = b * 2;
        System.out.println(b);
    }
}
