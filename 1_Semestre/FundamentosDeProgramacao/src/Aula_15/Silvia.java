import java.util.Scanner;
public class Silvia {
    public static void main() {
        Scanner input = new Scanner(System.in);
        int[] valores = new int[51];
        valores[0] = 0;
        int
            menor = Integer.MAX_VALUE,
            maior = 0,
            media = 0,
            sumMedia = 0,
            entre0e10 = 0;
        boolean possible = true;
        
        for (int i = 1; i <= 50; i++) {
            System.out.print("Digite o "+i+"º valor (inteiro): ");
            try {
                valores[i] = input.nextInt();
                if (valores[i] < menor) {
                    menor = valores[i];
                }
                if (valores[i] > maior) {
                    maior = valores[i];
                }
                if ((valores[i] > 0) && (valores[i] <= 10)) {
                    entre0e10 += 1;
                }
                sumMedia += valores[i];
            } catch (Exception e) {
                System.out.println("Erro: "+e);
                possible = false;
                break;
            }
        }
        media = sumMedia/valores.length;
        
        if (possible) {
            System.out.println("\nMédia: "+media);
            System.out.println("Menor: "+menor);
            System.out.println("Maior: "+maior);
            System.out.println("Entre 0 e 10 haviam "+entre0e10+" valores.");
        }
    }
}