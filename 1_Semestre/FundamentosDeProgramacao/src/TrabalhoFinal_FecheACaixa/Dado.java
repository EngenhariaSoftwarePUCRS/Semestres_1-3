import java.util.Random;

public class Dado {
    private int[] lados;

    public Dado() {
        lados = new int[6];
    }

    public Dado(int qtdLados) {
        if (qtdLados <= 0) {
            qtdLados = 6;
        }
        lados = new int[qtdLados];
    }

    public int sortearLado() {
        Random r = new Random();
        return r.nextInt(lados.length) + 1;
    }
}
