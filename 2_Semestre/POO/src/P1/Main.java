package P1;

public class Main {
    public static void main(String[] args) {
        questao01();
    }

    public static void questao01() {
        Encomenda enc[] = new Encomenda[4];

        enc[0] = new EncomendaSimples(0, "Xis", "Pequeno", 0.5);
        enc[1] = new Encomenda(1, "Pizza", "Medio", 2.0);
        enc[2] = new EncomendaClassificada(2, "Pizza", "Medio", 2.0);
        enc[3] = new EncomendaClassificada(3, "Mercado", "Grandes", 10.0);

        for (int i = 0; i < 4; i++) {
            System.out.println(enc[i].getCodigo());
        }
    }
}