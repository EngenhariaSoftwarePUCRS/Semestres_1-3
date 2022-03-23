/*7. Um supermercado premia os clientes com cupons dependendo do quanto os mesmo gastaram nas compras. Por exemplo, se você gastar R$50,00, você irá receber um cupom com 8 por cento sobre o valor que você gastou. A tabela a seguir mostra os valores de cupons para os respectivos valores de compras.

VALOR                                       CUPOM
Menos que R$10                            Sem cupom
De R$10 até R$60                              8%
De R$60 até R$150                            10%
De R$150 até R$210                           12%
Mais que R$210                               14%
Escreva um programa que calcula e imprime o valor do cupom a partir do valor de gastos de um cliente. Exemplo:

Por favor, entre com o custo das suas compras: 14
Você ganhou um cupom de desconto no valor de R$1.12. (8% de desconto sobre o valor total de sua compra).
*/
import java.util.Scanner;
public class premioMercado {
    public static void main() {
        
        Scanner input = new Scanner(System.in);
        
        double desconto = 0;
        double gastos;
    
        System.out.println("Por favor, entre com o custo das suas compras: ");
        gastos = input.nextDouble();
        
        if (gastos < 0) {
            System.out.println("Erro. Favor contactar responsável");   
        } else if (gastos < 10) {
            System.out.println("Infelizmente, está compra não é elegível para descontos");
        } else {
            System.out.print("Eba! Você ganhou ");
            if (gastos >= 10 && gastos < 60) {
                desconto = 0.08;
                System.out.print(8);
            } else if (gastos >= 60 && gastos < 150) {
                desconto = 0.1;
                System.out.print(10);
            } else if (gastos >= 150 && gastos < 210) {
                desconto = 0.12;
                System.out.print(12);
            } else if (gastos >= 210) {
                desconto = 0.14;
                System.out.print(14);
            } else {
                System.out.println("Erro. Favor contactar responsável");
            }
            System.out.println("% de desconto!");
        }
        
        System.out.println("Isto equivale a "+desconto*gastos+" reais de desconto.");
    }
}