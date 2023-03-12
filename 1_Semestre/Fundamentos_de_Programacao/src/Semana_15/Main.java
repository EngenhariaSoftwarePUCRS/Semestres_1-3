package Semana_15;

public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador();

        System.out.println("Subindo");
        while (contador.getValor() < 10) {
            System.out.println(contador.getValor());
            contador.incrementar();
        }

        System.out.println("Descendo");
        while (contador.getValor() > 0) {
            System.out.println(contador.getValor());
            contador.decrementar();
        }
    }
}
