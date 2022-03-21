import java.util.Scanner;
public class CalculadoraDeDescontos {
    public static void main() {
        Scanner input = new Scanner(System.in);
        
        int numLocacoes;
        int numNovosClientes;
        double desconto;
        
        System.out.println("Digite o número de locações: ");
        numLocacoes = input.nextInt();
        
        System.out.println("Digite o número de novos clientes: ");
        numNovosClientes = input.nextInt();
        
        desconto = numLocacoes + numNovosClientes;
        
        System.out.printf("Seu desconto é de: %.2f", desconto);
    }
}