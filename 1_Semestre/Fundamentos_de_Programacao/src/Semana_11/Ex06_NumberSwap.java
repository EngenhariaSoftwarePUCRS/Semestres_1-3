package Semana_11;

// 6) Considere o método abaixo cujo objetivo é trocar o conteúdo de duas variáveis inteiras:
// Por que este método não funciona?

public class Ex06_NumberSwap {
    private static void falseSwap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        falseSwap(x, y);
        System.out.println(x + " " + y);
        System.out.println("Dá erro pois não atualiza os valores das variáveis x e y.");
    }
}
