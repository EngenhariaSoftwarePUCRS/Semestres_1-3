package Semana07;

public class Main {
    public static void main(String[] args) {
        ColecaoEncadeada lst = new ColecaoEncadeada();

        System.out.println("Primeira");
        for (int i = 50; i >= 10; i -= 10) {
            lst.addFirst(Integer.toString(i));
            System.out.println(lst);
        }

        lst.get(2);
    }
}
