import java.util.Scanner;
public class lojinha {
    public static void main() {
        Scanner input = new Scanner(System.in);
        
        double precoLivro = 0;
        int quantidadeLivros = 0;
        double impostos = 0.15;
        int frete;
        double precoFinal;
        double precoTotal = 0;
        int continuar = 1;
        
        while (continuar != 0) {
            System.out.println("\nDigite o preço do livro: ");
            precoLivro = input.nextDouble();
            
            System.out.println("Digite a quantidade do livro: ");
            quantidadeLivros = input.nextInt();
            
            if ((continuar != 0) || (continuar != 1)) {
                System.out.println("Deseja continuar? (0 | 1)");
                continuar = input.nextInt();
            }
        
            frete = 10*quantidadeLivros;
            precoFinal = precoLivro * quantidadeLivros + impostos * quantidadeLivros + frete;
            precoTotal = precoTotal + precoFinal;
            
            System.out.println("O preço atual da compra é: "+precoFinal);
        }
        System.out.print("O preço final da compra é: "+precoTotal);
    }
}