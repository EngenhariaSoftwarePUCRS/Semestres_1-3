import java.util.Scanner;
public class ex1 {
    public static void main() {
        int valorLido = 1;
        try (Scanner input = new Scanner(System.in)) {
            while (valorLido != 0) {
                System.out.println("Escreva um número: ");
                valorLido = input.nextInt();
            }
            System.out.println("Programa encerrado.");
        } catch (Exception e) {
            System.out.println("Erro: "+e);
        }
    }
}