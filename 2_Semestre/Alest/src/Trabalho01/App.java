package Trabalho01;

import java.io.FileNotFoundException;
import java.util.EmptyStackException;

public class App {
    public static void main(String[] args) {
        try {
            Sistema sys = new Sistema();
            sys.inicializar("Trabalho01\\casosTeste\\teste2.txt");
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
        } catch (EmptyStackException ese) {
            System.out.println("Pilha Vazia");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("\nObrigado por utilizar o programa!");
        }
    }
}