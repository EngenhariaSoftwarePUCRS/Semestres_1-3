import java.util.Scanner;
public class CaraOuCoroa {
    public static void main() {
        
        int valorLidoMoeda = 0;
        int valorLidoContinuar = 0;
        boolean valido = false;
        boolean continuar = false;
        boolean eCara = false;
        int qtdCara = 0;
        boolean eCoroa = false;
        int qtdCoroa = 0;
        boolean caiuDePe = false;
        int qtdCaiuDePe = 0;
        double valorMoeda = Math.round(Math.random());
        
        try (Scanner input = new Scanner(System.in)) {
            do {
                
                valorMoeda = Math.round(Math.random());
                
                do {
                    System.out.println("Cara(0) ou Coroa(1): ");
                    valorLidoMoeda = input.nextInt();
                    valido = ((valorLidoMoeda == 1) || (valorLidoMoeda == 0));
                } while (!valido);
                
                if (valorMoeda < 0.5) {
                    eCara = true;
                } else if (valorMoeda > 0.5) {
                    eCoroa = true;
                } else {
                    caiuDePe = true;
                }
                
                if ((eCara && valorLidoMoeda == 0) || (eCoroa && valorLidoMoeda == 1)) {
                    System.out.println("Parabéns, você acertou!");
                    
                    if (eCara)
                        qtdCara += 1;
                    if (eCoroa)
                        qtdCoroa += 1;
                    if (caiuDePe)
                        qtdCaiuDePe += 1;
                    
                } else {
                    System.out.println("Infelizmente não foi dessa vez.");
                }
                
                System.out.println("Deseja continuar?");
                do {
                    System.out.println("Não(0) ou Sim(1)");
                    valorLidoContinuar = input.nextInt();
                    continuar = (valorLidoContinuar == 1);
                    valido = ((valorLidoMoeda == 1) || (valorLidoMoeda == 0));
                } while (!valido);
                
            } while (continuar);
            
            System.out.println("A moeda caiu: ");
            System.out.print("\t"+qtdCara+" vez(es) cara, ");
            System.out.print("\t"+qtdCoroa+" vez(es) coroa, ");
            System.out.println(qtdCaiuDePe != 0 ? "\t" : "\t e "+qtdCaiuDePe+" vez(es) cara");
            System.out.println("Obrigado por jogar!");
            
        } catch (Exception e) {
            System.out.println("\nErro: "+e);
        }
    }
}
