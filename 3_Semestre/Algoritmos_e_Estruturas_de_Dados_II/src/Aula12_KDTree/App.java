package Aula12_KDTree;

public class App {
    public static void main(String[] args) {
        QuadtreePontos q = new QuadtreePontos();
        q.adicionar("A", 10, 10);
        q.adicionar("B", 70, 60);
        q.adicionar("C", 5, 90);
        q.adicionar("D", 80, 40);

        System.out.println(q);

        System.out.println(q.existe(30, 35));
        System.out.println(q.existe(70, 60));

        q.limpar();
    }
}
