import java.util.Scanner;
public class rendMensal {
    public static void main() {
        Scanner input = new Scanner(System.in);
        
        double saldoInicial;
        double rendMensal;
        double saldoMes;
        
        System.out.println("Digite o seu saldo atual: ");
        saldoInicial = input.nextDouble();
        
        rendMensal = 0.05;
        saldoMes = saldoInicial*(1 + rendMensal);
        
        for (int index = 1; index <= 3; index++) {
            System.out.print("Seu saldo no mês "+index+" é: "+saldoMes+"\n");
            saldoMes = saldoMes*(1 + rendMensal);
        }
    }
}