package Trabalho_02.Parte2_LacosAninhados;

public class Ex06_TabelaPotencia {
    public static void main(String[] args) {
        final int NMAX = 5;
        final double XMAX = 5;

        // Imprime o cabeçalho da tabela
        for (int n = 1; n <= NMAX; n++)
            System.out.printf("%10d", n);
        System.out.println();
        for (int n = 1; n <= NMAX; n++)
            System.out.printf("%10s", "x ");
        System.out.println();

        // Imprime a tabela
        System.out.println();
        for (int x = 1; x <= XMAX; x++) {
            for (int n = 1; n <= NMAX; n++) {
                double pow = Math.pow(x, n);
                System.out.printf("%10.0f", pow);
            }
            System.out.println();
        }
    }
}
