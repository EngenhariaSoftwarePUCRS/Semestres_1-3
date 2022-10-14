package Trabalho01;

import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        try {
            Sistema sys = new Sistema();
            sys.inicializar("Trabalho01\\casosTeste\\caso1.txt");
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Obrigado por utilizar o programa!");
        }
    }
}