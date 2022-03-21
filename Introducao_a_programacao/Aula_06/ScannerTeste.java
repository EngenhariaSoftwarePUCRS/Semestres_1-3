import java.util.Scanner;

public class ScannerTeste {
    public static void main(String args[]) {
        int valor;
        
        Scanner teclado = new Scanner(System.in);
        
        int teste = teclado.nextInt();
        
        System.out.println(teste);
    }
}