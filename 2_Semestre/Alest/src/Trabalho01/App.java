package Trabalho01;

import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        try {
            Sistema sys = new Sistema();
            sys.inicializar("calculos.txt");
        } catch (FileNotFoundException fnfe) {
            System.out.println("Não conseguimos encontrar seu arquivo, favor reiniciar o sistema e tentar novamente.");
        } finally {
            System.out.println("Obrigado por utilizar o programa!");
        }
    }
}