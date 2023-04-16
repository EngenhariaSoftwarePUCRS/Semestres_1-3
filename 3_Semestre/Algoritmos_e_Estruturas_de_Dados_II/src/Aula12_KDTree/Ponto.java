package Aula12_KDTree;

public class Ponto {
    public String rotulo;
    public int x;
    public int y;

    public Ponto(String rotulo, int x, int y) {
        this.rotulo = rotulo;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return rotulo + "(" + x + "," + y + ")";
    }

}
