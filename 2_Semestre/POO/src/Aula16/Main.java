package Aula16;

import java.io.FileNotFoundException;

import Aula16.Material_Apoio.ContaCorrente;

public class Main {
    public static void main(String[] args) throws Exception {
        ContaCorrente cc = new ContaCorrente(-15);
        System.out.println(cc);
        System.out.println("Contador Instancias: " + cc.getContadorInstancias());
        System.out.println("Contador Tentativas: " + cc.getContadorTentativas());
    }

    private static void exemplo1() {
        try {
            int i = getAlgo();
        } catch (IndexOutOfBoundsException e1) {
            System.out.println("Exceção 1");
        } catch (Exception e2) {
            System.out.println("Exceção 2");
        } finally {
            System.out.println("Mais nada");
        }
        System.out.println("Adeus");
    }

    private static int getAlgo() throws FileNotFoundException {
        throw new FileNotFoundException();
    }
}
